package com.demo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.biz.AuthorBiz;
import com.demo.biz.BookBiz;
import com.demo.entity.Author;
import com.demo.entity.Book;
import com.demo.entity.BookAuthor;

public class BookAction {

	// 注入BookBiz
	@Autowired
	private BookBiz bookbiz;
	// 注入AuthorBiz
	@Autowired
	private AuthorBiz authorbiz;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	// 查看所有图书
	public String getAllBook() {
		String result = "";
		List<Book> books = null;
		List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
		try {
			books = bookbiz.getAllBook();
			for (Book book : books) {
				BookAuthor bookAuthor = new BookAuthor();
				bookAuthor.setBookid(book.getId());
				bookAuthor.setBookname(book.getName());
				bookAuthor.setBookprice(book.getPrice());
				Author author = new Author();
				author = authorbiz.getAuthorById(book.getAuthorid());
				bookAuthor.setAuthorid(author.getId());
				bookAuthor.setAuthorname(author.getName());
				bookAuthors.add(bookAuthor);
			}
			request.setAttribute("bookAuthors", bookAuthors);
			result = "getallbookok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "error";
		}

		return result;
	}

	// 添加一本书籍
	public String AddBook() {
		String reg = request.getParameter("reg");
		String bookid = request.getParameter("id");
		if (reg == null) {
			reg = "";
		}
		String bookname = request.getParameter("bookname");
		if (bookname == null) {
			bookname = "";
		}
		String authorid = request.getParameter("authorid");
		if (authorid == null) {
			authorid = "";
		}
		String price = request.getParameter("price");
		if (price == null) {
			price = "";
		}
		int pri = 0;
		if (!price.equalsIgnoreCase("")) {
			pri = Integer.valueOf(price);
		}

		List<Author> authors = null;
		try {
			authors = authorbiz.getAllUser();
			request.setAttribute("authors", authors);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (reg == "") {
			return "addBook";
		} else if (reg.equals("update")) {
			Book book = new Book();
			book.setId(Integer.parseInt(bookid));
			try {
				book = bookbiz.getBook(book);
				request.setAttribute("book", book);
				return "updateBookok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "书籍修改失败！");
				return "updateBookerror";
			}
		} else {
			Book book = new Book();
			book.setName(bookname);
			book.setPrice(pri);
			book.setAuthorid(Integer.parseInt(authorid));
			if (!bookid.equals("")) {
				book.setId(Integer.parseInt(bookid));
			}
			try {
				bookbiz.AddBook(book);
				request.setAttribute("msg", "书籍添加成功！");
				return "addBookok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg", "书籍添加失败！");
				return "addBookerror";
			}
		}
	}

	// 添加多本书籍
	/*
	 * public String AddMoreBook() throws Exception{ String reg =
	 * request.getParameter("reg"); if (reg == null) { reg = ""; } String
	 * bookname = request.getParameter("bookname"); String bookname1 =
	 * request.getParameter("bookname1"); if (bookname == null) { bookname = "";
	 * } if (bookname1 == null) { bookname1 = ""; } String author =
	 * request.getParameter("author"); String author1 =
	 * request.getParameter("author1"); if (author == null) { author = ""; } if
	 * (author1 == null) { author1 = ""; } String price =
	 * request.getParameter("price"); String price1 =
	 * request.getParameter("price1"); if (price == null) { price = ""; } if
	 * (price1 == null) { price1 = ""; } int pri = 0; if
	 * (!price.equalsIgnoreCase("")) { pri = Integer.valueOf(price); } int pri1
	 * = 0; if (!price1.equalsIgnoreCase("")) { pri1 = Integer.valueOf(price1);
	 * } if (reg == "") { return "addMoreBook"; } else { Book book = new Book();
	 * book.setName(bookname); book.setPrice(pri); book.setAuthor(author); Book
	 * book1 = new Book(); book1.setName(bookname1); book1.setPrice(pri1);
	 * book1.setAuthor(author1);
	 * 
	 * List<Book> books = new ArrayList<Book>(); books.add(book);
	 * books.add(book1); try { bookbiz.AddMoreBook(books);
	 * request.setAttribute("msg", "数据添加成功！"); return "addMoreBookok"; } catch
	 * (Exception e) { e.printStackTrace(); request.setAttribute("msg",
	 * "数据添加失败！"); return "addMoreBookerror"; } } }
	 */

	// 删除书籍
	public String DelOneBook() {
		String id = request.getParameter("id");
		if (id == null) {
			id = "";
		}
		if (id == "") {
			return "idempty";
		} else {
			Book book = new Book();
			book.setId(Integer.valueOf(id));
			try {
				bookbiz.DelOneBook(book);
				return "deletok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "deleteerror";
			}
		}
	}

	 /**
	  *  模仿事物
	  *  删除书籍同时删除作者
	  */
	public String DelBookAndAuthor() {
		String id = request.getParameter("id");
		if (id == null) {
			id = "";
		}
		if (id == "") {
			return "idempty";
		} else {
			Book book = new Book();
			book.setId(Integer.valueOf(id));
			try {
				bookbiz.DelBookAndAuthor(book);
				return "deletok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "deleteerror";
			}
		}
	}

}
