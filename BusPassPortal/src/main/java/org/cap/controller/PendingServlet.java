package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.PassRequestBean;
import org.cap.service.BusServiceImpl;
import org.cap.service.IBusService;




@WebServlet("/PendingServlet")
public class PendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBusService busservice=new BusServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		List<PassRequestBean> pendingList=busservice.pendingDetails();


		PrintWriter pw=response.getWriter();
		

		pw.println("<html><body><h3 align='center'>All Pending Requests</h3>");
		pw.println("<table>"
				+ "<tr>"
				
			
				+ "</tr>");

		for(PassRequestBean emp:pendingList) {
			
			pw.println("<form action='ListAllPendingRequestsServlet' method='post'>"
					+ "<p>"+emp.getEmployeeId()+"</p>"
					+"<input type='hidden' value="+emp.getEmployeeId()+" name='empid'>"
					+"<input type='submit' value='View' name='view'>"
					+"</form>"
					
					);
		}

		pw.println("</table></body></html>");

		
		
	}
	}

