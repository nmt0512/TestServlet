package com.kma.dao.impl;

import java.util.List;

import com.kma.dao.INewsDAO;
import com.kma.mapper.NewsMapper;
import com.kma.model.NewsModel;
import com.kma.paging.Pageable;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updatedNews) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updatedNews.getTitle(), updatedNews.getThumbnail(), updatedNews.getShortDescription(),
				updatedNews.getContent(), updatedNews.getCategoryId(), updatedNews.getCreatedDate(), 
				updatedNews.getCreatedBy(), updatedNews.getModifiedDate(), 
				updatedNews.getModifiedBy(), updatedNews.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if(pageable.getOffset() != null && pageable.getFetch() != null)
		{
			sql.append(" ORDER BY id OFFSET " + pageable.getOffset() + " ROWS");
			sql.append(" FETCH NEXT " + pageable.getFetch() +" ROWS ONLY");
		}
		return query(sql.toString(), new NewsMapper());
	}

	@Override
	public int getTotalItems() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}
}
