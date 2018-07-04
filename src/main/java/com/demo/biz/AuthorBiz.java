package com.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IAuthorDao;
import com.demo.entity.Author;

@Service("authorBiz")
@Transactional
public class AuthorBiz {
	
	@Autowired
	private IAuthorDao authordao;
	
	public List<Author> getAllUser() throws Exception {
		List<Author> users = null;
		users = authordao.getAllUser();
		return users;
	}
	
	public Author getAuthorById(Integer authorid) throws Exception {
		return authordao.getAuthorById(authorid);
	}
	
}
