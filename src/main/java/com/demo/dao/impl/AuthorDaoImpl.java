package com.demo.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.dao.IAuthorDao;
import com.demo.entity.Author;
import com.demo.entity.Book;

@Repository("authorDao")
public class AuthorDaoImpl extends BaseDao implements IAuthorDao{

	public List<Author> getAllUser() throws Exception{
		this.OpenConncetion();
		List<Author> users = null;
		String hql = "FROM Author";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public Author getAuthorById(Integer authorid) throws Exception{
		this.OpenConncetion();
		String hql = "FROM Author WHERE id =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", authorid);
		return (Author)query.list().get(0);
	}

	public boolean DelAuthor(Author author) throws Exception{
		this.OpenConncetion();
		try {
			String hql = "delete from Author where id =:id"; 
			Query query = session.createQuery(hql);
			query.setParameter("id", author.getId());
			query.executeUpdate();
			session.flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
