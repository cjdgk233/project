package com.ex.book;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.common.ViewPath;
import com.ex.common.ViewResult;
import com.ex.discnt.DiscntService;
import com.ex.discnt.DiscntVO;
import com.ex.discntbox.DiscntBoxService;
import com.ex.discntbox.DiscntBoxVO;
import com.ex.hall.HallService;
import com.ex.hall.HallVO;
import com.ex.pricebox.PriceBoxService;
import com.ex.pricebox.PriceBoxVO;
import com.ex.product.ProductService;
import com.ex.product.ProductVO;
import com.ex.round.RoundService;
import com.ex.round.RoundVO;
import com.ex.seat.SeatService;
import com.ex.seat.SeatVO;
import com.ex.seatrate.SeatRateService;
import com.ex.seatrate.SeatRateVO;

@Controller
public class BookController {

	private BookService bookService;
	private RoundService roundService;
	private SeatRateService seatRateService;
	private ProductService productService;
	private SeatService seatService;
	private DiscntService discntService;
	private DiscntBoxService discntBoxService;
	private HallService hallService;
	private PriceBoxService priceBoxService;

	// 생성자 인젝션
	public BookController(SeatService seatService, BookService bookService, RoundService roundService,
			ProductService productService, SeatRateService seatRateService, DiscntService discntService,
			DiscntBoxService discntBoxService, HallService hallService, PriceBoxService priceBoxService) {
		this.bookService = bookService;
		this.roundService = roundService;
		this.productService = productService;
		this.seatRateService = seatRateService;
		this.seatService = seatService;
		this.discntService = discntService;
		this.discntBoxService = discntBoxService;
		this.hallService = hallService;
		this.priceBoxService = priceBoxService;
	}

	// 회차 출력 부분
	@RequestMapping("/book/changedate")
	@ResponseBody
	public List<RoundVO> changeDate(Model mo, String roundDate, String todayLabel, int productSeq,
			HttpServletRequest request) {

		request.getSession().setAttribute("todayLabel", todayLabel);

		int HallSeq = productService.selectHallSeq(productSeq);

		System.out.println("HallSeq : " + HallSeq);

	
        //map에 productSeq,HallSeq,roundDate 를 담아 round테이블을 조회한다.
		HashMap<String, Object> map = new HashMap<>();

		map.put("roundProduct", productSeq);
		map.put("roundHall", HallSeq);
		map.put("roundDate", roundDate);

		System.out.println(map.get("roundProduct"));
		System.out.println(map.get("roundHall"));
		System.out.println(map.get("roundDate"));

		List<RoundVO> list = roundService.selectRound(map); 

		return list; 
	}

	//bookSetp 2로 이동 - 좌석 선택
	@RequestMapping("/book/bookstep2Form/{productSeq}")
	public String pageBookStep2(Model mo, @PathVariable("productSeq") int productSeq ,HttpServletRequest request) {
		
		
		System.out.println(request.getParameter("roundSeq")); 
		
		String roundSeq = request.getParameter("roundSeq");

		mo.addAttribute("productSeq", productSeq);
		
		mo.addAttribute("roundSeq", roundSeq);

		return ViewPath.BOOK + "bookStep2.jsp";
	}

