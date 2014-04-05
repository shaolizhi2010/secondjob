package com.codegen.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.codegen.common.annotation.MaxLength;
import com.entity.Entity;
import com.utils.L;
import com.vo.ColumnVO;

public class AbstractGenerator {
	
	public String getBasePath(){
		String path = this.getClass().getClassLoader().getResource("").getPath();
		path = StringUtils.substringBeforeLast(path, "target");
		return path;
	}
	
	public void saveFile(String content, String path) {
		try {
			IOUtils.write(content, new FileOutputStream(new File(path)));
		} catch (Exception e) {
			L.exception("CodeGenerator", e.getMessage());
		}
	}

	public String getFileContent(String path) {
		String fileContent = "";
		try {
			fileContent = IOUtils.toString(new FileInputStream(path), "UTF-8");
		} catch (Exception e) {
			L.exception("CodeGenerator", e.getMessage());
			return "";
		}
		return fileContent;
	}
	
	

	public void metaData(String entityname, List<ColumnVO> columnList){
		
		Class clazz = null;
		try {
			clazz = Class.forName("com.entity."+entityname);
		} catch (ClassNotFoundException e) {
			L.exception(this, e.getMessage());
			return;
		}
		
		Field[] fields = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		
		for (Field field : fields) {
			String fieldName = field.getName();
			String type = field.getGenericType().toString(); // 获取属性的类型
			MaxLength maxlengthAnnotation = field.getAnnotation(MaxLength.class);
			String maxlength = "";
			if(maxlengthAnnotation != null){
				maxlength = maxlengthAnnotation.toString();//获取maxlength注解
			}
			
			
			ColumnVO vo = new ColumnVO();
			vo.setName(fieldName);
			vo.setType(type);
			vo.setMaxlength(maxlength);
			columnList.add(vo);
		}
	}
}
