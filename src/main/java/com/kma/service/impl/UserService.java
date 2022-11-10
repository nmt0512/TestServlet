package com.kma.service.impl;

import com.kma.dao.IUserDAO;
import com.kma.dao.impl.UserDAO;
import com.kma.model.UserModel;
import com.kma.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUsernameAndPassword(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, password);
	}
	
}
