package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MUpdateFormAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-3 execute MUpdateFormAction.java");
		String send_id = request.getParameter("send_id");
		System.out.println(send_id + "<- send_id 4-3 execute MUpdateFormAction.java");
		Mdao mdao = new Mdao();
		Member m = mdao.mSelectforUpdate(send_id);
		System.out.println(m + "<- m 4-3 execute MUpdateFormAction.java");

		request.setAttribute("m", m);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mupdate/m_update_form.jsp");
		
		return mf;
	}

}
