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


@WebServlet("/ListAllPendingRequestsServlet")
public class ListAllPendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBusService busservice=new BusServiceImpl();
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String empid=request.getParameter("empid");

		
		response.setContentType("text/html");

		List<PassRequestBean> pendingList=busservice.pendingDetailsOfEmp(empid);


		PrintWriter pw=response.getWriter();

		pw.println("<html><body><h3 align='center'>PendingRequest Details</h3>");
		pw.println("<table>"
				+ "<tr>"
				+ "<th>Employee Id </th>"
				+"<th>First Name </th>"
				+"<th>Last Name </th>"
				+"<th>Address </th>"
				+ "</tr>");

		for(PassRequestBean emp:pendingList) {
			pw.println("<tr>"
					+ "<td>"+emp.getEmployeeId()+"</td>"
					+"<input type='hidden' value="+emp.getEmployeeId()+" name='empid'>"
					+ "<td>"+emp.getFirstName()+"</td>"
					+"<td>"+emp.getLastName()+"</td>"
					+"<td>"+emp.getAddress()+"</td>"
					);
		}
		pw.println("<form action='ApprovedServlet' method='post'>"
				+ "Route Number: <input type='text' name='routeno'>"
				+ "Total Kilometers:<input type='text' name='totalkm'>"
				+ "Total Fare:<input type='text' name='totalfare'>"
				+"<input type='submit' name='approve' value='Approve'>"
				+"<input type='hidden' value="+empid+" name='empid'>"
				+"</form>"
				);
		pw.println("</table></body></html>");



	}
	}

