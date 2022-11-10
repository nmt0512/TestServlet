package com.kma.dao;

import java.util.List;

import com.kma.model.NewsModel;
import com.kma.paging.Pageable;

public interface INewsDAO extends GenericDAO<NewsModel> {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel updatedNews);
	void delete(long id);
	List<NewsModel> findAll(Pageable pageable);
	int getTotalItems();
}
