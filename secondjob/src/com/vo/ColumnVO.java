package com.vo;

/*
 * column info for db table, like column name, column type
 */
public class ColumnVO {
	private String name;
	private String type;
	private int columnDisplaySize;

	public int getColumnDisplaySize() {
		return columnDisplaySize;
	}

	public void setColumnDisplaySize(int columnDisplaySize) {
		this.columnDisplaySize = columnDisplaySize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ColumnVO [name=" + name + ", type=" + type
				+ ", columnDisplaySize=" + columnDisplaySize + "]";
	}

 

}
