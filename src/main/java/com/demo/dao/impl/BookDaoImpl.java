package com.demo.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IBookDao;
import com.demo.entity.Book;

@Repository("bookDao")
public class BookDaoImpl extends BaseDao implements IBookDao {

	public List<Book> getAllBook() throws Exception {
		this.OpenConncetion();
		List<Book> books = null;
		String hql = "FROM Book";
		Query query = session.createQuery(hql);
		return query.list();
	}

	public Book getBook(Book book) throws Exception {
		this.OpenConncetion();
		return session.get(Book.class, book.getId());
	}

	public boolean AddBook(Book book) throws Exception {
		this.OpenConncetion();
		try {
			session.saveOrUpdate(book);
			session.flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean DelOneBook(Book book) throws Exception {
		this.OpenConncetion();
		String hql = "delete from Book where id =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", book.getId());
		query.executeUpdate();
		//手动抛出异常，实现事物回滚
		throw new Exception("书籍删除 失败！！！！");
		// return true;
	}

	public boolean AddMoreBook(List<Book> books) throws Exception {
		this.OpenConncetion();
		try {
			for (Book book : books) {
				session.save(book);
			}
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
