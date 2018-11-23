package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.TransactionBean;
import org.cap.service.BusServiceImpl;
import org.cap.service.IBusService;


@WebServlet("/ApprovedServlet")
public class ApprovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBusService busservice=new BusServiceImpl();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		Integer route_id=Integer.parseInt(request.getParameter("routeno"));
		Double total_km=Double.parseDouble(request.getParameter("totalkm"));
		Integer total_fare =Integer.parseInt(request.getParameter("totalfare"));
		String empid=request.getParameter("empid");
		LocalDate date=LocalDate.now();
		TransactionBean transaction = new TransactionBean(route_id,empid,date,total_km,total_fare);
		Integer transaction_id = busservice.transaction(transaction);
		
		
		if(transaction_id!= 0) {
			RequestDispatcher rd=request.getRequestDispatcher("pages/Transactionsuccess.html");
			rd.include(request, response);
			
		}else {


		
			pw.println("<h1>Unable to complete transaction..Please try again!!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ListAllPendingRequestsServlet");
			rd.include(request, response);
		}
	}

	

}
