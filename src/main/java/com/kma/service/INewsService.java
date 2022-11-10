package com.kma.service;

import java.util.List;

import com.kma.model.NewsModel;
import com.kma.paging.Pageable;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updatedNews);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageable pageable);
	int getTotalItems();
	NewsModel findOne(long id);
}
