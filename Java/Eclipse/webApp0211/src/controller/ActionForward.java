package controller;

public class ActionForward {
	private String url; // 모델이  수행 후 이동할 view
	private boolean method; // 모델이 수행 후 이동할 방식
	public ActionForward() {}
	public ActionForward(String url, boolean method) {
		this.url = url;
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public boolean isMethod() {
		return method;
	}
}
