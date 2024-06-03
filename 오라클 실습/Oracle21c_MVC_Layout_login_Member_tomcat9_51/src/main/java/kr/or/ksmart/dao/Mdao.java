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
		System.out.println("5 Mdao ������ �޼��� ����");
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init Mdao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds Mdao() ");
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	//7 �α��� üũ �޼��� ����
	public Member mLoginCheck(String in_id,String in_pw) throws ClassNotFoundException, SQLException{
		System.out.println("7 mLoginCheck Mdao.java");
//���ϰ� 3���� �ϳ� : �α��μ��� �Ǵ� ���̵����ġ �Ǵ� �������ġ 
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
			System.out.println("1-1 ���̵� ��ġ");
			if(in_pw.equals(rs.getString("ora_pw"))) {
				System.out.println("2-1 �α��μ���");
				m.setOra_id(rs.getString("ora_id"));
				m.setOra_pw(rs.getString("ora_pw"));
				m.setOra_level(rs.getString("ora_level"));
				m.setOra_name(rs.getString("ora_name"));
				m.setOra_email(rs.getString("ora_email"));
				m.setLogin_check("1�α��μ���");
			}else {
				System.out.println("2-2 ��� ����ġ");
				m.setLogin_check("2�������ġ");
			}
		}else {
			System.out.println("1-2 ���̵� ����ġ");
			m.setLogin_check("3���̵����ġ");
		}
		return m;
	}
	
	//6 �˻� �޼��� ����
	public List<Member> mSearch(String sk,String sv) throws ClassNotFoundException, SQLException{
		System.out.println("6 mSearch Mdao.java");
		System.out.println(sk+"<- sk mSearch Mdao.java");
		System.out.println(sv+"<- sv mSearch Mdao.java");
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mSearch Mdao.java");
		//3�ܰ� : select���� ���� �غ�(���Ǻ� Ȯ��)
		String selectQuery="select * from ORACLE_MEMBER";

		if(sk == null && sv == null){
			System.out.println("1-1 sk,sv �Ѵ� null ����");
			pstmt = conn.prepareStatement(selectQuery);
		}else if(sk != null && sv.equals("")){
			System.out.println("1-2 sk�� null�ƴϰ� sv�� ���� ����");
			pstmt = conn.prepareStatement(selectQuery);
		}else if(sk != null && sv != null){
			System.out.println("1-3 sk,sv�� null �ƴ� ����");
			pstmt = conn.prepareStatement(selectQuery+" WHERE "+sk+"=?");
			pstmt.setString(1, sv);
		}
		System.out.println(pstmt + "<-- pstmt");
		lm = new ArrayList<Member>();
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next()");
		while(rs.next()){
			//System.out.println("while�� ����");
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
	
	//5 ����ó�� �޼��� ����
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
	
	//4 mUpdate(�Ű�����1��) : ����ó�� �޼��� ����
	public void mUpdate(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("1 mInsert(�Ű�����1��) Mdao.java");
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
	
	//3 �Ѹ� ȸ�� ��ȸ �޼��� ����(����ȭ��)
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
			System.out.println("if ���ǹ� ����");
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
	
	//2 ��üȸ����ȸ �޼��� ����
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("2 mAllSelect Mdao.java");
		//jdbc 1~7�ܰ�
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
			//System.out.println("�ݺ� Ƚ��?");
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
	//1 mInsert(�Ű�����1��) : �Է�ó�� �޼��� ����
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("1 mInsert(�Ű�����1��) Mdao.java");
		//jdbc 1~2�ܰ� : driver loading and DB ����
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mInsert Mdao.java");

		pstmt = conn.prepareStatement(
				"insert into oracle_member values(?,?,?,?,?)");
		System.out.println(pstmt + "<-- pstmt 1 mInsert Mdao.java");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
//insert into tb_member values('id001','pw001','������','ȫ01','email01');
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		System.out.println(pstmt + "<-- pstmt 2 mInsert Mdao.java");
		//jdbc 4�ܰ� : ���� ����
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result mInsert Mdao.java");
		//jdbc 5�ܰ� : ���� ���� ��� ���(����)
		//jdbc 6~7�ܰ� : ��ü ����
		pstmt.close();
		conn.close();
	}

}
