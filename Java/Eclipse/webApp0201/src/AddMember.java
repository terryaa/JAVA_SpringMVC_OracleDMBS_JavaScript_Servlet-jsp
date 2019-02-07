

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMember
 */
@WebServlet("/addMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//join.jsp, formDemo.jsp 에서 값을 전송했을때 동작
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public AddMember() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd= request.getParameter("pwd");
		String name= request.getParameter("name");
		PrintWriter out=response.getWriter();
		//브라우저로 보여줄떄 처리를 해줘야 한글로 알아듣는다. 
		//여기서 형식이 틀리게되면, MIME타입이 틀림?다름? 으로인해서 웹브라우저는 잘못된 형식으로 인식, 에러가난다.
		//ex text/html:charset=euc-kr
		response.setContentType("text/html;charset=euc-kr");
		out.println("<p style='color:green'>"+id+"님 회원가입을 축하</p>");
		out.println("<p style='color:red'>"+pwd+"님 회원가입을 축하</p>");
		out.println("<p style='color:blue'>"+name+"이 실명일까요?</p>");
		//Dao.getConn().addMember(MemberVO);
		
	}

}
