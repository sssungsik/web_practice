package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MInsertProAction implements MActionInterFace {

	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-1 execute 실행");
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		System.out.println("아이디 : " + ora_id +"비번 : " +ora_pw  +"레벨 : "+ ora_level  +"이름 : "  + ora_name  +"메일: " +  ora_email );
		
		Member m = new Member();
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		System.out.println(m + " ------ MinsertProAction 실행");
		
		Mdao mdao = new Mdao();
		mdao.mInsert(m); // 호출 후 가입처리완료
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath() + "/Mlist/m_list.ksmart_m");
		
		
		
		
		return mf;
	}

}
