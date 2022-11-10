package com.kma.dao.impl;

import java.util.List;

import com.kma.dao.IUserDAO;
import com.kma.mapper.UserMapper;
import com.kma.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByUsernameAndPassword(String username, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM dbuser AS u");
		sql.append(" JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = 1");
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password);
		return users.isEmpty() ? null : users.get(0);
	}
	
}
