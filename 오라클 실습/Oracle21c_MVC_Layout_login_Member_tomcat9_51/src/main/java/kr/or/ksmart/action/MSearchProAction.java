package kr.or.ksmart.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MSearchProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-6 execute MSearchProAction.java");
		String sk = request.getParameter("sk");
		String sv = request.getParameter("sv");
		System.out.println(sk + "<- sk 4-6 execute MSearchProAction.java");
		System.out.println(sv + "<- sv 4-6 execute MSearchProAction.java");
		Mdao mdao = new Mdao();
		List<Member> alm = mdao.mSearch(sk, sv);
		System.out.println(alm + "<- alm execute MListProAction.java");
		request.setAttribute("alm", alm);
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/msearch/m_search_list.jsp");
		return mf;
	}
}
