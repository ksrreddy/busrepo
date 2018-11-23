package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.LoginBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		
		LoginBean loginBean=new LoginBean(userName, userPwd);
		ILoginService iLoginService=new LoginServiceImpl();
		
		if(iLoginService.isValidLogin(loginBean)) {
	
			request.getRequestDispatcher("pages/mainPage.html").include(request, response);
			out.println(userName+" is Authorized User!");
		}else {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("Sorry!" + userName+" is not Authorized User!");
		}
		
	}

}
