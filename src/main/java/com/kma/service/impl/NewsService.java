package com.kma.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.kma.dao.ICategoryDAO;
import com.kma.dao.ICommentDAO;
import com.kma.dao.INewsDAO;
import com.kma.model.CategoryModel;
import com.kma.model.NewsModel;
import com.kma.paging.Pageable;
import com.kma.service.INewsService;

public class NewsService implements INewsService {
	
	@Inject
	private INewsDAO newsDao;
	
	@Inject
	private ICommentDAO commentDao;

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(category.getId());
		Long newId = newsDao.save(newsModel);
		return newsDao.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updatedNews) {
		NewsModel oldNew = newsDao.findOne(updatedNews.getId());
		updatedNews.setCreatedDate(oldNew.getCreatedDate());
		updatedNews.setCreatedBy(oldNew.getCreatedBy());
		updatedNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updatedNews.getCategoryCode());
		updatedNews.setCategoryId(category.getId());
		newsDao.update(updatedNews);
		return newsDao.findOne(updatedNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			commentDao.delete(id);
			newsDao.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		return newsDao.findAll(pageable);
	}

	@Override
	public int getTotalItems() {
		return newsDao.getTotalItems();
	}

    @Override
    public NewsModel findOne(long id) {
		NewsModel newsModel = newsDao.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
        return newsModel;
    }

}
