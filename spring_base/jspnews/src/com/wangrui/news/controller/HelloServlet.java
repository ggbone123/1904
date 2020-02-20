package com.wangrui.news.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wangrui.news.service.UserService;

public class HelloServlet implements Servlet{

	public HelloServlet() {
		System.out.println("------------------ ���� -----------------");
	}
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("------------------ init -----------------");
	}
	
	@Override
	public void destroy() {
		System.out.println("-------------destory-----------------");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	// Ϊ�û��������ṩ����ķ���
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// request �������û�����������û����͵��������ݺ�����ͷ�е��������ݣ����������档
		// ȡ����
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName"); // ȡ�û���
		String passwd  = request.getParameter("passwd"); // ȡ����

		System.out.println("------------------����ҵ�񷽷�������û���¼------------------------------");
		UserService us = new UserService();
		boolean ok = us.login(userName, passwd);
		
		//---------------- ���ݽ��������ͼ ------------------
		if(ok) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession(true);
			session.setAttribute("userInfo", userName);
			
			// ����ת��
			RequestDispatcher rd = request.getRequestDispatcher("/manage_news.jsp");
			request.setAttribute("user", userName);
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "��¼ʧ��");
			rd.forward(request, response);
		}
		
		// response ��Ӧ���󡣿��Խ��������  ������õķ�����
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8"); 
//		response.getWriter().print("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"<meta charset=\"UTF-8\">\r\n" + 
//				"<title>Insert title here</title>\r\n" + 
//				"</head>\r\n" + 
//				"<body>\r\n" + "��ã�"+userName+
//				"   <h1>���ŷ�������</h1>\r\n" + 
//				"</body>\r\n" + 
//				"</html>");
		
	}

}
