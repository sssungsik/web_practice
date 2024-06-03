package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MListProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-2 execute MListProAction.java");
		Mdao mdao = new Mdao();
		ArrayList<Member> alm = mdao.mAllSelect();
		System.out.println(alm + "<- alm execute MListProAction.java");
		request.setAttribute("alm", alm);
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mlist/m_list.jsp");
		return mf;
	}
}
//1�ܰ� : get��� �Ǵ� post������� �Է��ڷᰡ �ԷµǸ� �� �޾Ƽ� �ܼ�â�� Ȯ���Ѵ�
//2�ܰ� : DTO (�� : Member) ��ü ���� �� set�޼��� �� ȣ���ؼ� ��ü �� ����
//3�ܰ� ���� : DAO ��ü ���� �� �޼��� ȣ�� (��üȸ����ȸ ó��)
//4�ܰ� ���� : ���� �޼��� ȣ�� �� ������ �ִٸ� ���ϰ��� �޴´�.
//5�ܰ� ���� : request �Ǵ� session ��ü�� ���� (view�� ���� �ϱ� ����)
//6�ܰ� ���� : MActionForward ��ü �� ������ �Ǵ� �����̷�Ʈ ���� �� ��� ����
//7�ܰ� ���� : MActionForward ��ü �ּҰ��� �޼��� ȣ�� �� ��(��Ʈ�ѷ�) ���� ����