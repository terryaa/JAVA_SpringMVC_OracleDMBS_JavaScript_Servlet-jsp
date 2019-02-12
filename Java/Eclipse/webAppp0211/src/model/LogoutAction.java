package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//���ο� ������ ���������ʰ� ������ ������ �����;��ϱ⋚���� false����.
		HttpSession session=request.getSession(false);
		session.removeAttribute("uid");
		return new ActionForward("*.kosta?cmd=hello",true);
	}

	
}
