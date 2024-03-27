package com.ssafy.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.controller.util.ControllerMapping;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerMapping controllerMapping = new ControllerMapping();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root" , application.getContextPath());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		
		Controller controller = controllerMapping.getController(action);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		try {
			Object info = controller.handleRequest(request, response);
			if(info != null) {
				if(info instanceof PageInfo) {	
					PageInfo pInfo = (PageInfo) info;
					if(pInfo.isForward()) {
						request.getRequestDispatcher(pInfo.getPath()).forward(request, response);
						return;
					}else {
						response.sendRedirect(request.getContextPath()+pInfo.getPath()); //  /0320_mvc_front_controller/xxxxx
					}
				} else if (info instanceof DataInfo) {
					DataInfo dInfo = (DataInfo) info;
					response.setContentType(dInfo.getContentType());
					
					if(dInfo.getContentType().contains("json")) {
						ObjectMapper mapper = new ObjectMapper();
						response.getWriter().println(mapper.writeValueAsString(dInfo.getData()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
	}
}
