package com.javaGG.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaGG.ex.dao.BDao;
import com.javaGG.ex.dto.BDto;

public class BListCommand implements BCommand {

	public BListCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse repsResponse) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
