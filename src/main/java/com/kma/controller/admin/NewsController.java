package com.kma.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kma.constant.SystemConstant;
import com.kma.model.NewsModel;
import com.kma.paging.PageRequest;
import com.kma.paging.Pageable;
import com.kma.service.ICategoryService;
import com.kma.service.INewsService;
import com.kma.utils.FormUtil;
import com.kma.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {
	
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private INewsService newsService;

	@Inject
	private ICategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageable pageable = new PageRequest(model.getPage(), model.getMaxPageItems());
			model.setListResult(newsService.findAll(pageable));
			model.setTotalItems(newsService.getTotalItems());
			model.setTotalPages(pageable.getTotalPages(model.getTotalItems(), model.getMaxPageItems()));
			view = "/views/admin/news/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = newsService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
