package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.forward.MActionForward;

public class MDeleteProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-5 execute MDeleteProAction.java");
		String send_id = request.getParameter("send_id");
		System.out.println(send_id + "<- send_id 4-3 execute MUpdateFormAction.java");
		Mdao mdao = new Mdao();
		mdao.mDelete(send_id);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Msearch/m_search_list.ksmart_m");
		//mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}
