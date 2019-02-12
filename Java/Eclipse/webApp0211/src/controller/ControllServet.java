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
	// GET/POST의 모든 요청방식을 처리 
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//한글 처리
			request.setCharacterEncoding("euc-kr");
			//요청 받기  http://host/contextPath/cont?cmd=hello
			String cmd = request.getParameter("cmd");
			if(cmd != null) {
				ActionFactory factory = ActionFactory.getFactory();
				// ex) Action action = new HelloAction(); 만들어져서 그 주소를 받아옴
				Action action = factory.getAction(cmd);
				// ActionForward 를 반환 - 이동방식, view정보
				ActionForward af = action.execute(request, response);
				if(af.isMethod()) { // redirect
					response.sendRedirect(af.getUrl());
				}else { // forward
					// 모델이 수행한 후 반환 받은 값 중에 url값을 forward로 지정
					StringBuffer sb = new StringBuffer();
					sb.append(PATH).append(af.getUrl());
					RequestDispatcher rd = request.getRequestDispatcher(sb.toString());
					rd.forward(request, response);
				}
			}else {
				// 요청없을 때 처리 
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


