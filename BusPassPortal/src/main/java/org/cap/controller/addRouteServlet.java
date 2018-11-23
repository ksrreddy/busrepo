package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.RouteBean;
import org.cap.service.BusServiceImpl;
import org.cap.service.IBusService;


@WebServlet("/addRouteServlet")
public class addRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBusService busService=new BusServiceImpl();
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 
		String routepath=request.getParameter("routepath");
		String routename=request.getParameter("routename");
		String total=request.getParameter("totalseats");
		String occupied=request.getParameter("occupiedseats");
		String busno=request.getParameter("busno");
		String driverNo=request.getParameter("driverno");
		String Kilotmeters=request.getParameter("totalkilometers");
		int totalseats=Integer.parseInt(total);
		int totalKilotmeters=Integer.parseInt(Kilotmeters);
		int occupiedseats=Integer.parseInt(occupied);
		
		RouteBean routeBean=new RouteBean();
		
		routeBean.setRoutepath(routepath);
		routeBean.setRoutename(routename);
		routeBean.setTotalseats(totalseats);
		routeBean.setOccupiedseats(occupiedseats);
		routeBean.setBusno(busno);
		routeBean.setDriverNo(driverNo);
		routeBean.setTotalKilotmeters(totalKilotmeters);
		PrintWriter out=response.getWriter();
		
		
		boolean passRouteBean=busService.addRoute(routeBean);
		
		if(passRouteBean) {
			request.getRequestDispatcher("pages/requestForm.html").include(request, response);
			out.println("INsertion Successfully Done..........");
			
			
		}else {
			request.getRequestDispatcher("pages/requestForm.html").include(request, response);
			out.println("INsertion Successfully Done..........");
			
		}
		
		
		
	}

}
