package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {
	@Override
	public ModelAndView requestMap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String)req.getAttribute("path");
		ModelAndView modelAndView = null;
		
		if("/board/list".equals(path)) {
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_list.jsp");
		} else if("/board/insert".equals(path)) {
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_insert.jsp");
		} else if("/board/detail".equals(path)) {
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_detail.jsp");
		}
		
		return modelAndView;
	}
}
