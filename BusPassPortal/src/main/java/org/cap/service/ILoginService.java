package org.cap.service;

import org.cap.model.LoginBean;
import org.cap.model.PassRequestBean;

public interface ILoginService {
	
	public boolean isValidLogin(LoginBean loginBean);
	public PassRequestBean createRequest(PassRequestBean passRequestBean);

}
