package com.nhncorp.study.board.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.Member;

@Controller
public class ArticleController {
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getArticleForm(Model model) {
		model.addAttribute("article", new Article());
		return "article/form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String saveArticleForm(@Valid Article article, BindingResult bindingResult, Model model) {
		System.out.println(article);
		if (bindingResult.hasErrors()) {
			System.out.println("hasErrors");
			model.addAttribute("article", article);
			return "article/form";
		}
		return "article/view";
	}
}
