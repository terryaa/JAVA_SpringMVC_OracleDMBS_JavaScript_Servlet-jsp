package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class GreetingAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msg = request.getParameter("id")+"�� ȯ���մϴ�.";
		request.setAttribute("msg", msg);
		return new ActionForward("greeting.jsp", false);
	}

}
