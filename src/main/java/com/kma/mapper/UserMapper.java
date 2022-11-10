package com.kma.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kma.model.RoleModel;
import com.kma.model.UserModel;

public class UserMapper implements AbstractMapper<UserModel> {

	@Override
	public UserModel mapData(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUsername(resultSet.getString("username"));
			user.setFullname(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
