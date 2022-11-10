package com.kma.mapper;

import java.sql.ResultSet;

public interface AbstractMapper<T> {
	T mapData(ResultSet rs);
}
