package com.ex.member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {

	private SqlSession sqlSession; // SqlSession 인터페이스 타입의 변수를 만든다.

	public MemberDAO(SqlSession sqlSession) {
		// MemberDAO클래스 객체 생성시 변수 sqlSession을 값을 초기 설정할
		// 수 있는 MemberDAO생성자를 만든다.

		// 생성자는 변수의 개수나 다양한 조건에 따라 여러개 만들 수 잇따.

		this.sqlSession = sqlSession;
	}

	// sql세션의 메서드를 직접 쓰는 역할은 dao에서
	// 하는것 같다.

	// sql의 반환값이나 매개값의 종류에 따라 디비에서는 같은 sql을 써도 자바에서
	// sql세션에서 쓰는 sql관련 메서드가 달라진다.(디비에서 쓰는 sql과는 이름이 비슷
	// 하지만 다르다.)

	// sql의 반환값이나 매개값의 종류에 따라 디비에서는 같은 sql을 써도 자바에서 sql세션인터페이스의 sql관련 메서드가 달라진다.
	// (디비에서 쓰는 sql과는 이름이 비슷하지만 다르다.)

	// Service클래스는 컨트롤러로 가기 전에 한단계 더 거치는 곳 같다.

	// 폼에서 받은 데이터들은 경로를 지정하면 해당 경로만 받는 컨트롤러의 RequestMapping어노터에션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 처리하게 된다.
	// 이 단계에서 디비에서 데이터 꺼내오기나 넣기를 dao의 메서드와 service의 메서드를 통해 하게 된다.

	// 폼에서 받은 데이터들은 경로를 지정하면 해당 경로만 받는 컨트롤러의 RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 처리하게 된다.
	// 이 단계에서 디비에서 데이터를 꺼내오거나 넣기를 dao의 메서드와 setvice의 메서드를 통해 하게 된다.
	// 즉 디비관련 처리를 ReqeustMapping오노테이션 밑의 메서드에서 하게 된다.
	// 그리고 추가로 처리를 다 한 데이터들을 model이나 requst에 담아 return을 통해 처리한 데이터를 보낼 경로를 지정하여 보낸다.

	// 폼에서 받은 데이터들은 action으로 경로를 지정하면 해당 경로만 받는 컨트롤러의 RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 처리하게 된다.
	// 디비관련 처리를 RequestMapping어노테이션 밑의 메서드에서 하게 되는데 디비에서 데이터를 꺼내오거나 넣기를
	// dao의 sqlSession인터페이스의 메서드와 service의 메서드를 통해 하게 된다.
	// 그리고 추가로 처리를 다 한 데이터들을 model이나 request에 담아 return을 통해 처리한 데이터를 보낼 경로를 지정하여
	// 보낸다.

	// 폼에서 받는 데이터들은 action으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비관련 처리나 그 밖의 처리들을 하게 된다.
	// 디비 관련 처리를 RequestMapping어노테이션 밑의 메서드에서 하게 되는데 이 과정에서 데이터를 디비에서 꺼내오거나 넣기를
	// dao의 sqlSession인터페이스의 메서드와 service의 메서드를 호출하여 하게 된다.

	// 폼에서 받는 데이터들은 action으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 dao의 sqlSession인터페이스의 메서드와
	// service의
	// 메서드를 호출하여 데이터를 디비에서 꺼내오거나 넣는 디비관련 처리를 하거나 그 밖의 처리들을 하게 된다.

	// 폼에서 받는 데이터들을 action으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비에서 꺼내오거 넣는 디비관련 처리를 할때
	// dao의 sqlSession인터페이스의 메서드와 service의 호출하여 처리하고 그 밖의 처리들을 하게 된다.

	// 폼에서 받는 데이터들을 action으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// RequestMapping어노테이션으로 가게 되고
	// RequestMapping어노테이션 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비에서 꺼내오거나 넣는 디비관련 처리를 하는데 각자의
	// 역할을
	// 분리시켜 실제 수행은 dao의 sqlSession이 mapper파일의 sql을 활용하여 하고 컨트롤러는 이 dao의 메서드를 호출하는
	// 형식으로 디비관련
	// 데이터를 처리한다.
	// dao는 sqlSession을 수항해난 역할..컨트롤러는 dao에서 껀내온 디비의 데이터를 가공학 jsp파일로 보내는
	// 역할...service는 중간 단계 정도..

	// 폼에서 받는 데이터들을 action속성으로 경로를 지정해서 submit을 하명 해당 경로로만 받는 컨트롤러의
	// ReqeustMapping어노테이션으로
	// 가게 되고 ReqeustMapping어노테이션의 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비에서 꺼내오거나 넣는 디비 관련 처리르
	// ㄹ하는데
	// 각자의 역할을 분리시켜 실제 수행은 dao의 sqlSession이 mapper파일의 sql을 활용하여 하고 컨트롤러는 이 dao의 메서드를
	// 호출하는
	// 형식으로 디비관련 처리를 한다.
	// dao는 sqlSession을 수행하는 역할..컨트롤러는 dao에서 꺼내온 디비의 데이터를 가공하여 jsp파일로 보내는
	// 역할..service는 중단 단계 정도

	// 폼에서 받는 데이터들을 action속성으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// ReqeustMapping어노테이션으로
	// 가게 되고 RequestMapping어노테이션의 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비에서 꺼내거나 넣는 디비 관련 처리를
	// 하는데
	// 각자의 역할을 분리시켜 실제 수행은 dao의 sqlSessio이 mapper파일의 sql을 활용하여 하고 컨트롤러는 이 dao의 메서드를
	// 호출하는
	// 형식으로 디비관련 처리를 한다.
	// dao는 sqlSession을 수해아는 역할..컨트롤러는 dao에서 꺼내온 디비의 데이터를 가공하여 jsp파일로 보내는
	// 역할..service는 중간 단계 정도

	// 폼에서 받는 데이터들을 action속성으로 경로를 지정해서 submit을 하면 해당 경로로만 받는 컨트롤러의
	// RequestMapping어노테이션으로
	// 가게 되고 RequestMapping어노테이션의 아래의 메서드에서 해당 경로로 들어온 데이터들을 디비에서 꺼내거나 넣는 디비 관련 처리를
	// 하는데
	// 각자의 역할을 분리시켜 실제 수행은 dao의 sqlSession이 mapper파일에 지정한 sql들의 이름을 활용하여 하고
	// 컨트롤러는 이 dao의 메서드를 호출하는 형식으로 디비관련 처리를 한다.
	// dao는 sqlSession을 수행하는 역할..컨트롤러는 dao에서 꺼내온 디비의 데이터를 가공하여 jsp파일로 보내는
	// 역할..service는 중간 단계 정도

	// sql수행은 dao의 sqlSession에서 하고 컨트롤러는 dao의 메서드를 호출하여 sql을 수행한 반환값을 가져오거나 메서드이
	// 매개변수로 제공해 넣는 역할...

	// sql수행은 dao의 sqlSession에서 하고 컨트롤러는 dao의 메서드를 호출하여 sql을 수행한 반환값을 가져오거나 메서드의
	// 매개변수로 제공해 넣는 역할..

	// sql수행은 dao의 slqSession에서 하고 컨트롤러는 dao의 메서드를 호출하여 sql을 수행한 반환값을 가져오거나 메서드의
	// 매개변수로 제공해 넣는 역할..

	// 디비를 잘 맞춰야 할거 같은데 디비를 필요한 변수들(칼럼들)하고 잘 맞춰야 할거 같은데 ..디비를 잘 만들려면 어떻게 해야 하지?

	// 다 받고 넣고 보여준다 이 과정 아닌가?

	// 폼으로 데이터 받아서 컨트롤러에서 dao를 호출해서 디비에 넣거나 처리하고 가져와서 model이나 request에 넣어서 return문에서
	// 보낼 경로 지정하면

	// 거기서 model에서 꺼내서 보여주는거 아닌가?

	// 폼으로 데이터 받아서 컨트롤ㄹ러에서 dao를 호출해서 디비에 넣거나 처리하고 반환받아서 model이나 request에 넣어서
	// return문에서 보낼 경로를
	// 지정하면 거기서 model에서 꺼내서 보여주는거 아닌가?

	// 폼의 name이랑 칼럼의 이름이랑 vo클래스의 변수와 mapper의 sql이랑 jsp파일을 잘 맞춰주면 되는 건가?

	// 파일이 vo dao 컨트롤러 컨텍스트들, mapper 디비 jsp 크게 이렇게 있다.

	// 컨텍스트는 dao, service, 컨트롤러의 빈 객체를 만드는 파일과 디비 관련 파일들이 있다.

	// jsp파일은 model이나 request에 담긴 데이터를 받아 프론트단에 나타내는 역할을 한다.

	// 디비에서 직접 데이터를 꺼내오는 sql을 작성하는 곳이 mapper파일

	// 로그인
	public int checkLogin(MemberVO vo) {

		int result = 0;

		try {
			result = sqlSession.selectOne("member.checkLogin", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 레코드를 하나만 가져올 것이므로 selectOne메서드를 사용한다.

		System.out.println("확인용" + result);

		return result;
	}

	// 아이디 찾기
	public String findId(MemberVO vo) {
		String id = "";

		try {

			id = sqlSession.selectOne("member.findId", vo);

			System.out.println("dao find id : " + id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	// 비밀번호 찾기

	public String findPw(MemberVO vo) {

		String pw = "";

		try {

			pw = sqlSession.selectOne("member.findPw", vo);

			System.out.println("dao find pw : " + pw);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pw;
	}

	public MemberVO findMember(int memberSeq) {

		MemberVO m = null;
		try {

			m = sqlSession.selectOne("member.findMember", memberSeq);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;

	}

	public int updatePw(HashMap<String, Object> map) {
		int num = 0;

		try {

			num = sqlSession.update("member.updatePw", map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;

	}

	public int deleteMember(int memberSeq) {
		int num = 0;
		try {
			num = sqlSession.update("member.deleteMember", memberSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	public int updateMember(MemberVO mvo) {

		int num = 0;
		try {
			num = sqlSession.update("member.updateMember", mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	public int joinMember(MemberVO mvo) {

		int num = 0;

		try {
			num = sqlSession.insert("member.joinMember", mvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public int getNextMemberSeq() {
		int num = 0;
		try {

			sqlSession.selectOne("member.getNextMemberSeq");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public int checkAdmin(int memberSeq) {

		int num = 0;

		try {
			num = sqlSession.selectOne("member.checkAdmin", memberSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(num);
		return num;

	}

	public List<MemberVO> allMember() {

		List<MemberVO> list = null;

		try {
			list = sqlSession.selectList("member.allMember");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
