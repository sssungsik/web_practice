package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class MemberFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 static final long serialVersionUID = 1L;
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 System.out.println(RequestURI + "<-- RequestURI MemberFrontController.java");
		 System.out.println(contextPath + "<-- contextPath MemberFrontController.java");
		 System.out.println(command + "<-- command MemberFrontController.java");
		 System.out.println("----MemberFrontController.java ----- ");
		 System.out.println();
		 
		 ActionForward forward=null;
		 Action action=null;
		   
		   if(command.equals("/member/MemberLogin.me")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./loginForm.jsp");
		   }else if(command.equals("/member/MemberJoin.me")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./joinForm.jsp");
		   }else if(command.equals("/member/MemberLoginAction.me")){
			   action = new MemberLoginAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/member/MemberJoinAction.me")){
			   action = new MemberJoinAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/member/MemberListAction.me")){
			   action = new MemberListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/member/MemberViewAction.me")){
			   action = new MemberViewAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/member/MemberDeleteAction.me")){
			   action = new MemberDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }
		   if(forward != null){
		   if(forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
		   }else{
			   RequestDispatcher dispatcher=
				   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
		   }
		   }
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("board doGet메서드 실행 MemberFrontController.java");
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("board doPost메서드 실행 MemberFrontController.java");

		doProcess(request,response);
	}   	  	      	    
}