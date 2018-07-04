package com.demo.dao;

import java.util.List;

import com.demo.entity.Book;


public interface IBookDao{

	public List<Book> getAllBook() throws Exception;
	
	public Book getBook(Book book) throws Exception;
	
	public boolean AddBook(Book book) throws Exception;
	
	public boolean DelOneBook(Book book) throws Exception;
	
	public boolean AddMoreBook(List<Book> books) throws Exception;
}
