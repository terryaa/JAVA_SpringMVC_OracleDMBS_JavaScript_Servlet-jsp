package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//새로운 세션을 생성하지않고 기존의 세션을 가져와야하기떄문에 false가들어감.
		HttpSession session=request.getSession(false);
		session.removeAttribute("uid");
		return new ActionForward("*.kosta?cmd=hello",true);
	}

	
}
