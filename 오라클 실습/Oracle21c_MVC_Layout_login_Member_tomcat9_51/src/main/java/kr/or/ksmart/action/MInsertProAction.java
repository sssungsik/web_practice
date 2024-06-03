package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MInsertProAction implements MActionInterFace {
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-1 execute MInsertProAction.java");
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		System.out.println(ora_id + "<-- ora_id execute MInsertProAction.java");
		System.out.println(ora_pw + "<-- ora_pw execute MInsertProAction.java");
		System.out.println(ora_level + "<-- ora_level execute MInsertProAction.java");
		System.out.println(ora_name + "<-- ora_name execute MInsertProAction.java");
		System.out.println(ora_email + "<-- ora_email execute MInsertProAction.java");
		Member m = new Member();
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		System.out.println(m + "<- m execute MInsertProAction.java");
		Mdao mdao = new Mdao();
		mdao.mInsert(m);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Msearch/m_search_list.ksmart_m");
		//mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}

//1�ܰ� ����: get��� �Ǵ� post������� �Է��ڷᰡ �ԷµǸ� �� �޾Ƽ� �ܼ�â�� Ȯ���Ѵ�
//2�ܰ� ���� : DTO (�� : Member) ��ü ���� �� set�޼��� �� ȣ���ؼ� ��ü �� ����
//3�ܰ� ���� : DAO ��ü ���� �� �޼��� ȣ�� (�Է�ó��)
//4�ܰ� : ���� �޼��� ȣ�� �� ������ �ִٸ� ���ϰ��� �޴´�.
//5�ܰ� : request �Ǵ� session ��ü�� ���� (view�� ���� �ϱ� ����)
//6�ܰ� ���� : MActionForward ��ü �� ������ �Ǵ� �����̷�Ʈ ���� �� ��� ����
//7�ܰ� ���� : MActionForward ��ü �ּҰ��� �޼��� ȣ�� �� ��(��Ʈ�ѷ�) ���� ����
