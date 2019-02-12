package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;
import vo.MemberVO;
// ������ ��û�� ���� �� post , cmd =  memIn
public class MemberInAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberVO v = new MemberVO();
		v.setId(request.getParameter("id"));
		v.setPwd(request.getParameter("pwd"));
		v.setName(request.getParameter("name"));
		v.setEmail(request.getParameter("email"));
		v.setTel(request.getParameter("tel"));
		//Dao�� ���ؼ� �Է��� ó���� �� greeting���� �̵��Ѵ�.
		MemberDao.getDao().addMember(v);
		// redirect
		return new ActionForward("my.kosta?cmd=greeting&id="+v.getId(), true);
	}

}
