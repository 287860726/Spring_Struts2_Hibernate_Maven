package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.biz.AuthorBiz;
import com.demo.entity.Author;

public class AuthorAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	
	/**
     * 注入AuthorBiz
     */
    @Autowired
    private AuthorBiz authorbiz;
    
    public String getAllUser() {
		List<Author> users = null;
		try {
			users = authorbiz.getAllUser();
			request.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "getuserok";
	}
    
    public String getAuthorById(int authorid) {
    	Author author = new Author();
    	try {
			author = authorbiz.getAuthorById(authorid);
			return "getauthorbyidok";
		} catch (Exception e) {
			e.printStackTrace();
			return "getauthorbyiderror";
		}
    }
    
}
