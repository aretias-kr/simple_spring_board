package com.nhncorp.study.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.util.CollectionUtils;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/servlet-context.xml", "/root-context.xml" })
public class ArticleListControllerIntegrationTest {
	@Autowired
	ArticleListController sut;
	private ExtendedModelMap model;
	private ArticleSearchParam searchParam;

	@Before
	public void setup() {
		model = new ExtendedModelMap();
		searchParam = new ArticleSearchParam();
	}

	@Test
	public void testDi() throws Exception {
		assertNotNull(sut);
	}

	@Test
	public void testShowArticles_게시글_목록을_조회한다() throws Exception {
		// given
		// when
		String viewName = sut.showArticles(searchParam, model);
		// then
		assertEquals("article/list", viewName);
		List<Article> articles = (List<Article>) model.get("articleList");
		Article o = new Article();
		o.setTitle("제목입력");
		o.setContents("내용입력");
		Member member = new Member();
		member.setId("aretias");
		o.setMember(member);
		articles.contains(o);

		System.out.println(articles);
	}

	@Test
	public void testShowArticles_제목에_searchParam의_title이_안포함하면_검색이_안됨() throws Exception {
		searchParam.setTitle("안포함되는제목");

		// when
		sut.showArticles(searchParam, model);

		// then
		List<Article> articles = (List<Article>) model.get("articleList");
		assertTrue("없는제목 넣었으니까 true", CollectionUtils.isEmpty(articles));
	}

	@Test
	public void testShowArticles_제목검색() throws Exception {

		// given
		searchParam.setTitle("제목");
		// when
		sut.showArticles(searchParam, model);

		// then
		List<Article> articles = (List<Article>) model.get("articleList");
		for (Article article : articles) {
			assertTrue("제목에 포함되는 제목을 넣었으므로 정상적으로 검색됨", article.getTitle().contains(searchParam.getTitle()));
		}
		
		assertTrue(articles.size() > 0);
	}
	
	@Test
	public void testShowArticles_작성자로_검색가능() throws Exception {
		// given
		searchParam.setMemberId("aretias");
		// when
		sut.showArticles(searchParam, model);

		// then
		List<Article> articles = (List<Article>) model.get("articleList");
		
		for (Article article : articles) {
			assertTrue("작성자도 검색되야함", article.getMember().getId().contains(searchParam.getMemberId()));
		}
		
		assertTrue(articles.size() > 0);
	}
}
