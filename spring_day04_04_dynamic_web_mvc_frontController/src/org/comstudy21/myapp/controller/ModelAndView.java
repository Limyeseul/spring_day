package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
	private boolean isRedirect = false;
	private String viewName;
	
	public ModelAndView() { }
	
	public ModelAndView(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		if(isRedirect) {
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
	
}
