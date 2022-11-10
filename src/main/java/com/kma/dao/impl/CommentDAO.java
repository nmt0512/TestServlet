package com.kma.dao.impl;

import com.kma.dao.ICommentDAO;
import com.kma.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM comment WHERE id = ?";
		update(sql, id);
	}
	
}
