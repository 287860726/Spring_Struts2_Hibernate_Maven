package com.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	protected Session session;
	
	//注入SessionFactory
	@Autowired
	private SessionFactory SessionFactory;

	//获取session，当前已经有就直接用，没有就创建
	public void OpenConncetion() throws Exception {
		session = SessionFactory.getCurrentSession();
	}
}
