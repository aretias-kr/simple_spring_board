package com.nhncorp.study.board.service;

import java.util.List;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

public interface ArticleService {
	/**
	 * 게시글 목록을 조회한다.
	 * @param searchParam 게시글 목록 조회 조건
	 * @return
	 */
	List<Article> getArticles(ArticleSearchParam searchParam);
}
