package com.web;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

 

import com.opensymphony.xwork2.ActionContext;
import com.web.base.BaseAction;

public class SearchAction extends BaseAction {
	private static final long serialVersionUID = -7919288320923232999L;

	private String shopname; // eg. jingdong
	private String keyword; //
	private String pageNum;
	private String callback;
	
	private String result;
	
	
	
	public String execute() {

		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");
		String freshJson = "";

		ActionContext ctx = ActionContext.getContext();
		
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);

		  
		return "success";
	}
	
	public String testMethod() {
		 
		System.out.println("in test method");
		return "success";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

 

}