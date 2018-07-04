package com.demo.dao;

import java.util.List;

import com.demo.entity.Author;

/**
 * @author zhaocm
 * @data 2018年4月20日
 * @time 下午2:48:38
 */
public interface IAuthorDao{

	public List<Author> getAllUser() throws Exception;
	
	public Author getAuthorById(Integer authorid) throws Exception;
	
	public boolean DelAuthor(Author author) throws Exception;
}
