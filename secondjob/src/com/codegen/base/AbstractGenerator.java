package com.codegen.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.utils.L;
import com.vo.ColumnVO;

public class AbstractGenerator {
	public  void saveFile(String content, String path) {
		try {
			IOUtils.write(content, new FileOutputStream(new File(path)));
		} catch (Exception e) {
			L.exception("CodeGenerator", e.getMessage());
		}
	}

	public  String getFileContent(String path) {
		String fileContent = "";
		try {
			fileContent = IOUtils.toString(new FileInputStream(path), "UTF-8");
		} catch (Exception e) {
			L.exception("CodeGenerator", e.getMessage());
			return "";
		}
		return fileContent;
	}

	public  Connection getConnection() {

		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://wgsousou.gotoftp3.com:3306/wgsousou";
			String username = "wgsousou";
			String password = "cake4you@W";
			Connection conn = DriverManager.getConnection(url, username,
					password);

			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public  void metaData(String tableName, List<ColumnVO> columnList)
			throws SQLException {
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn
				.prepareStatement("select * from " + tableName);
		ResultSet resultSet = null;
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData data = null;
		data = (ResultSetMetaData) resultSet.getMetaData();
		for (int i = 1; i <= data.getColumnCount(); i++) {

			// 获得所有列的数目及实际列数
			int columnCount = data.getColumnCount();
			// 获得指定列的列名
			String columnName = data.getColumnName(i);
			// 获得指定列的列值
			// String columnValue = resultSet.getString(i);
			// 获得指定列的数据类型
			int columnType = data.getColumnType(i);
			// 获得指定列的数据类型名
			String columnTypeName = data.getColumnTypeName(i);
			// 所在的Catalog名字
			String catalogName = data.getCatalogName(i);
			// 对应数据类型的类
			String columnClassName = data.getColumnClassName(i);
			// 在数据库中类型的最大字符个数
			int columnDisplaySize = data.getColumnDisplaySize(i);
			// 默认的列的标题
			String columnLabel = data.getColumnLabel(i);
			// 获得列的模式
			String schemaName = data.getSchemaName(i);
			// 某列类型的精确度(类型的长度)
			int precision = data.getPrecision(i);
			// 小数点后的位数
			int scale = data.getScale(i);
			// 获取某列对应的表名
			String tableName1 = data.getTableName(i);
			// 是否自动递增
			boolean isAutoInctement = data.isAutoIncrement(i);
			// 在数据库中是否为货币型
			boolean isCurrency = data.isCurrency(i);
			// 是否为空
			int isNullable = data.isNullable(i);
			// 是否为只读
			boolean isReadOnly = data.isReadOnly(i);
			// 能否出现在where中
			boolean isSearchable = data.isSearchable(i);
			System.out.println(columnCount);
			System.out.println("获得列" + i + "的字段名称:" + columnName);
			// System.out.println("获得列" + i + "的字段值:" + columnValue);
			System.out.println("获得列" + i + "的类型,返回SqlType中的编号:" + columnType);
			System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
			System.out.println("获得列" + i + "所在的Catalog名字:" + catalogName);
			System.out.println("获得列" + i + "对应数据类型的类:" + columnClassName);
			System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"
					+ columnDisplaySize);
			System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
			System.out.println("获得列" + i + "的模式:" + schemaName);
			System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
			System.out.println("获得列" + i + "小数点后的位数:" + scale);
			System.out.println("获得列" + i + "对应的表名:" + tableName1);
			System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
			System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
			System.out.println("获得列" + i + "是否为空:" + isNullable);
			System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
			System.out.println("获得列" + i + "能否出现在where中:" + isSearchable);

			ColumnVO vo = new ColumnVO();
			vo.setName(columnName);
			vo.setType(columnClassName);
			vo.setColumnDisplaySize(columnDisplaySize);
			columnList.add(vo);

			// attributemMap.put(metaData.getColumnName(i),
			// resultSet.getObject(i));
		}
		resultSet.close();
		preparedStatement.close();
		conn.close();
	}
}
