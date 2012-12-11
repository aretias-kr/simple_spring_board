package com.nhncorp.study.board.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class Article {
	@NotBlank(message = "제목을 입력해주세요.")
	String title;
	String contents;
	Date writeDate;
	@NotNull(message = "작성자 정보가 필요합니다.")
	Member member;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", contents=" + contents
				+ ", writeDate=" + writeDate + ", member=" + member + "]";
	}
}
