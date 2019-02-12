package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class HelloAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msg = "hello MVC!";
		request.setAttribute("msg", msg);
		// false : forward , true : redirect
		return new ActionForward("hello.jsp", false);
	}

}
