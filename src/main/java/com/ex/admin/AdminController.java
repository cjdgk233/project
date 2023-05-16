package com.ex.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ex.book.BookService;
import com.ex.book.BookVO;
import com.ex.common.Paging;
import com.ex.common.ViewPath;
import com.ex.common.ViewResult;
import com.ex.discnt.DiscntService;
import com.ex.discnt.DiscntVO;
import com.ex.discntbox.DiscntBoxService;
import com.ex.discntbox.DiscntBoxVO;
import com.ex.hall.HallService;
import com.ex.hall.HallVO;
import com.ex.member.MemberService;
import com.ex.member.MemberVO;
import com.ex.pdType.PdTypeService;
import com.ex.pdType.PdTypeVO;
import com.ex.pricebox.PriceBoxService;
import com.ex.pricebox.PriceBoxVO;
import com.ex.product.ProductService;
import com.ex.product.ProductVO;
import com.ex.round.RoundService;
import com.ex.round.RoundVO;
import com.ex.seatrate.SeatRateService;
import com.ex.seatrate.SeatRateVO;
import com.ex.theater.TheaterService;
import com.ex.theater.TheaterVO;

@Controller
public class AdminController {

	private ProductService productService;
	private PdTypeService pdTypeService;
	private HallService hallService;
	private SeatRateService seatRateService;
	private RoundService roundService;
	private TheaterService theaterService;
	private DiscntService discntService;
	private DiscntBoxService discntBoxService;
	private PriceBoxService priceBoxService;
	private MemberService memberService;
	private BookService bookService;

	public AdminController(ProductService productService, PdTypeService pdTypeService, HallService hallService,
			SeatRateService seatRateService, RoundService roundService, TheaterService theaterService,
			DiscntService discntService, DiscntBoxService discntBoxService, PriceBoxService priceBoxService
			,MemberService memberService, BookService bookService) { // 생성자
																												// 인젝션

		this.productService = productService;
		this.pdTypeService = pdTypeService;
		this.hallService = hallService;
		this.seatRateService = seatRateService;
		this.roundService = roundService;
		this.theaterService = theaterService;
		this.priceBoxService = priceBoxService;
		this.discntService = discntService;
		this.discntBoxService = discntBoxService;
		this.memberService = memberService;
		this.bookService= bookService;
	}

	// 회차 등록폼으로 이동
	@RequestMapping("/admin/registRoundForm")
	public String registRoundForm(Model mo) {
		
		List<ProductVO> productList = productService.allProduct();

		List<HallVO> hallList = hallService.allHall();

		mo.addAttribute("hallList", hallList);

		mo.addAttribute("productList", productList);

		return ViewPath.ADMIN + "registRoundForm.jsp";
	}

	@RequestMapping("/admin/changeHall")
	@ResponseBody
	public List<ProductVO> changeHall(int hallSeq, Model model) {
	
		//같은 홀seq를 사용하는 작품 리스트를 반환한다.
		List<ProductVO> list = productService.fineProductHall(hallSeq);

		return list;
	}

	// 회차 등록
	@RequestMapping("/admin/registRound")
	public String registRound(@RequestParam("roundProduct") int roundProduct, @RequestParam("roundHall") int roundHall,
			@RequestParam("roundDate") String roundDate, @RequestParam("roundTime") String roundTime, RoundVO rvo,
			Model mo) throws ParseException {
		
		int num = 0;

		String roundDeadLine = "";

		if (roundTime != null) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = sdf.parse(roundDate);// Date타입 객체로 파싱

			Calendar cal = Calendar.getInstance();// 날짜 연산을 위한 Calendar객체 생성
			cal.setTime(date);// Calendar클래스의 메서드 setTime을 호출한다.

			cal.add(Calendar.DATE, -7); // 7일 빼기
			System.out.println("7일 빼기: " + sdf.format(cal.getTime()));
			// Java에서는 Date 클래스와 String 클래스 사이에 파싱을 도와주는 SimpleDateFormat 클래스가 있다.

			roundDeadLine = sdf.format(cal.getTime());
			System.out.println("deadline : " + roundDeadLine);

		}
		// RoundVO에 데이터 넣는 부분
		rvo.setRoundProduct(roundProduct);
		rvo.setRoundHall(roundHall);
		rvo.setRoundDate(roundDate);
		rvo.setRoundTime(roundTime);
		rvo.setRoundDeadLine(roundDeadLine);


