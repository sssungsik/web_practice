package kr.or.ksmart.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class LoginProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-7 execute LoginProAction.java");
		HttpSession session=request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + "<- id 4-7 execute LoginProAction.java");
		System.out.println(pw + "<- pw 4-7 execute LoginProAction.java");
		Mdao mdao = new Mdao();
		Member m = null;
		m = mdao.mLoginCheck(id, pw);
		MActionForward mf = null;
		if(m.getLogin_check().equals("1로그인성공")) {
			System.out.println("1로그인성공 조건 4-7 execute LoginProAction.java");
			session.setAttribute("S_ID", m.getOra_id());
			session.setAttribute("S_NAME", m.getOra_name());
			session.setAttribute("S_LEVEL", m.getOra_level());
			mf = new MActionForward(); mf.setRedirect(true);
			mf.setPath(request.getContextPath()+"/main.ksmart_m");
		}else if(m.getLogin_check().equals("2비번불일치")) {
			System.out.println("2비번불일치 조건 4-7 execute LoginProAction.java");
   			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('비밀번호가 일치하지 않습니다.');");
	   		out.println("location.href='"+request.getContextPath()+"/main.ksmart_m';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
		}else if(m.getLogin_check().equals("3아이디불일치")) {
			System.out.println("3아이디불일치 조건 4-7 execute LoginProAction.java");
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('아이디가 일치하지 않습니다.');");
	   		out.println("location.href='"+request.getContextPath()+"/main.ksmart_m';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
		}
		return mf;
	}

}
