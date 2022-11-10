package com.kma.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kma.model.CategoryModel;

public class CategoryMapper implements AbstractMapper<CategoryModel> {

	@Override
	public CategoryModel mapData(ResultSet resultSet) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}
}
