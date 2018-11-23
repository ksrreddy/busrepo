package org.cap.service;

import org.cap.dao.ILoginDao;
import org.cap.dao.LoginDaoImpl;
import org.cap.model.LoginBean;
import org.cap.model.PassRequestBean;

public class LoginServiceImpl implements ILoginService{
	
	private ILoginDao loginDao;
	
	public LoginServiceImpl() {
		this.loginDao=new LoginDaoImpl();
	}

	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		if(loginDao.isValidLogin(loginBean))
			return true;
		return false;
	}

	@Override
	public PassRequestBean createRequest(PassRequestBean passRequestBean) {
		
		return loginDao.createRequest(passRequestBean);
	}

}
