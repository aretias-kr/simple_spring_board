package com.nhncorp.study.board.mapper;

import java.util.List;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

public interface ArticleMapper {
	List<Article> selectArticles(ArticleSearchParam searchParam);
}
