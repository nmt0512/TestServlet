package com.kma.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kma.model.NewsModel;
import com.kma.model.UserModel;
import com.kma.service.INewsService;
import com.kma.utils.HttpUtil;
import com.kma.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsApi extends HttpServlet {
	
	@Inject
	private INewsService newsService;

	private static final long serialVersionUID = -915988021506484384L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel =  HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		newsModel = newsService.save(newsModel);
		mapper.writeValue(response.getOutputStream(), newsModel);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel updatedNews =  HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		updatedNews.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		updatedNews = newsService.update(updatedNews);
		mapper.writeValue(response.getOutputStream(), updatedNews);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel =  HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		if(newsModel.getIds() != null)
		{
			newsService.delete(newsModel.getIds());
			mapper.writeValue(response.getOutputStream(), "{}");
		}
	}
}
