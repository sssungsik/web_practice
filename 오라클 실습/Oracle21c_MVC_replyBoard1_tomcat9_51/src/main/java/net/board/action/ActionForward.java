package net.board.action;

public class ActionForward {
	private boolean isRedirect=false;	//isRedirect가 false면 포워드,true면 리다이렉트
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

}