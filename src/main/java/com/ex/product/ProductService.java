package com.ex.product;

import java.util.List;
import java.util.Map;

public class ProductService {

private ProductDAO productDao; //ProductDAO클래스 타입의 변수 productDao를 만든다.


	
	public ProductService(ProductDAO productDao) {
		//MemberService객체 생성시 매개변수로 MemberDAO클래스 타입의 객체를 받아 변수 memberDao를 초기
		//설정하는 MemberService클래스의 생성성자를 만든다.

		//메서드에 인터페이스 타입의 매개변수를 받는다면 발 매개변수에 익명 구현 객체를 넣을 수도 잇고 익명 구현
		//객체의 내용대로 다형성 구현이 가능하다.
	
		
		this.productDao =productDao;
	}
	


	public List<ProductVO> allProduct() {
		// TODO Auto-generated method stub
		return productDao.allProduct();
	}
	
	public int registProduct(ProductVO pvo) {
	
		return productDao.registProduct(pvo);
	}
	
	public ProductVO findProduct(int productSeq) {
	 return productDao.findProduct(productSeq);
	}
	
	public int getNextProductSeq() {
		return productDao.getNextProductSeq();
	}
	
	public int selectHallSeq(int productSeq) {
		
		return productDao.selectHallSeq(productSeq);
	}
	
	public ProductVO findProductRecode(int productSeq) {
		return productDao.findProductRecode(productSeq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return productDao.getTotal(map);
	}
//	
//	
	public List<ProductVO> selectList(Map<String, Object> map){
		List<ProductVO> list = productDao.selectList(map);
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}
	
	
	public List<ProductVO> fineProductHall(int hallSeq) {
		return productDao.fineProductHall(hallSeq);
	}
	
	public int updateProduct(ProductVO vo) {
		return productDao.updateProduct(vo);
	}
	
	public int deleteProdut(int productSeq) {
		return productDao.deleteProdut(productSeq);
	}
	
}