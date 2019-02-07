

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1_FirstPageDemo
 */
@WebServlet("/first")
public class Ex1_FirstPageDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_FirstPageDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//page는 private같음. 
		// scope => page,request,session,application
		// redirect방식은 response객체가 주체.
		// http://localhost/webApp0207/first?msg=hi
		
		//Forwarding 없이 자료만 setAttribute를 통해 넣고 sendDirect를 부르면 자료가 전송되지않는다.
		String msg=request.getParameter("msg");
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("second");
		rd.forward(request, response);
		//response.sendRedirect("second");
		//sendRedirect는 정보를 전송하여주지 않는다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
