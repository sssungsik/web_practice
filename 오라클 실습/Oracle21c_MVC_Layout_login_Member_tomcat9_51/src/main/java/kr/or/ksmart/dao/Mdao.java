package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.Member;

public class Mdao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Member m = null;
	List<Member> lm = null;

	public Mdao() {
		System.out.println("5 Mdao 생성자 메서드 실행");
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init Mdao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds Mdao() ");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//7 로그인 체크 메서드 선언
	public Member mLoginCheck(String in_id,String in_pw) throws ClassNotFoundException, SQLException{
		System.out.println("7 mLoginCheck Mdao.java");
//리턴값 3개중 하나 : 로그인성공 또는 아이디불일치 또는 비번불일치 
		System.out.println(in_id+"<- in_id mLoginCheck Mdao.java");
		System.out.println(in_pw+"<- in_pw mLoginCheck Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mLoginCheck Mdao.java");
		pstmt = conn.prepareStatement("SELECT * FROM ORACLE_MEMBER WHERE ora_id=?");
		pstmt.setString(1, in_id);
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();
		m = new Member();
		if(rs.next()){
			System.out.println("1-1 아이디 일치");
			if(in_pw.equals(rs.getString("ora_pw"))) {
				System.out.println("2-1 로그인성공");
				m.setOra_id(rs.getString("ora_id"));
				m.setOra_pw(rs.getString("ora_pw"));
				m.setOra_level(rs.getString("ora_level"));
				m.setOra_name(rs.getString("ora_name"));
				m.setOra_email(rs.getString("ora_email"));
				m.setLogin_check("1로그인성공");
			}else {
				System.out.println("2-2 비번 불일치");
				m.setLogin_check("2비번불일치");
			}
		}else {
			System.out.println("1-2 아이디 불일치");
			m.setLogin_check("3아이디불일치");
		}
		return m;
	}
	
	//6 검색 메서드 선언
	public List<Member> mSearch(String sk,String sv) throws ClassNotFoundException, SQLException{
		System.out.println("6 mSearch Mdao.java");
		System.out.println(sk+"<- sk mSearch Mdao.java");
		System.out.println(sv+"<- sv mSearch Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mSearch Mdao.java");
		//3단계 : select쿼리 실행 준비(조건별 확인)
		String selectQuery="select * from ORACLE_MEMBER";

		if(sk == null && sv == null){
			System.out.println("1-1 sk,sv 둘다 null 조건");
			pstmt = conn.prepareStatement(selectQuery);
		}else if(sk != null && sv.equals("")){
			System.out.println("1-2 sk는 null아니고 sv는 공백 조건");
			pstmt = conn.prepareStatement(selectQuery);
		}else if(sk != null && sv != null){
			System.out.println("1-3 sk,sv는 null 아닌 조건");
			pstmt = conn.prepareStatement(selectQuery+" WHERE "+sk+"=?");
			pstmt.setString(1, sv);
		}
		System.out.println(pstmt + "<-- pstmt");
		lm = new ArrayList<Member>();
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next()");
		while(rs.next()){
			//System.out.println("while문 실행");
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			lm.add(m);
			System.out.println(lm + "<- lm mSearch Mdao.java");
		}
		pstmt.close();
		rs.close();
		conn.close();
		
		return lm;
	}
	
	//5 삭제처리 메서드 선언
	public void mDelete(String mid) throws ClassNotFoundException, SQLException {
		System.out.println("5 mDelete Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mDelete Mdao.java");
		pstmt = conn.prepareStatement("DELETE FROM ORACLE_MEMBER WHERE ORA_ID=?");
		pstmt.setString(1, mid);
		System.out.println(pstmt + "<-- pstmt 1");
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
	
	//4 mUpdate(매개변수1개) : 수정처리 메서드 선언
	public void mUpdate(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("1 mInsert(매개변수1개) Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mInsert Mdao.java");
		pstmt = conn.prepareStatement(
				"UPDATE ORACLE_MEMBER SET ORA_PW=?, ORA_LEVEL=?, ORA_NAME=?,ORA_EMAIL=? WHERE ORA_ID=?");
		System.out.println(pstmt + "<-- pstmt 1 mUpdate Mdao.java");
		pstmt.setString(1, m.getOra_pw());
		pstmt.setString(2, m.getOra_level());
		pstmt.setString(3, m.getOra_name());
		pstmt.setString(4, m.getOra_email());
		pstmt.setString(5, m.getOra_id());
		System.out.println(pstmt + "<-- pstmt 2 mUpdate Mdao.java");
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result mUpdate Mdao.java");
		pstmt.close();
		conn.close();
	}
	
	//3 한명 회원 조회 메서드 선언(수정화면)
	public Member mSelectforUpdate(String mid) throws ClassNotFoundException, SQLException{
		System.out.println("3 mSelectforUpdate Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mSelectforUpdate Mdao.java");
		pstmt = conn.prepareStatement("SELECT * FROM ORACLE_MEMBER WHERE ora_id=?");
		pstmt.setString(1, mid);
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() m_update_form.jsp");
		if(rs.next()) {
			System.out.println("if 조건문 실행");
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
		}
		pstmt.close();
		rs.close();
		conn.close();
		return m;
	}
	
	//2 전체회원조회 메서드 선언
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("2 mAllSelect Mdao.java");
		//jdbc 1~7단계
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mAllSelect Mdao.java");
		pstmt = conn.prepareStatement("select * from ORACLE_MEMBER");
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();
		System.out.println(rs + "<-- rs mAllSelect Mdao.java");
		//System.out.println(rs.next() + "<-- rs.next() mAllSelect Mdao.java");
		ArrayList<Member> alm = new ArrayList<Member>();
		//System.out.println(alm + "<- alm mAllSelect Mdao.java");
		while(rs.next()) {
			//System.out.println("반복 횟수?");
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			System.out.println(m + "<- m mAllSelect Mdao.java");
			alm.add(m);
			System.out.println(alm + "<- alm mAllSelect Mdao.java");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return alm;
	}
	//1 mInsert(매개변수1개) : 입력처리 메서드 선언
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("1 mInsert(매개변수1개) Mdao.java");
		//jdbc 1~2단계 : driver loading and DB 연결
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mInsert Mdao.java");

		pstmt = conn.prepareStatement(
				"insert into oracle_member values(?,?,?,?,?)");
		System.out.println(pstmt + "<-- pstmt 1 mInsert Mdao.java");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
//insert into tb_member values('id001','pw001','관리자','홍01','email01');
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		System.out.println(pstmt + "<-- pstmt 2 mInsert Mdao.java");
		//jdbc 4단계 : 쿼리 실행
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result mInsert Mdao.java");
		//jdbc 5단계 : 쿼리 실행 결과 사용(생략)
		//jdbc 6~7단계 : 객체 종료
		pstmt.close();
		conn.close();
	}

}
