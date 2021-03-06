package org.cap.service;

import java.time.LocalDate;
import java.util.List;

import org.cap.model.PassRequestBean;
import org.cap.model.RouteBean;
import org.cap.model.TransactionBean;

public interface IBusService {
	public List<RouteBean> getAllRoutes();

	public boolean addRoute(RouteBean routeBean);

	public List<PassRequestBean> pendingDetails();

	public List<PassRequestBean> pendingDetailsOfEmp(String empid);

	public Integer transaction(TransactionBean transaction);

	public List<TransactionBean> getReport(LocalDate from, LocalDate to);
	
}
