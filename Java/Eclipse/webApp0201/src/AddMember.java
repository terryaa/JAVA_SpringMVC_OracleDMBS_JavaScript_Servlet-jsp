

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
	//join.jsp, formDemo.jsp ���� ���� ���������� ����
       
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
		//�������� �����ً� ó���� ����� �ѱ۷� �˾Ƶ�´�. 
		//���⼭ ������ Ʋ���ԵǸ�, MIMEŸ���� Ʋ��?�ٸ�? �������ؼ� ���������� �߸��� �������� �ν�, ����������.
		//ex text/html:charset=euc-kr
		response.setContentType("text/html;charset=euc-kr");
		out.println("<p style='color:green'>"+id+"�� ȸ�������� ����</p>");
		out.println("<p style='color:red'>"+pwd+"�� ȸ�������� ����</p>");
		out.println("<p style='color:blue'>"+name+"�� �Ǹ��ϱ��?</p>");
		//Dao.getConn().addMember(MemberVO);
		
	}

}
