package org.cap.service;

import java.time.LocalDate;
import java.util.List;

import org.cap.dao.BusServiceDaoImpl;
import org.cap.dao.IBusServiceDao;
import org.cap.model.PassRequestBean;
import org.cap.model.RouteBean;
import org.cap.model.TransactionBean;

public class BusServiceImpl implements IBusService{
	
	private IBusServiceDao busServiceDao;
	
	public BusServiceImpl() {
		this.busServiceDao=new BusServiceDaoImpl();
	}

	@Override
	public List<RouteBean> getAllRoutes() {
		
		return busServiceDao.getAllRoutes();
	}

	@Override
	public boolean addRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return busServiceDao.addRoute(routeBean);
	}

	@Override
	public List<PassRequestBean> pendingDetails() {
		
		return busServiceDao.pendingDetails();
	}

	@Override
	public List<PassRequestBean> pendingDetailsOfEmp(String empid) {
		// TODO Auto-generated method stub
		return busServiceDao.pendingDetails(empid);
	}

	@Override
	public Integer transaction(TransactionBean transaction) {
		// TODO Auto-generated method stub
		return busServiceDao.transaction(transaction);
	}

	

	@Override
	public List<TransactionBean> getReport(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return busServiceDao.getReport(from,to);
	}

}
