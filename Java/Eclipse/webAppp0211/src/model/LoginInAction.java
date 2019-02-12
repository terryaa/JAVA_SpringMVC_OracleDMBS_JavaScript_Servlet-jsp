package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;

public class LoginInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//db랑 연결. 지금은 test값
		String dbid="test";
		String dbpwd="test11";
		String path="";
		boolean method=false;
		if(id.contentEquals(dbid)&&pwd.contentEquals(dbpwd)) {
			path="*.kosta?cmd=hello";
			method=true;
			session.setAttribute("uid", id);
		}else {
			path="error.jsp";
			method=false;
			request.setAttribute("msg", "로그인 실패다!");
		}
		return new ActionForward(path,method);
	}

}
