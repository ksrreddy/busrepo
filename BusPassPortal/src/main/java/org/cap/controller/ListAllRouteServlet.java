package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.RouteBean;
import org.cap.service.BusServiceImpl;
import org.cap.service.IBusService;


@WebServlet("/ListAllRouteServlet")
public class ListAllRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IBusService busService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		busService=new BusServiceImpl();
		PrintWriter out=response.getWriter();
		List<RouteBean> routes=busService.getAllRoutes();
		out.println("<html>"
				+ "<body>");
		out.println("<h3>All Route Details</h3>"
				+ "<table>"
				+ "<tr>"
				+ "<th>RouteId</th>"
				+ "<th style='width:150px'>RouteName</th>"
				+ "<th>Total Seats</th>"
				+ "<th>OccupiedSeats</th>"
				+ "<th>Kilotmeters</th>"
				+ "</tr>");
		for(RouteBean routeBean:routes) {
			out.println("<tr>"
					+ "<td>"+routeBean.getRouteid()+"</td>"
					+ "<td style='width:150px'>"+routeBean.getRoutename()+"<br>"
					+routeBean.getRoutepath() + "</td>"
					+"<td>"+routeBean.getTotalseats()+"</td>"
					+ "<td>"+routeBean.getOccupiedseats()+"</td>"
							+ "<td>"+routeBean.getTotalKilotmeters()+"</td>"
					+ "</tr>");
		}
		
	out.println("</table>");
		
		
		out.println("</body>"
				+ "</html>");
	}

}
