package kr.or.ksmart.forward;
//DTO ��Ȱ 
//forward or redirect ���� �� ��� ���� ��Ȱ
public class MActionForward {
	//�������� = field
	private boolean isRedirect=false;
	private String path=null;
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "MActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}

}
