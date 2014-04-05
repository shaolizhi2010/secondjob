package com.codegen.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.codegen.action.ActionGenerator;
import com.codegen.base.AbstractGenerator;
import com.utils.L;
import com.utils.U;
import com.vo.ColumnVO;

public class EntityGenerator extends AbstractGenerator{

	public void gen(String moduleName) {

		try {

			// gen entity begin
			// file name of java entity like ABCEntity
			String fileName = StringUtils.capitalize(moduleName) + "Entity";
			// entity路径
			String packagePath = "com/entity/";
			// 数据库表中的所有列
			List<ColumnVO> columnList = new ArrayList<ColumnVO>();
			metaData(moduleName, columnList);
			U.printList(columnList);

			// *entity.java的内容
			StringBuffer code = new StringBuffer();
			// 取entity 的 template
			String generatedEntityCode = getFileContent(srcPath+"com/codegen/entity/entity.template");
			
			// 在 *entity.java 文件中，替换表明和 entity名
			generatedEntityCode = StringUtils.replace(generatedEntityCode, "$tableName$", moduleName);
			generatedEntityCode = StringUtils.replace(generatedEntityCode, "$entityName$",
					StringUtils.capitalize(moduleName));
			
			
			String generatedPropertyCode = "";
			
			for (ColumnVO column : columnList) {
				if(column.getName().equalsIgnoreCase("id")){
					continue;	//id 写死 暂不动态处理
				}
				String templateForProperty = getFileContent(srcPath+"com/codegen/entity/entity.property.template");
				templateForProperty = StringUtils.replace(templateForProperty, "$columnName$", column.getName());
				templateForProperty = StringUtils.replace(templateForProperty, "$propertyName$", column.getName());
				templateForProperty = StringUtils.replace(templateForProperty, "$propertyNameInMethod$", StringUtils.capitalize(column.getName()));
				templateForProperty = StringUtils.replace(templateForProperty, "$propertyType$", "String");//暂时都用string 进行map
				generatedPropertyCode += templateForProperty;
			}

			generatedEntityCode = StringUtils.replace(generatedEntityCode, "$entityContent$",
					 generatedPropertyCode);

			code.append(generatedEntityCode);

			saveFile(code.toString(), srcPath + packagePath + fileName
					+ ".java");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			String moduleName = "drawmoney";
			
			new EntityGenerator().gen(moduleName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
