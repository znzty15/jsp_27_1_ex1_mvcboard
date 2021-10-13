package com.javaGG.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaGG.ex.dao.BDao;
import com.javaGG.ex.dto.BDto;

public class BContentCommand implements BCommand{

	public BContentCommand() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse repsResponse) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		
		request.setAttribute("content_view", dto);
	}

}
