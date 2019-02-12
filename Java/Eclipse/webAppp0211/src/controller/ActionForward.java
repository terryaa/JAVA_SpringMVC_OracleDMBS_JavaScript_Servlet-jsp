package controller;

public class ActionForward {
	private String url; // ����  ���� �� �̵��� view
	private boolean method; // ���� ���� �� �̵��� ���
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
