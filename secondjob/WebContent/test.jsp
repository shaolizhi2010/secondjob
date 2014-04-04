<%@page import="com.resume.PersonalInformation"%>
<%@page import="com.resume.Resume"%>
<%@page import="com.resume.Experience"%>
<%@page import="com.dao.CommonDao"%>
<%@page import="com.service.CommonService"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	//Experience entity = new Experience();
	//entity.setStart("2012-2-2");
	//entity.setEnd("2013-3-3");
	//entity.setComment("java 开发");
	//CommonService s = new CommonService();
	//s.save("张三", "hello zhang san!","男","1982-6-23","吉林");
	CommonDao dao = new CommonDao();

	Resume entity = new Resume();
	entity.setName("简历66");
	
	PersonalInformation pEntity = new PersonalInformation();
	pEntity.setChineseName("王五66");
	
	entity.setPersonalInformation(pEntity);
	
	pEntity.getResumes().add(entity);
	//dao.save(entity);
	
	
%>
