package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.cap.model.LoginBean;
import org.cap.model.PassRequestBean;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		
		String sql="select * from adminLogin where userName=? and "
				+ "passWord=?";
		
		try(PreparedStatement pst=getMySQLDBConnection().prepareStatement(sql);){
			
			pst.setString(1, loginBean.getUserName());
			pst.setString(2, loginBean.getUserPassword());
			ResultSet rs= pst.executeQuery();
			if(rs.next())
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
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
	public PassRequestBean createRequest(PassRequestBean passRequestBean) {
		
		
		String sql="insert into buspassrequest(employeeId ,  firstName ,  lastName ,  gender,  address ," + 
				"  dateofjoin ,  location ,  pickuploc,  pickuptime ,  email,designation,status) values(?,?,?,?,?,?,?,?,?,?,?,? );" ; 
		try(PreparedStatement pst=getMySQLDBConnection().prepareStatement(sql);){
			pst.setString(1, passRequestBean.getEmployeeId());
			pst.setString(2, passRequestBean.getFirstName());
			pst.setString(3, passRequestBean.getLastName());
			pst.setString(4, passRequestBean.getGender());
			pst.setString(5, passRequestBean.getAddress());
			pst.setDate(6, Date.valueOf(passRequestBean.getDateOfJoining()));
			pst.setString(7, passRequestBean.getLocation());
			pst.setString(8, passRequestBean.getPickuploc());
			pst.setTime(9, Time.valueOf(passRequestBean.getPickuptime()));
			pst.setString(10, passRequestBean.getEmail());
			pst.setString(11, passRequestBean.getDesignation());
			pst.setString(12, passRequestBean.getStatus());
			
			int count=pst.executeUpdate();
			if(count>0)
				return passRequestBean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}

}
