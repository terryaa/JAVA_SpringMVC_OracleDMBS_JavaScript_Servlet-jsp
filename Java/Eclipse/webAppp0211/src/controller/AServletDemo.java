package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AmodelDemo;

/**
 * Servlet implementation class AServletDemo
 */
@WebServlet("/AServletDemo")
public class AServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH="/WEB-INF/view/";
	private AmodelDemo model;
	public AServletDemo() {
		model = new AmodelDemo();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = model.getMessage();
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(PATH+"aview.jsp");
		rd.forward(request, response);
	}

}
