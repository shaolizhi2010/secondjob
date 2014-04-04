package com.codegen.action;

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

import com.codegen.base.AbstractGenerator;
import com.codegen.entity.EntityGenerator;
import com.utils.L;
import com.utils.U;
import com.vo.ColumnVO;

public class ActionGenerator extends AbstractGenerator{

	public void gen(String moduleName) {

		try {

			String srcPath = "D:/work_space/secondjob/src/";

			//String moduleName = "project";

			// gen action begin
			// file name of action like ABCAction
			String fileName = StringUtils.capitalize(moduleName) + "Action";
			//related entity name
			String entityName = StringUtils.capitalize(moduleName) + "Entity";
			//dao name
			String daoName = StringUtils.capitalize(moduleName) + "Dao";
			
			//service name
			String serviceName = StringUtils.capitalize(moduleName) + "Service";
			
			//new improt
			//String newImport = "";
			// action路径
			String packagePath = "com/web/";
			// 数据库表中的所有列
			List<ColumnVO> columnList = new ArrayList<ColumnVO>();
			metaData(moduleName, columnList);
			U.printList(columnList);

			// *Action.java的内容
			
			// 取action 的 template
			String generatedCode = getFileContent(srcPath+"com/codegen/action/action.template");
			
			// 在 *Action.java 文件中，替换action名
			generatedCode = StringUtils.replace(generatedCode, "$actionName$", StringUtils.capitalize(moduleName));
			
			//替换 dao名
			generatedCode = StringUtils.replace(generatedCode, "$daoName$", daoName);
			generatedCode = StringUtils.replace(generatedCode, "$serviceName$", serviceName);
			
			//newImport += "import com.dao."+daoName+";";
			//newImport += "import com.service."+serviceName+";";
			
			String generatedPropertyCode = "";
			String entityInitCode = "";
			
			for (ColumnVO column : columnList) {
				String templateForProperty = getFileContent(srcPath+"com/codegen/action/action.property.template");
				if(column.getName().equalsIgnoreCase("id")){
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyName$", column.getName());
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyNameInMethod$", StringUtils.capitalize(column.getName()));
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyType$", "int");//
					
				}
				else{
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyName$", column.getName());
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyNameInMethod$", StringUtils.capitalize(column.getName()));
					templateForProperty = StringUtils.replace(templateForProperty, "$propertyType$", "String");//暂时都用string 进行map
					
				}

				generatedPropertyCode += templateForProperty;
				
				entityInitCode += "entity.set"+StringUtils.capitalize(column.getName())+"("+column.getName()+");"+"\r\n";
				
			}

			generatedCode = StringUtils.replace(generatedCode, "$propertyAndMethod$",
					 generatedPropertyCode);
			
			//set entity
			
			generatedCode = StringUtils.replace(generatedCode, "$entityName$",
					entityName);
			//newImport += "import com.entity."+entityName+";";
			
			generatedCode = StringUtils.replace(generatedCode, "$entityInit$",
					entityInitCode);	
			
			
			
//			//add import
//			generatedCode = StringUtils.replace(generatedCode, "$import$",
//					newImport);		
			
			
			saveFile(generatedCode, srcPath + packagePath + fileName
					+ ".java");
			
			//auto change struts.xml
			String strutsConfigFile = getFileContent(srcPath+"struts.xml");
			
			String strutsConfigTemplate = getFileContent(srcPath+"com/codegen/action/action.configxml.template");
			strutsConfigTemplate = StringUtils.replace(strutsConfigTemplate, "$path$",
					moduleName);	
			strutsConfigTemplate = StringUtils.replace(strutsConfigTemplate, "$actionName$",
					StringUtils.capitalize(moduleName));
			strutsConfigTemplate = StringUtils.replace(strutsConfigTemplate, "$moduleName$",
					moduleName);
			//防止重复
			if(!strutsConfigFile
					.replaceAll(" ", "")
					.replaceAll("\n", "")
					.replaceAll("\r", "").contains(strutsConfigTemplate
							.replaceAll(" ", "")
							.replaceAll("\n", "")
							.replaceAll("\r", ""))){
				strutsConfigFile = StringUtils.replace(strutsConfigFile, "</package>",
						strutsConfigTemplate +"</package>");
				
				saveFile(strutsConfigFile, srcPath+"struts.xml");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {

		try {
			String moduleName = "resume";
			
			new ActionGenerator().gen(moduleName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
