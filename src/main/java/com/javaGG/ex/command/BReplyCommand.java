package com.javaGG.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaGG.ex.dao.BDao;

public class BReplyCommand implements BCommand{

	public BReplyCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		
		BDao dao = new BDao();
		dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
	}

}