		num = roundService.insertRound(rvo);

		System.out.println("회차 등록 : " + num);

	

		if (num != 0) {

			ViewResult.setData(mo, "/ex/admin/registRoundForm", "회차가 등록되었습니다.");

			//회차를 찾기위한 메서드에 필요한 값들을 map에 담는다.
			HashMap<String, Object> map = new HashMap<>();
			map.put("roundProduct", roundProduct);
			map.put("roundHall", roundHall);
			map.put("roundDate", roundDate);
			
			List<RoundVO> Roundlist = roundService.selectRound(map);

		} else {

			ViewResult.setData(mo, "/ex/admin/registRoundForm", "회차가 등록되지 않았습니다.");

		}

		return ViewPath.COMMON + "result.jsp";

	}

	//공연장 등록 폼으로 이동
	@RequestMapping("/admin/registTheaterForm")
	public String registTheaterForm() {

		return ViewPath.ADMIN + "registTheaterForm.jsp";
	}

	//공연장 등록
	@RequestMapping("/admin/registTheater")
	public String registTheater(TheaterVO vo, Model model) {

		int theaterSeq = theaterService.getTheaterSeq();
		
		vo.setTheaterSeq(theaterSeq);

		if (vo.getTheaterLatitude() == 0) {

			vo.setTheaterLatitude(0);
		} else if (vo.getTheaterLongitude() == 0) {

			vo.setTheaterLongitude(0);
		}

		// 공연장 등록
		int num = theaterService.inputTheater(vo);
		
		// 공연홀 등록

		if (num != 0) {

			ViewResult.setData(model, "/ex/admin/registTheaterForm", vo.getTheaterName() + " 극장이 등록되었습니다.");
		} else {
			ViewResult.setData(model, "/ex/admin/registTheaterForm", "극장이 등록되지 않았습니다.");
		}

		return ViewPath.COMMON + "result.jsp";
	}

	//공연홀 등록 폼으로 이동
	@RequestMapping("/admin/registHallForm")
	public String registHallForm(Model mo) {

		List<TheaterVO> theaterlist = theaterService.allTheater();

		List<SeatRateVO> seatrateList = seatRateService.allSeatrate();

		mo.addAttribute("theaterlist", theaterlist);
		mo.addAttribute("seatrateList", seatrateList);

		return ViewPath.ADMIN + "registHallForm.jsp";
	}

	//할인 등록 폼으로 이동
	@RequestMapping("/admin/registDiscountForm")
	public String registDiscountForm(Model mo) {

		List<DiscntVO> discntList = discntService.allDiscnt();

		List<TheaterVO> theaterlist = theaterService.allTheater();

		List<SeatRateVO> seatrateList = seatRateService.allSeatrate();

		mo.addAttribute("theaterlist", theaterlist);
		mo.addAttribute("discntList", discntList);

		return ViewPath.ADMIN + "registDiscountForm.jsp";
	}

	//할인 등록
	@RequestMapping("/admin/registDiscount")
	public String registDiscount(Model mo, DiscntBoxVO vo) {
		
		int num = discntBoxService.insertDiscntBox(vo);

		System.out.println("작품에 할인 등록 " + num);

		if (num != 0) {

			ViewResult.setData(mo, "/ex/admin/registDiscountForm", "할인이 등록되었습니다.");

		} else {

			ViewResult.setData(mo, "/ex/admin/registDiscountForm", "할인이 등록되지 않았습니다");
		}

		List<TheaterVO> theaterlist = theaterService.allTheater();
		List<SeatRateVO> seatrateList = seatRateService.allSeatrate();

		mo.addAttribute("theaterlist", theaterlist);
		mo.addAttribute("seatrateList", seatrateList);

		return ViewPath.COMMON + "result.jsp";
	}

	@RequestMapping("/admin/registHall")
	public String registHall(Model mo, HallVO vo) {

	
		int hallSeq = hallService.getHallSeq();

		vo.setHallSeq(hallSeq);// 홀 시퀀스 저장

		if (vo.getHallSeatRate1() == 0) {
			vo.setHallSeatRate1(0);
		} else if (vo.getHallSeatRate2() == 0) {
			vo.setHallSeatRate2(0);
		} else if (vo.getHallSeatRate3() == 0) {
			vo.setHallSeatRate3(0);
		}

		int hallNum = hallService.insertHall(vo);

	
		if (hallNum != 0) {

			ViewResult.setData(mo, "/ex/admin/registHallForm", vo.getHallName() + " 공연홀이 등록되었습니다.");
		} else {

			ViewResult.setData(mo, "/ex/admin/registHallForm", "공연홀이 등록되지 않았습니다");

		}
		return ViewPath.COMMON + "result.jsp";
	}

	
	@RequestMapping("/admin/changeTheater")
	@ResponseBody
	public List<HallVO> changeTheater(int theaterSeq) {

		
		List<HallVO> hallList = hallService.findHall(theaterSeq);


		return hallList;

	}

	
	@RequestMapping("/admin/changeHall2")
	@ResponseBody
	public List<ProductVO> changeHall2(int hallSeq) {

		List<ProductVO> productList = productService.fineProductHall(hallSeq);

		return productList;

	}

	@RequestMapping("/admin/registDiscnt2")
	@ResponseBody
	public String registDiscnt2(String discntName, int discntDetail) {

		System.out.println(discntName);
		System.out.println(discntDetail);

		int discntSeq = discntService.getNextDiscntSeq();

		System.out.println(discntSeq);

		DiscntVO vo = new DiscntVO(); 

		vo.setDiscntDetail(discntDetail);
		vo.setDiscntName(discntName);
		vo.setDiscntSeq(discntSeq);

		int num = discntService.insertDiscnt(vo);

		return "";
	}

	//공연 수정
	@RequestMapping("/admin/updateProductForm/{p1}")
	public String updateProductForm(@PathVariable("p1") int productSeq, Model model) {


		ProductVO pvo = productService.findProductRecode(productSeq);
		
		model.addAttribute("pvo", pvo);

		return ViewPath.ADMIN + "updateProductForm.jsp";

	}
	
	@RequestMapping("/admin/updateProduct/{p1}")
	public String updateProduct(ProductVO pvo, HttpServletRequest request,@PathVariable("p1") int productSeq) {
		
		
		System.out.println(productSeq);
		
		pvo.setProductSeq(productSeq);
		ProductVO originalPvo = productService.findProductRecode(productSeq);

	
		// 회원정보 수정 처리
		
	

	String address = "/ex/admin/updateProductForm/"+ productSeq;
	
	
		
		if (pvo.getProductName().equals(originalPvo.getProductName())) {

			ViewResult.setData(request, address, "이미 등록된 이름입니다.");

		} else if (pvo.getProductRate().equals(originalPvo.getProductRate())) {

			ViewResult.setData(request, address, "이미 등록된 작품등급입니다.");
		} else {

			ViewResult.setData(request, address, "작품 정보가 변경되었습니다.");
		}

		int su = productService.updateProduct(pvo);

		System.out.println(su);
		
		return ViewPath.COMMON + "result.jsp";
		
	}
	
	
	@RequestMapping("/admin/delete/{p1}")
	public String updateProductForm(@PathVariable("p1") int productSeq, Model model, HttpServletRequest request) {


		ProductVO pvo = productService.findProductRecode(productSeq);
		
		if (pvo == null ) {

			ViewResult.setData(request, "/ex/admin/productList", "이미 삭제된 작품입니다.");

		} else {
			
			int num =productService.deleteProdut(productSeq); 
			
			ViewResult.setData(request, "/ex/admin/productList", pvo.getProductName()+"이 삭제되었습니다.");
			
			
		}

		return ViewPath.COMMON + "result.jsp";

	}
	
	@RequestMapping("/admin/result")
	public String payment() {
		
		return ViewPath.ADMIN + "centerResult.jsp";
	}
	
	
	//회원리스트 페이지로 이동
	@RequestMapping("/admin/member/memberList")
	public String memberList(Model mo) {
		
		List<MemberVO> memberList = memberService.allMember();
		
		mo.addAttribute("memberList", memberList);
		
		return ViewPath.ADMINMEMBER+"memberList.jsp";
	}
	
	//예약 내역으로 이동
	@RequestMapping("/admin/book/bookList")
	public String bookList(Model mo) {
		
		List<BookVO> bookList = bookService.allBook();
		
		mo.addAttribute("bookList", bookList);
		
		return ViewPath.ADMINBOOK+"bookList.jsp";
	}
	

	// 작품 리스트로 이동
	@RequestMapping("/admin/productList")
	public String productList(Model mo, Integer page, String type, String word) {


		type = "".equals(type) ? null : type;// type이 빈 문자열이면 null값으로 바꿔치기 한다.
		int pdTypeNum = 0;

		HashMap<String, Object> map = new HashMap<String, Object>(); 
		map.put("type", type); // type은 검색종류이고 word는 검색어
		map.put("word", word);

		if (page == null) {
			page = 1;
		}

		int productCount = productService.getTotal(map);
		
		//common퍀지의 Paging참고
		Paging paging = new Paging(page, productCount);// 페이징 객체를 생성하여 매개변수로 page와 총작품 개수를 넣는다

		map.put("first", paging.getFirst());

		map.put("last", paging.getLast());// 0

		List<ProductVO> pdList = productService.selectList(map);
		
		mo.addAttribute("pdList", pdList);
		mo.addAttribute("paging", paging);

		

		return ViewPath.ADMIN + "productList.jsp";
	}

	// 작품등록폼으로 이동
	@RequestMapping("/admin/registProductForm")
	public String registForm(Model mo) {

		List<PdTypeVO> pdTypeList = pdTypeService.allPdtype();

		List<HallVO> hallList = hallService.allHall();

		List<SeatRateVO> seatrateList = seatRateService.allSeatrate();

		mo.addAttribute("pdTypeList", pdTypeList);

		mo.addAttribute("hallList", hallList);

		mo.addAttribute("seatrateList", seatrateList);

		return ViewPath.ADMIN + "registProduct.jsp";
	}

	// 작품등록
	@RequestMapping("/admin/registProduct")
	public String registProduct(ProductVO pvo, HttpServletRequest request, @RequestParam("file") MultipartFile file) {

		
		System.out.println("작품 시퀀스 : " + pvo.getProductPdType());

		// 지정된 경로로 파일 저장하는 부분
		String OriginalName = file.getOriginalFilename(); // MultipartFile인터페이스의 인스턴스 메서드 getOriginalFilename를 호출한다.
		// MultipartFile인터페이스의 메서드 getOriginalFilename메서드는 파일 이름을 String값으로 반환한다.

		int productSeq = productService.getNextProductSeq();

		String productImage = productSeq + ".poster_" + OriginalName;
		String uploadFolder = ViewPath.FILEROOT + "poster";
		pvo.setProductImage(productImage); 

		File saveFile = new File(uploadFolder + "\\" + productImage);

		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int registnum = productService.registProduct(pvo); // 폼의 값과 이미지 경로가 저장된 ProductVO를 디비에 저장한다

		List<ProductVO> productList = productService.allProduct();


		// 가격 넣는 부분
		PriceBoxVO vo = new PriceBoxVO();

		vo.setPriceBoxProduct(productSeq); // SeatRatePrice1

		vo.setPriceBoxSeatRate1(pvo.getPriceBoxSeatRate1());
		vo.setSeatRatePrice1(pvo.getSeatRatePrice1());

		vo.setPriceBoxSeatRate2(pvo.getPriceBoxSeatRate2());
		vo.setSeatRatePrice2(pvo.getSeatRatePrice2());

		vo.setPriceBoxSeatRate3(pvo.getPriceBoxSeatRate3());
		vo.setSeatRatePrice3(pvo.getSeatRatePrice3());

		int pricenum = priceBoxService.insertPriceBox(vo);
		System.out.println("priceBox 등록 : " + pricenum);

		if (registnum != 0 && pricenum != 0) {

			ViewResult.setData(request, "/ex/admin/registProductForm", pvo.getProductName() + "작품이 등록되었습니다.");

		} else {

			ViewResult.setData(request, "/ex/admin/registProductForm", "작품이 등록되지 않았습니다");

		}

		return ViewPath.COMMON + "result.jsp";
	}

	@RequestMapping("admin/changeProductHall")
	@ResponseBody
	public List<SeatRateVO> changeHall3(int productHall) {

		System.out.println("productHall : " + productHall);

		HallVO vo = hallService.findHallWithHallSeq(productHall);
		
		int[] arr = new int[3];

		arr[0] = vo.getHallSeatRate1();
		arr[1] = vo.getHallSeatRate2();
		arr[2] = vo.getHallSeatRate3();

		List<SeatRateVO> SeatRateList = new ArrayList<SeatRateVO>();



		for (int i : arr) {

			SeatRateVO svo = seatRateService.findSeatRate(i);

			System.out.println(svo.getSeatRateName());

			SeatRateList.add(svo);

		} // for문 end

		return SeatRateList;
	}
	
	

}
