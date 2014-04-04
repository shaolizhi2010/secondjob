package com.codegen.jsp;

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
import com.codegen.entity.EntityGenerator;
import com.utils.L;
import com.utils.U;
import com.vo.ColumnVO;

public class JspForCreateGenerator extends AbstractGenerator{

	public  void gen(String moduleName) {

		try {

			String srcPath = "D:/work_space/secondjob/src/";
			String webPath = "D:/work_space/secondjob/WebContent/";

			//String moduleName = "project";

			// gen jsp begin
			// jsp name
			String fileName = moduleName+".create";
			String actionPath = moduleName; 
			
			// jsp路径
			// String packagePath = "D:\work_space\secondjob\WebContent";
			// 数据库表中的所有列
			List<ColumnVO> columnList = new ArrayList<ColumnVO>();
			metaData(moduleName, columnList);
			U.printList(columnList);

			// *.jsp的内容

			// 取jsp 的 template
			String jspTemplateCode = getFileContent(srcPath
					+ "com/codegen/jsp/jsp.create.template");
			
			//jsp 里边 的from
			String formTemplateCode = getFileContent(srcPath
					+ "com/codegen/jsp/jsp.form.template");

			formTemplateCode = StringUtils.replace(formTemplateCode,
					"$actionPath$", actionPath);
			formTemplateCode = StringUtils.replace(formTemplateCode,
					"$title$", moduleName);
			
			String formContent = "";

			for (ColumnVO column : columnList) {
				if (column.getName().equalsIgnoreCase("id")) {
					continue; // id 写死 暂不动态处理
				}
				int columnDisplaySize = column.getColumnDisplaySize();
				
				String formPropertyCode = "";
				if(columnDisplaySize <500){	//input text
					 formPropertyCode = getFileContent(srcPath
							+ "com/codegen/jsp/jsp.form.property.template");
				}
				else{	//textarea
					 formPropertyCode = getFileContent(srcPath
							+ "com/codegen/jsp/jsp.form.textarea.template");
				}
				formPropertyCode = StringUtils.replace(formPropertyCode,
						"$propertyName$", column.getName());
				formContent += formPropertyCode;

			}

			formTemplateCode = StringUtils.replace(formTemplateCode,
					"$formContent$", formContent);
			jspTemplateCode = StringUtils.replace(jspTemplateCode,
					"$jspContent$", formTemplateCode);
			
			saveFile(jspTemplateCode, webPath + fileName + ".jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	public static void main(String[] args) {

		try {
			String moduleName = "resume";
			
			new JspForCreateGenerator().gen(moduleName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
