package com.nhncorp.study.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.service.ArticleService;

@Controller
public class ArticleListController {
	@Autowired
	ArticleService articleService;
	
	public String showArticles(ArticleSearchParam searchParam,
			Model model) {
		List<Article> articleList = articleService.getArticles(searchParam);
		model.addAttribute("articleList", articleList);
		return "article/list";
	}

}
