package com.increpas.ex;

import java.text.DateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.common.ViewPath;
import com.ex.product.ProductService;
import com.ex.product.ProductVO;


@Controller
public class HomeController {
	
	ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//이건 뭘까
	
	public HomeController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@RequestMapping("/")
	public String home(Locale locale, Model mo) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mo.addAttribute("serverTime", formattedDate );
		

		//ViewPath는 다른 패키지에 있기 때문에 import해줘야 한다.
		
		
		
		List<ProductVO> productList = productService.allProduct();
		
		System.out.println("작품 개수 : " + productList.size());
	
		mo.addAttribute("productList", productList);
		
		
	
		
//		for( ProductVO p :productList) {
//			
//			System.out.println(p.getProductImage());
//		}
		
		//Main/java에 컨트롤러 파일과 dao등의 파일을 넣는다.
		//Main/resource에 기타 파일을 넣는다.
		
		return ViewPath.MAIN + "index.jsp";
	}
	
	
}
