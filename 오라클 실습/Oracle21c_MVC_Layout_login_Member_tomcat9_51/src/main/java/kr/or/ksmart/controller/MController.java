package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.action.LoginOutProAction;
import kr.or.ksmart.action.LoginProAction;
import kr.or.ksmart.action.MDeleteProAction;
import kr.or.ksmart.action.MInsertProAction;
import kr.or.ksmart.action.MListProAction;
import kr.or.ksmart.action.MSearchProAction;
import kr.or.ksmart.action.MUpdateFormAction;
import kr.or.ksmart.action.MUpdateProAction;
import kr.or.ksmart.forward.MActionForward;

public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MController() {
        super();
    }
    protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("2 doPro MController.java");
    	String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI MController.java");
		System.out.println(contextPath + "<-- contextPath MController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() MController.java");
		System.out.println(command + "<-- command MController.java");
		System.out.println("----------MController.java----------------");
		System.out.println();
		MActionForward forward = null;
		MActionInterFace action = null;
		if(command.equals("/Min/m_insert_form.ksmart_m")) {
			System.out.println("3-1 /Min/m_insert_form.ksmart_m ���ǹ� ����");
			forward = new MActionForward();
			forward.setRedirect(false); 	//isRedirect �������� �ʱⰪ�� false�̱� ������ �ǹ̾��� �ڵ�
			forward.setPath("/minsert/m_insert_form.jsp");
			System.out.println(forward + "<- forward ��ü��������");
		}else if(command.equals("/Min/m_insert_pro.ksmart_m")) {
			System.out.println("3-2 /Min/m_insert_pro.ksmart_m ���ǹ� ����");
			action = new MInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Mlist/m_list.ksmart_m")) {
			System.out.println("3-3 /Mlist/m_list.ksmart_m ���ǹ� ����");
			action = new MListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Mup/m_update_form.ksmart_m")) {
			System.out.println("3-4 /Mup/m_update_form.ksmart_m ���ǹ� ����");
			action = new MUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Mup/m_update_pro.ksmart_m")) {
			System.out.println("3-5 /Mup/m_update_pro.ksmart_m ���ǹ� ����");
			action = new MUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Mdel/m_delete_pro.ksmart_m")) {
			System.out.println("3-6 /Mdel/m_delete_pro.ksmart_m ���ǹ� ����");
			action = new MDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Msearch/m_search_list.ksmart_m")) {
			System.out.println("3-7 /Msearch/m_search_list.ksmart_m ���ǹ� ����");
			action = new MSearchProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/main.ksmart_m")) {
			System.out.println("3-8 /main.ksmart_m ���ǹ� ����");
			forward = new MActionForward();
			forward.setRedirect(false); 	//isRedirect �������� �ʱⰪ�� false�̱� ������ �ǹ̾��� �ڵ�
			forward.setPath("/main.jsp");
			System.out.println(forward + "<- forward ��ü��������");
		}else if(command.equals("/Login/login_pro.ksmart_m")) {
			System.out.println("3-9 /Login/login_pro.ksmart_m ���ǹ� ����");
			action = new LoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Login/loginout.ksmart_m")) {
			System.out.println("3-10 /Login/loginout.ksmart_m ���ǹ� ����");
			action = new LoginOutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//--- ���࿡ forward ��ü�������� ����ִ� ���� null�� �ƴϸ�
		//--- ������ �� ���ΰ�? �����̷�Ʈ �Ұ��ΰ�?
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]  MController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}		
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1-1 doGet MController.java");
		doPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1-2 doPost MController.java");
		request.setCharacterEncoding("euc-kr");
		doPro(request,response);
	}

}
