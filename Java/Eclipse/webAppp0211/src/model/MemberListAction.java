package model;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao2;
import vo.MemberVO;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<MemberVO> list=MemberDao2.getDao().getList();
		request.setAttribute("list", list);
		return new ActionForward("memlist.jsp",false);
	}

}
