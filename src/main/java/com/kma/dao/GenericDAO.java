package com.kma.dao;

import java.util.List;

import com.kma.mapper.AbstractMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, AbstractMapper<T> mapper, Object... parameters);
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
