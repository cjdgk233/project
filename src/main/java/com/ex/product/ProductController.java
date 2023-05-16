package com.ex.product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.book.BookService;
import com.ex.common.ViewPath;
import com.ex.discnt.DiscntService;
import com.ex.discnt.DiscntVO;
import com.ex.discntbox.DiscntBoxService;
import com.ex.discntbox.DiscntBoxVO;
import com.ex.hall.HallService;
import com.ex.hall.HallVO;
import com.ex.pricebox.PriceBoxService;
import com.ex.pricebox.PriceBoxVO;
import com.ex.round.RoundService;
import com.ex.round.RoundVO;
import com.ex.seatrate.SeatRateService;
import com.ex.theater.TheaterService;
import com.ex.theater.TheaterVO;

@Controller
public class ProductController {

	private ProductService productService;
	private SeatRateService seatRateService;
	private DiscntService discntService;
	private DiscntBoxService discntBoxService;
	private BookService bookService;
	private PriceBoxService priceBoxService;
	private RoundService roundService;
	private TheaterService theaterService;
	private HallService hallService;

	public ProductController(ProductService productService, SeatRateService seatRateService,
			DiscntService discntService, DiscntBoxService discntBoxService, BookService bookService,
			PriceBoxService priceBoxService, RoundService roundService,TheaterService theaterService,
			HallService hallService) {

		this.productService = productService;
		this.seatRateService = seatRateService;
		this.discntService = discntService;
		this.discntBoxService = discntBoxService;
		this.priceBoxService = priceBoxService;
		this.bookService = bookService;
		this.roundService = roundService;
		this.theaterService = theaterService;
		this.hallService = hallService;
	}

	@RequestMapping("/product/{p}")
	public String productPage(Model mo, @PathVariable("p") int productSeq, HttpServletRequest request) {
		

		ProductVO pvo = productService.findProduct(productSeq);
		
		
		HallVO hvo = hallService.findOneHall(pvo.getProductHall());
		
		mo.addAttribute("hvo", hvo);
	
		
		TheaterVO tvo =theaterService.findTheater(hvo.getHallTheater());
		
		mo.addAttribute("tvo", tvo);

		mo.addAttribute("pvo", pvo);
	

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

		for (int i : arrdiscnt) {
			if (i == 0) {

				continue;
			} else {

				System.out.println("arrdiscnt값 출력 : " + i);

				mapdiscnt.put("discnt", i);

				DiscntVO vo = discntService.findDiscnt(mapdiscnt);

				System.out.println("확인용 :" + vo.getDiscntName());

				discntList.add(vo);

			}

		}

		// 가격 출력 부분

		HashMap<String, Object> map = new HashMap<String, Object>();// hashmap객체 생성

		PriceBoxVO pbvo = priceBoxService.findPriceBox(productSeq);
		

		String name1 = seatRateService.findSeatRateName(pbvo.getPriceBoxSeatRate1());
		String name2 = seatRateService.findSeatRateName(pbvo.getPriceBoxSeatRate2());
		String name3 = seatRateService.findSeatRateName(pbvo.getPriceBoxSeatRate3());
		
		int cnt1= seatRateService.findSeatRateNum(pbvo.getPriceBoxSeatRate1());//좌석 개수
		int cnt2= seatRateService.findSeatRateNum(pbvo.getPriceBoxSeatRate2());
		int cnt3= seatRateService.findSeatRateNum(pbvo.getPriceBoxSeatRate3());
		
	
		map.put("name1", name1);
		map.put("name2", name2);
		map.put("name3", name3);

		map.put("price1", pbvo.getSeatRatePrice1());
		map.put("price2", pbvo.getSeatRatePrice2());
		map.put("price3", pbvo.getSeatRatePrice3());

		mo.addAttribute("discntList", discntList);
		mo.addAttribute("map", map);

	

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();// 현재 날짜

		cal.add(Calendar.DATE, 1); // 다음날(1일 후) 날짜 선택 폼에 기본설정 값을 위한 날짜를 가져온다.
		String resultDate = sdf.format(cal.getTime());
	

		mo.addAttribute("resultDate", resultDate);
		
		//특정 날짜의 작품의 회차 가져오기
		
		HashMap<String, Object> roundMap = new HashMap<String, Object>();
				
		roundMap.put("roundProduct", productSeq);

		roundMap.put("roundDate", resultDate);
		
		RoundVO roundvo =roundService.selectRoundOne(roundMap);
		
		mo.addAttribute("date", roundvo.getRoundTime());

		PriceBoxVO pricevo = priceBoxService.findPriceBox(productSeq);
		
		
		int[] SeatRateSeq = new int[3];
		
		

		HashMap<String, Object> priceMap =  new HashMap<String, Object>();
	
			priceMap.put("bookRound", roundvo.getRoundSeq());
			
		
			SeatRateSeq[0] = pricevo.getPriceBoxSeatRate1();
			SeatRateSeq[1] = pricevo.getPriceBoxSeatRate2();
			SeatRateSeq[2] = pricevo.getPriceBoxSeatRate3();
			
			int[] bookNum=new int[3];
	
			for(int i=0; i<bookNum.length; i++ ) {

				priceMap.put("bookSeatRate",SeatRateSeq[i]);
				bookNum[i] = bookService.countBook(priceMap); //해당 회차에 좌석 등급이 예약된 개수를 가져온다.
			
				System.out.println("예매개수 확인 : " + bookNum[i]);
			}
			
			
			mo.addAttribute("bookNum", bookNum);
			


		return ViewPath.PRODUCT + "productPage.jsp";

	}

}
