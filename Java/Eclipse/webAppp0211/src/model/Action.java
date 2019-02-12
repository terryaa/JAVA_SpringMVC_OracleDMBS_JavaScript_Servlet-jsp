package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public interface Action {
	// ���� ���� HttpServletRequest request, 
	// HttpServletResponse response
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws IOException;
}
