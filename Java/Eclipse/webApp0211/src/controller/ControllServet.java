package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;

/**
 * Servlet implementation class ControllServet
 */
@WebServlet("*.kosta")
public class ControllServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH="/WEB-INF/view/";
	// GET/POST�� ��� ��û����� ó�� 
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//�ѱ� ó��
			request.setCharacterEncoding("euc-kr");
			//��û �ޱ�  http://host/contextPath/cont?cmd=hello
			String cmd = request.getParameter("cmd");
			if(cmd != null) {
				ActionFactory factory = ActionFactory.getFactory();
				// ex) Action action = new HelloAction(); ��������� �� �ּҸ� �޾ƿ�
				Action action = factory.getAction(cmd);
				// ActionForward �� ��ȯ - �̵����, view����
				ActionForward af = action.execute(request, response);
				if(af.isMethod()) { // redirect
					response.sendRedirect(af.getUrl());
				}else { // forward
					// ���� ������ �� ��ȯ ���� �� �߿� url���� forward�� ����
					StringBuffer sb = new StringBuffer();
					sb.append(PATH).append(af.getUrl());
					RequestDispatcher rd = request.getRequestDispatcher(sb.toString());
					rd.forward(request, response);
				}
			}else {
				// ��û���� �� ó�� 
			}
		}
	
	
    public ControllServet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	

}


