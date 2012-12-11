package com.nhncorp.study.board.mapper;

import org.apache.ibatis.annotations.Insert;

import com.nhncorp.study.board.model.BoardUser;

public interface BoardUserMapper {
	BoardUser getUser(String id);
	
	@Insert("insert into board_user(id, name, email) values(#{id}, #{name}, #{email})")
	Object addUser(BoardUser boardUser);
}
