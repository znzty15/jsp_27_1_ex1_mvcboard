package com.javaGG.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaGG.ex.dao.BDao;

public class BDeleteCommand implements BCommand {
	
	public BDeleteCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub		
		String bid = request.getParameter("bid");

		BDao dao = new BDao();
		dao.delete(bid);

	}

}
