package com.nhncorp.study.board.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhncorp.study.board.mapper.BoardUserMapper;
import com.nhncorp.study.board.model.BoardUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/datasource-context.xml", "/mybatis-context.xml"})
public class DBInitialTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BoardUserMapper boardUserMapper;
	
	@Test
	public void testDi() throws Exception {
		assertNotNull(dataSource);
	}
	
	@Test
	public void testGetConnectionAndSelect() throws Exception {
		Connection connection = dataSource.getConnection();
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("select * from board_user");
		
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			
			System.out.println("id = " + id);
			System.out.println("name = " + name);
			System.out.println("email = " + email);
		}
	}
	
	@Test
	public void testMyBatis() throws Exception {
		BoardUser user = boardUserMapper.getUser("aretias");
		System.out.println("id = " + user.getId());
		System.out.println("name = " + user.getName());
		System.out.println("email = " + user.getEmail());
	}
	
	
	@Test
	public void testGetUser() throws Exception {
		BoardUser user = boardUserMapper.getUser("aretias");
		assertEquals("aretias", user.getId());
		assertEquals("이정인", user.getName());
		assertEquals("aretias.kr@gmail.com", user.getEmail());
	}
	
	@Test
	public void testGetUser2() throws Exception {
		BoardUser user = boardUserMapper.getUser("aretias");
		
		BoardUser expect = new BoardUser();
		expect.setEmail("aretias.kr@gmail.com");
		expect.setId("aretias");
		expect.setName("이정인");
		
		assertEquals(expect, user);
	}
	
	@Test
	public void testAddUserAndSelect() throws Exception {
		BoardUser expect = new BoardUser();
		expect.setEmail("kimsun.kr@gmail.com");
		expect.setId("kimusun");
		expect.setName("김선");
		
		boardUserMapper.addUser(expect);
		
		BoardUser user = boardUserMapper.getUser("kimusun");
		
		assertEquals(expect, user);
	}
}