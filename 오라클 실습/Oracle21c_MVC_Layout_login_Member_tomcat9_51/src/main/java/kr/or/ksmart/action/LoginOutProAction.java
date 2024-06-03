package kr.or.ksmart.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.forward.MActionForward;

public class LoginOutProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-8 execute LoginOutProAction.java");
		HttpSession session=request.getSession();
		session.invalidate();
		response.setContentType("text/html;charset=euc-kr");
   		PrintWriter out=response.getWriter();
   		out.println("<script>");
   		out.println("alert('·Î±×¾Æ¿ô');");
   		out.println("location.href='"+request.getContextPath()+"/main.ksmart_m';");
   		out.println("</script>");
   		out.close();
		
		return null;
	}

}
