package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.cap.model.PassRequestBean;
import org.cap.model.RouteBean;
import org.cap.model.TransactionBean;

public class BusServiceDaoImpl implements IBusServiceDao {

	@Override
	public List<RouteBean> getAllRoutes() {
		
		List<RouteBean> routeBeans=new ArrayList<>();
	
		String sql="select * from route";
		
		try(PreparedStatement pst=getMySQLDBConnection().prepareStatement(sql)){
			
			ResultSet rs= pst.executeQuery();
			
			while(rs.next()) {
				RouteBean routeBean=new RouteBean();
				routeBean.setRouteid(rs.getInt("routeid"));
				routeBean.setRoutepath(rs.getString("routepath"));
				routeBean.setRoutename(rs.getString("routename"));
				routeBean.setBusno(rs.getString("busno"));
				routeBean.setDriverNo(rs.getString("driverno"));
				routeBean.setOccupiedseats(rs.getInt("occupiedseats"));
				routeBean.setTotalseats(rs.getInt("totalseats"));
				routeBean.setTotalKilotmeters(rs.getInt("totalkilometers"));
				
				routeBeans.add(routeBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return routeBeans;
	}
	
	private Connection getMySQLDBConnection() {
		Connection connection=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/capdb", "root", "India123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public boolean addRoute(RouteBean routeBean) {
		
		String sql="INSERT INTO route(routepath,routename,totalseats,occupiedseats,busno,driverNo,totalKilometers) values(?,?,?,?,?,?,?)";
		try(PreparedStatement pst=getMySQLDBConnection().prepareStatement(sql);){
			
			pst.setString(1, routeBean.getRoutepath());
			pst.setString(2, routeBean.getRoutename());
			pst.setInt(3, routeBean.getTotalseats());
			pst.setInt(4, routeBean.getOccupiedseats());
			pst.setString(5, routeBean.getBusno());
			pst.setString(6, routeBean.getDriverNo());
			pst.setInt(7, routeBean.getTotalKilotmeters());
			
			int count=pst.executeUpdate();
			if(count>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public List<PassRequestBean> pendingDetails() {

		String sql="select * from BusPassRequest where status='pending'";
		int pendingCount=0;
		try(

				Statement statement=getMySQLDBConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<PassRequestBean> pendingList=new ArrayList<>();
			while(resultSet.next()){
				pendingCount++;
				PassRequestBean busBean=new PassRequestBean();
				populateRoute(busBean,resultSet);

				pendingList.add(busBean);

			}
			if(pendingCount>0){
				return pendingList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	private void populateRoute(PassRequestBean busBean, ResultSet resultSet) {
		try {
			busBean.setEmployeeId(resultSet.getString(2));
			busBean.setFirstName(resultSet.getString(3));
			busBean.setLastName(resultSet.getString(4));
			busBean.setGender(resultSet.getString(5));
			busBean.setAddress(resultSet.getString(6));
			busBean.setEmail(resultSet.getString(7));
			
			java.sql.Date sqlDate=resultSet.getDate(8);
			 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
			 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
			 LocalDate localDate = localDateTime.toLocalDate();
		
			 busBean.setDateOfJoining(localDate);

			 busBean.setLocation(resultSet.getString(9));
			 busBean.setPickuploc(resultSet.getString(10));
			Time time=resultSet.getTime(11);
			LocalTime localTime=time.toLocalTime();
			busBean.setPickuptime(localTime);

			busBean.setStatus(resultSet.getString(12));
			busBean.setDesignation(resultSet.getString(13));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	@Override
	public List<PassRequestBean> pendingDetails(String empid) {
		// TODO Auto-generated method stub
		
		String sql="select * from BusPassRequest where EmployeeId=?";
		int pendingCount=0;
		try(

				PreparedStatement preparedStatement=getMySQLDBConnection().prepareStatement(sql);

				){
			preparedStatement.setString(1,empid);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<PassRequestBean> pendingList=new ArrayList<>();
			while(resultSet.next()){
				pendingCount++;
				PassRequestBean busBean=new PassRequestBean();
				populateRoute(busBean,resultSet);

				pendingList.add(busBean);

			}
			if(pendingCount>0){
				return pendingList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer transaction(TransactionBean transaction) {
		// TODO Auto-generated method stub
		
		String sql="insert into transaction(employeeId,transaction_date,calculated_km,monthly_fare,route_id) values(?,?,?,?,?)";
		String sql1="update BusPassRequest set status=? where EmployeeId=?";
		String sql2="update route set occupiedseats=occupiedseats+1 where routeid=?";
		String sql3="select transaction_id from transaction where employeeId=?";
		try(PreparedStatement preparedStatement = getMySQLDBConnection().prepareStatement(sql);
				PreparedStatement preparedStatement2 = getMySQLDBConnection().prepareStatement(sql1);
				PreparedStatement preparedStatement1 = getMySQLDBConnection().prepareStatement(sql3);
				PreparedStatement preparedStatement3 = getMySQLDBConnection().prepareStatement(sql2);
				){
			preparedStatement.setString(1,transaction.getEmp_id());
			preparedStatement.setDate(2, Date.valueOf(transaction.getTransaction_date()));
			preparedStatement.setDouble(3, transaction.getTotal_km());
			preparedStatement.setInt(4, transaction.getMonthly_fare());
			preparedStatement.setInt(5, transaction.getRoute_id());
			preparedStatement1.setString(1,transaction.getEmp_id());
			preparedStatement2.setString(1,"Approved");
			preparedStatement2.setString(2, transaction.getEmp_id());
			
			preparedStatement3.setInt(1,transaction.getRoute_id());
			
			int n=preparedStatement.executeUpdate();
			
			if(n>0) {
				ResultSet resultSet = preparedStatement1.executeQuery();
				if(resultSet.next()) {
					Integer transaction_id = resultSet.getInt(1);
					int n1=preparedStatement2.executeUpdate();
					int n2=preparedStatement3.executeUpdate();
					if(n1>0 && n2>0)
						return transaction_id;
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransactionBean> getReport(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		
		String sql="select *from transaction where transaction_date between ? and ?";
		int Count=0;
		try(PreparedStatement pt=getMySQLDBConnection().prepareStatement(sql);){
			pt.setDate(1, Date.valueOf(from));
			pt.setDate(2, Date.valueOf(to));
			
			ResultSet rs=pt.executeQuery();
			List<TransactionBean> List=new ArrayList<>();
			while(rs.next()) {
				
				Count++;
				TransactionBean bean=new TransactionBean();
				populateReport(bean,rs);
				List.add(bean);

			}
			if(Count!=0){
				return List;
			}else{
				return null;
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return null;
	}

	}

	private void populateReport(TransactionBean bean, ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
			bean.setTransaction_id(rs.getInt(1));
			bean.setEmp_id(rs.getString(2));
			
			java.sql.Date sqlDate=rs.getDate(3);
			 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
			 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
			 LocalDate localDate = localDateTime.toLocalDate();
			 
			 bean.setTransaction_date(localDate);
			 
			 bean.setTotal_km(rs.getDouble(4));
			 bean.setMonthly_fare(rs.getInt(5));
			 bean.setRoute_id(rs.getInt(6));
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
