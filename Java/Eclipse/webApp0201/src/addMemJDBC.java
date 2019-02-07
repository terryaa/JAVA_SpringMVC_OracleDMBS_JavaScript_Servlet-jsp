

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addMemJDBC
 */
@WebServlet("/addMemJDBC")
public class addMemJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public addMemJDBC() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		String name= request.getParameter("name");
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		String sajob = request.getParameter("sajob");
		int sapay=Integer.parseInt(request.getParameter("sapay"));
		String sgender= request.getParameter("gender");
		Sawon sawon=new Sawon();
		System.out.println(name);
		System.out.println(deptno);
		System.out.println(sajob);
		System.out.println(sapay);
		System.out.println(sgender);
		
		sawon.setSname(name);
		sawon.setDeptno(deptno);
		sawon.setSajob(sajob);
		sawon.setSapay(sapay);
		sawon.setSgender(sgender);
		SawonDao.getDao().insertSawon(sawon);
		
		SawonDao dao=SawonDao.getDao();
        List<Sawon> list=null;
		try {
			list = dao.getDao().sawonSearch(10);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        for(Sawon e : list){
            System.out.println("��ȣ" +e.getSabun());
            System.out.println("�̸�"+ e.getSname());
            System.out.println("===================");
        }
		
		
		
		PrintWriter out=response.getWriter();
		//�������� �����ً� ó���� ����� �ѱ۷� �˾Ƶ�´�. 
		//���⼭ ������ Ʋ���ԵǸ�, MIMEŸ���� Ʋ��?�ٸ�? �������ؼ� ���������� �߸��� �������� �ν�, ����������.
		//ex text/html:charset=euc-kr
		response.setContentType("text/html;charset=euc-kr");
		out.println("<p style='color:green'>"+name+"�� ȸ�������� ����</p>");
		
	}

}
