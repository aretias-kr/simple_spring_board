package com.nhncorp.study.board.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.nhncorp.study.board.model.Article;

public class ArticleControllerTest {
	@Test
	public void testGetArticleForm() throws Exception {
		MockMvcBuilders.standaloneSetup(new ArticleController()).build()
				.perform(get("/form")).andExpect(status().isOk())
				.andExpect(view().name("article/form"))
				.andExpect(model().attribute("article", new Article()));
	}
	
	@Test
	public void testSaveArticleForm() throws Exception {
		MockMvcBuilders.xmlConfigSetup("classpath:servlet-context.xml").build()
			.perform(
					post("/form")
					.param("title", "hello title")
					.param("contents", "hello contents")
					.param("member.id", "aretias")
			).andExpect(status().isOk())
			.andExpect(view().name("article/view"));
	}
	
	@Test
	public void testSaveArticleForm_제목이_없을경우() throws Exception {
		MockMvcBuilders.xmlConfigSetup("classpath:servlet-context.xml").build()
			.perform(
					post("/form")
					//.param("title", "hello title")
					.param("contents", "hello contents")
					.param("member.id", "aretias")
			).andExpect(status().isOk())
			.andExpect(view().name("article/form"))
			.andExpect(model().attributeHasFieldErrors("article", "title"));
	}
	
	/*@Test
	public void testSaveArticleForm_�������������°��() throws Exception {
		Article expectArticle = new Article();
		expectArticle.setTitle("hello title");
		expectArticle.setContents("hello contents");
		
		MockMvcBuilders.xmlConfigSetup("classpath:servlet-context.xml").build()
			.perform(
					post("/form")
					.param("title", "hello title")
					.param("contents", "hello contents")
			).andExpect(status().isOk())
			.andExpect(view().name("article/form"))
			.andExpect(model().attributeHasFieldErrors("article", "member"))
			.andExpect(model().attribute("article", expectArticle));
	}*/
}
