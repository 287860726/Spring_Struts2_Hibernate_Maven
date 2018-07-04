package com.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.IAuthorDao;
import com.demo.dao.IBookDao;
import com.demo.entity.Author;
import com.demo.entity.Book;

@Service("bookBiz")
@Transactional
public class BookBiz {

	@Autowired
	private IBookDao bookdao;
	@Autowired
	private IAuthorDao authordao;

	public List<Book> getAllBook() throws Exception {
		List<Book> books = null;
		books = bookdao.getAllBook();
		return books;
	}

	public Book getBook(Book book) throws Exception {
		return bookdao.getBook(book);
	}

	public boolean AddBook(Book book) throws Exception {
		try {
			bookdao.AddBook(book);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean DelOneBook(Book book) throws Exception {
		try {
			bookdao.DelOneBook(book);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean AddMoreBook(List<Book> books) throws Exception {
		try {
			bookdao.AddMoreBook(books);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 模仿事物
	 * 删除书籍同时删除作者，如果成功删除书籍的同时删除书籍作者，其中任何过程失败，执行回滚。
	 */
	@Transactional(rollbackFor = Throwable.class)
	public boolean DelBookAndAuthor(Book book) throws Exception {
		Book book1 = new Book();
		book1 = bookdao.getBook(book);
		Author author = new Author();
		author.setId(book1.getAuthorid());
		authordao.DelAuthor(author);
		bookdao.DelOneBook(book);
		return true;
	}
}
