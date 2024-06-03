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
		if(m.getLogin_check().equals("1�α��μ���")) {
			System.out.println("1�α��μ��� ���� 4-7 execute LoginProAction.java");
			session.setAttribute("S_ID", m.getOra_id());
			session.setAttribute("S_NAME", m.getOra_name());
			session.setAttribute("S_LEVEL", m.getOra_level());
			mf = new MActionForward(); mf.setRedirect(true);
			mf.setPath(request.getContextPath()+"/main.ksmart_m");
		}else if(m.getLogin_check().equals("2�������ġ")) {
			System.out.println("2�������ġ ���� 4-7 execute LoginProAction.java");
   			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');");
	   		out.println("location.href='"+request.getContextPath()+"/main.ksmart_m';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
		}else if(m.getLogin_check().equals("3���̵����ġ")) {
			System.out.println("3���̵����ġ ���� 4-7 execute LoginProAction.java");
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('���̵� ��ġ���� �ʽ��ϴ�.');");
	   		out.println("location.href='"+request.getContextPath()+"/main.ksmart_m';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
		}
		return mf;
	}

}
