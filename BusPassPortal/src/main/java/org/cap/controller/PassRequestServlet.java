package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.PassRequestBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;


@WebServlet("/PassRequestServlet")
public class PassRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ILoginService loginService=new LoginServiceImpl();
		
		String employeeId=request.getParameter("employeeId");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String doj=request.getParameter("doj");
		String location=request.getParameter("location");
		String pickuploc=request.getParameter("pickuploc");
		String pickuptime=request.getParameter("pickuptime");
		String designation=request.getParameter("designation");
		PassRequestBean requestBean=new PassRequestBean();
		requestBean.setEmployeeId(employeeId);
		requestBean.setFirstName(firstName);
		requestBean.setLastName(lastName);
		requestBean.setEmail(email);
		requestBean.setGender(gender);
		requestBean.setAddress(address);
		requestBean.setLocation(location);
		requestBean.setPickuploc(pickuploc);
		requestBean.setDesignation(designation);
		
		String[] datepart=doj.split("-");
		LocalDate dateOfJoin= LocalDate.of(Integer.parseInt(datepart[0]), 
				Integer.parseInt(datepart[1]), Integer.parseInt(datepart[2]));
		requestBean.setDateOfJoining(dateOfJoin);
		
		
		String[] timepart=pickuptime.split(":");
		LocalTime picktime=LocalTime.of(Integer.parseInt(timepart[0]), Integer.parseInt(timepart[1]));
		requestBean.setPickuptime(picktime);
	
		
		PassRequestBean passRequestBean= loginService.createRequest(requestBean);
		PrintWriter out=response.getWriter();
		
		
		if(passRequestBean!=null) {
			request.getRequestDispatcher("pages/requestForm.html").include(request, response);
			out.println("INsertion Successfully Done..........");
		}
		else {
			request.getRequestDispatcher("pages/requestForm.html").include(request, response);
			out.println("INsertion Failed..........");
		}
	}

}
