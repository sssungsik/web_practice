package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.action.MInsertProAction;
import kr.or.ksmart.action.MListProAction;
import kr.or.ksmart.forward.MActionForward;


public class MController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MController2() {
        super();
    }

	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2 doPro ���� MController2.java");
		System.out.println(request + "<-- request doPro ���� MController2.java");
		System.out.println(response + "<-- response doPro ���� MController2.java");
		//org.apache.catalina.connector.RequestFacade@3289512c<-- request doPro ���� MController2.java
		//org.apache.catalina.connector.ResponseFacade@3c4eb90d<-- response doPro ���� MController2.java
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI MController2.java");
		System.out.println(contextPath + "<-- contextPath MController2.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() MController2.java");
		System.out.println(command + "<-- command MController2.java");
		System.out.println("----------MController2.java----------------");
		System.out.println();
		MActionForward forward = null;
		MActionInterFace action = null;
		

		if(command.equals("/Min/m_insert_form.ksmart_m")) {
			System.out.println("3-1 /Min/m_insert_form.ksmart_m MController2.java");
			//������ �ұ�? �����̷�Ʈ �ұ�? ����
			//������ �Ǵ� �����̷�Ʈ ��� ����
			forward = new MActionForward();
			forward.setRedirect(false);	//������ ����(�ʱⰪ�� false�̱� ������ �ǹ� ���� �ڵ�)
			forward.setPath("/minsert/m_insert_form.jsp");
		}else if(command.equals("/Min/m_insert_pro.ksmart_m")) {
			System.out.println("3-2 /Min/m_insert_pro.ksmart_m MController2.java");
			// execute 메서드 호출
			action = new MInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/Mlist/m_list.ksmart_m")) { 
			System.out.println("3-3 /Mlist/m_list.ksmart_m");
			action = new MListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// --- ������ �� ���ΰ�? �����̷�Ʈ �Ұ��ΰ�?
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]  MController2.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1-1 doget 실행 MConrollter2.java");
		doPro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); // post 한글처리
		System.out.println("1-2 doPost 실행 MController2.java");
		doPro(request,response);
	}

}
