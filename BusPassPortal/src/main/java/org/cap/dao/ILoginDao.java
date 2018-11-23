package org.cap.dao;

import org.cap.model.LoginBean;
import org.cap.model.PassRequestBean;

public interface ILoginDao {
	public boolean isValidLogin(LoginBean loginBean);

	public PassRequestBean createRequest(PassRequestBean passRequestBean);

}
