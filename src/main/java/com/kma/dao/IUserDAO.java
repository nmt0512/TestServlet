package com.kma.dao;

import com.kma.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUsernameAndPassword(String username, String password);
}
