package com.javaGG.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	void excute(HttpServletRequest request, HttpServletResponse repsResponse);
}
