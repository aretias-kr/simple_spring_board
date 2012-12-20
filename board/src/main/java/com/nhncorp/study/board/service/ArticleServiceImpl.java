package com.nhncorp.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.study.board.mapper.ArticleMapper;
import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	
	public List<Article> getArticles(ArticleSearchParam searchParam) {
		return articleMapper.selectArticles(searchParam);
	}

}
