package com.kma.service;

import com.kma.model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPassword(String username, String password);
}
