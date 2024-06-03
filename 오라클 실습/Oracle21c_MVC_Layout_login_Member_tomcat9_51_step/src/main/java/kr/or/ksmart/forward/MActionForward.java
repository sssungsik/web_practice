package kr.or.ksmart.forward;
public class MActionForward {
	//포워드 할까? 리다이렉트 할까? 설정
	//포워드 또는 리다이렉트 경로 설정
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
