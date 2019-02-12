package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;
import vo.MemberVO;
// 폼에서 요청이 왔을 시 post , cmd =  memIn
public class MemberInAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberVO v = new MemberVO();
		v.setId(request.getParameter("id"));
		v.setPwd(request.getParameter("pwd"));
		v.setName(request.getParameter("name"));
		v.setEmail(request.getParameter("email"));
		v.setTel(request.getParameter("tel"));
		//Dao를 통해서 입력을 처리한 후 greeting으로 이동한다.
		MemberDao.getDao().addMember(v);
		// redirect
		return new ActionForward("my.kosta?cmd=greeting&id="+v.getId(), true);
	}

}
