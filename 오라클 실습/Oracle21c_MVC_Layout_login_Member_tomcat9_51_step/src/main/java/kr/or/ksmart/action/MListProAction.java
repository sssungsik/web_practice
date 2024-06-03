package kr.or.ksmart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MListProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("4-2 execute MListProAction.자바");
		Mdao mdao = new Mdao();
		List<Member> lm = mdao.mAllSelect();
		request.setAttribute("lm", lm);
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mlist/m_list.jsp");
		
		
		
		return mf;
	}

}
