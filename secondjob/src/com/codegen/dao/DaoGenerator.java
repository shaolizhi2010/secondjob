package com.codegen.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.codegen.base.AbstractGenerator;
import com.utils.U;
import com.vo.ColumnVO;

public class DaoGenerator extends AbstractGenerator{

	public void gen(String moduleName) {
		
		try {
			// gen dao begin
			String srcPath = getBasePath()+"src/";
			
			// file name  like ABCDao
			String fileName = StringUtils.capitalize(moduleName) + "Dao";
			String tableName = moduleName;
			String entityName = StringUtils.capitalize(moduleName)+"Entity";
			String daoName = StringUtils.capitalize(moduleName)+"Dao" ;
			
			// dao 路径
			String packagePath = "com/dao/";
			
			// 数据库表中的所有列
			List<ColumnVO> columnList = new ArrayList<ColumnVO>();
			metaData(entityName, columnList);
			U.printList(columnList);

			// *Dao.java的内容
			StringBuffer code = new StringBuffer();
			// 取dao 的 template
			String daoTemplate = getFileContent(srcPath+"com/codegen/dao/dao.template");
			
			//替换dao 名
			daoTemplate = StringUtils.replace(daoTemplate, "$daoName$", daoName);
			
			// 在 *Dao.java 文件中，替换 entity名
			daoTemplate = StringUtils.replace(daoTemplate, "$entityName$", entityName);
			daoTemplate = StringUtils.replace(daoTemplate, "$moduleName$", moduleName);
			
			String generatedCodeForSetDbo = "";
			String generatedCodeForSetentity = "";
			
			for (ColumnVO column : columnList) {
				if(column.getName().equalsIgnoreCase("id")){
					continue;	//id暂不处理
				}
				String templateForcSetdbo = getFileContent(srcPath+"com/codegen/dao/dao.setdbo.template");
				templateForcSetdbo = StringUtils.replace(templateForcSetdbo, "$propertyName$", column.getName());
				templateForcSetdbo = StringUtils.replace(templateForcSetdbo, "$propertyNameInMethod$", StringUtils.capitalize(column.getName()));
				generatedCodeForSetDbo += templateForcSetdbo;
		
				String templateForcSetentity = getFileContent(srcPath+"com/codegen/dao/dao.setentity.template");
				templateForcSetentity = StringUtils.replace(templateForcSetentity, "$propertyName$", column.getName());
				templateForcSetentity = StringUtils.replace(templateForcSetentity, "$propertyNameInMethod$", StringUtils.capitalize(column.getName()));
				generatedCodeForSetentity += templateForcSetentity;
			
			}
			daoTemplate = StringUtils.replace(daoTemplate, "$setdbo$",
					generatedCodeForSetDbo);
			
			daoTemplate = StringUtils.replace(daoTemplate, "$setentity$",
					generatedCodeForSetentity);
			
			
			
			code.append(daoTemplate);
			saveFile(code.toString(), srcPath + packagePath + fileName
					+ ".java");

		} catch (Exception e) { 
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			String moduleName = "resume";
			//System.out.println( new DaoGenerator().getBasePath() ); 
			new DaoGenerator().gen(moduleName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
