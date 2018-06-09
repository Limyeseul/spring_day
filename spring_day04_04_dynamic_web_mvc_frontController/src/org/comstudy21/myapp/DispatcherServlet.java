package org.comstudy21.myapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.BoardController;
import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.HandlerMapping;
import org.comstudy21.myapp.controller.ModelAndView;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

public class DispatcherServlet extends HttpServlet {
	private HandlerMapping handlerMapping = new HandlerMapping();

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>> doProcess() 호출");
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		
		String viewName = "/WEB-INF/views/home.jsp";
		ModelAndView modelAndView;
		if(reqUri.equals(ctxPath+"/")) {
			modelAndView = new ModelAndView(false, viewName);
		} else {
			int beginIndex = ctxPath.length();
			int endIndex = reqUri.lastIndexOf(".");
			String path = reqUri.substring(beginIndex, endIndex);
//			System.out.println("path=>" + path);
//			System.out.println(beginIndex+", " + endIndex);
			Controller boardController = handlerMapping.getController(path);
			req.setAttribute("path", path);
			modelAndView = boardController.requestMap(req, resp);
		}
		modelAndView.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