	@RequestMapping("/book/seat")
	@ResponseBody
	public int[] changeDate(int roundSeq) {
		
		List<BookVO> bookSeat = bookService.selectBookProduct(roundSeq);

		int[] seatArr = new int[bookSeat.size()];

		int cnt = 0;
		for (BookVO vo : bookSeat) {

			System.out.println("예매된 좌석 번호 : " + vo.getBookSeat()); // 예매내역의 좌석번호를 가져온다

			seatArr[cnt] = vo.getBookSeat();
			System.out.println(seatArr[cnt]);

			cnt++;

			System.out.println(cnt);

		}

		return seatArr;
	}

	
	//bookStep3로 이동
	@RequestMapping("/book/bookstep3Form/{productSeq}")
	public String pageBookStep3(Model model, @RequestParam(value = "seatSeq", required = false) Integer[] seatSeq,
			HttpServletRequest request, @PathVariable("productSeq") int productSeq) {
		

		HallVO hvo = new HallVO();

		int hallSeq = productService.selectHallSeq(productSeq);

		HashMap<String, Object> mapSeat = new HashMap<String, Object>();

		PriceBoxVO pvo = priceBoxService.findPriceBox(productSeq);

		List<SeatVO> seatList = new ArrayList<SeatVO>();
		
		

		for (int i = 0; i < seatSeq.length; i++) {

			System.out.println("좌석 번호 : " + seatSeq[i]);

			SeatVO seatvo = seatService.selectSeat(seatSeq[i]);// 좌석 번호와 좌석 등급으로 seatRatename이 포함된
			// seat테이블의 레코드를 반환받는다.
			seatList.add(seatvo);

			if (seatSeq[i] <= 50) { // 좌석 번호에 따라 등급을 다르게 매겨 map에 SeatRate라는 이름으로 저장한다.
				hvo = hallService.findHallWithHallSeq(hallSeq);

				SeatRateVO svo = new SeatRateVO();

				svo = seatRateService.findSeatRate(hvo.getHallSeatRate1());

				mapSeat.put("seatRateName", svo.getSeatRateName());

				mapSeat.put("price", pvo.getSeatRatePrice1());

				mapSeat.put("seatRateSeq", pvo.getPriceBoxSeatRate1());// 좌석seq 저장
				


			} else if (seatSeq[i] <= 100) {

				hvo = hallService.findHallWithHallSeq(hallSeq);

				SeatRateVO svo = new SeatRateVO();

				svo = seatRateService.findSeatRate(hvo.getHallSeatRate2());

				mapSeat.put("seatRateName", svo.getSeatRateName());

				mapSeat.put("price", pvo.getSeatRatePrice2());
				
				mapSeat.put("seatRateSeq", pvo.getPriceBoxSeatRate2());// 좌석seq 저장

			} else if (seatSeq[i] <= 150) {
				hvo = hallService.findHallWithHallSeq(hallSeq);

				SeatRateVO svo = new SeatRateVO();

				svo = seatRateService.findSeatRate(hvo.getHallSeatRate3());


				mapSeat.put("seatRateName", svo.getSeatRateName());


				mapSeat.put("price", pvo.getSeatRatePrice3());
				mapSeat.put("seatRateSeq", pvo.getPriceBoxSeatRate3());// 좌석seq 저장

			}

		}
	

		// 좌석의 층,열,번호 출력부분 - 좌석 seq로 가져올 수 있다.
		for (int i = 0; i < seatSeq.length; i++) {

			SeatVO vo = null;

			mapSeat.put("seatSeq", seatSeq[i]);

			vo = seatService.selectSeat(seatSeq[i]);// seatSeq로 좌석 등급을 반환받기 위한 메서드

			System.out.println("좌석 층 확인: " + vo.getSeatZone());

			mapSeat.put("svo", vo);

		}

		int[] arrdiscnt = new int[5];
		// 할인부분 출력

		DiscntBoxVO dcboxvo = discntBoxService.findDiscntSeq(productSeq);

		arrdiscnt[0] = dcboxvo.getDiscnt1();
		arrdiscnt[1] = dcboxvo.getDiscnt2();
		arrdiscnt[2] = dcboxvo.getDiscnt3();
		arrdiscnt[3] = dcboxvo.getDiscnt4();
		arrdiscnt[4] = dcboxvo.getDiscnt5();

		HashMap<String, Object> mapdiscnt = new HashMap<String, Object>();

		mapdiscnt.put("productSeq", productSeq);

		List<DiscntVO> discntList = new ArrayList<DiscntVO>();

		for (int a : arrdiscnt) {
			if (a == 0) {

				continue;
			} else {


				mapdiscnt.put("discnt", a);

				DiscntVO dvo = discntService.findDiscnt(mapdiscnt);

				discntList.add(dvo);

			}

		}

		int roundSeq = (int) request.getSession().getAttribute("roundSeq"); // 회차 번호


		RoundVO roundVo = roundService.findRound(roundSeq); //회차번호로 round테이블의 레코드를 가져온다.

		ProductVO productvo = productService.findProductRecode(productSeq);



		String productName = productvo.getProductName();

		String todayLabel = (String) request.getSession().getAttribute("todayLabel");

		model.addAttribute("discntList", discntList);
		model.addAttribute("seatList", seatList);
		
		model.addAttribute("productSeq", productSeq);
		model.addAttribute("roundVo", roundVo);
		model.addAttribute("todayLabel", todayLabel);
		model.addAttribute("mapSeat", mapSeat);
		model.addAttribute("productvo", productvo);
		
		model.addAttribute("seatCnt", seatSeq.length);

		return ViewPath.BOOK + "bookStep3.jsp";
	}

		
	@RequestMapping("/book/cart")
	public String selectDiscnt() {

		return ViewPath.BOOK + "cart.jsp";
	}
	
	
	
	//결제 부분
	@RequestMapping("/book/payMent/{roundSeq}/{productSeq}/{seatRateSeq}/{productName}")
	public String payMent(Model mo, BookVO bvo,@PathVariable("roundSeq") int roundSeq, HttpServletRequest request,
			@PathVariable("productSeq") int productSeq, @PathVariable("seatRateSeq")int seatRateSeq, 
			@PathVariable("productName")String bookProductName) {

		int bookProduct = productSeq;
		
		

		int memberSeq = (int) request.getSession().getAttribute("login");
		

        LocalDate now = LocalDate.now();
       
       
        // 날짜 포맷 정하기
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        java.sql.Date bookPayDate = java.sql.Date.valueOf(now);
        
		bvo.setBookProduct(bookProduct);
		bvo.setBookMember(memberSeq);
		bvo.setBookRound(roundSeq);
		bvo.setBookSeatRate(seatRateSeq);
		bvo.setBookProductName(bookProductName);
		bvo.setBookPayDate(bookPayDate);
		
		int number = bookService.insertBook(bvo);

		System.out.println("인서트 행 개수 " + number);

		if (number != 0) {

			ViewResult.setData(mo, "/ex/book/bookStep3", "예매 되었습니다.");

		} else {

			ViewResult.setData(mo, "/ex/book/bookStep3", "예매가 되지 않았습니다. 다시 확인해 주세요");
		}

		return ViewPath.COMMON + "result.jsp";
	}

	//예매내역 삭제 부분
	@RequestMapping("/book/deleteBook")
	@ResponseBody
	public String deleteBook(int bookSeq) {

		int num = bookService.updateDeleteBook(bookSeq);
		
		String result ="";
		if(num != 0) {
			result = "예매 취소 되었습니다.";
			
		}else {
			
			result = "예매가 취소에 실패했습니다.";
		}

		return result ;
	}
}
