package com.kma.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.kma.dao.ICategoryDAO;
import com.kma.model.CategoryModel;
import com.kma.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
