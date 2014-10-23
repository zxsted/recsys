package com.recsys.text.parsing.common;

import java.io.Serializable;

public class DataField implements Serializable {

	private static final long serialVersionUID = 795910732043254883L;
	
	private String name;
	private DataType dataType;

	public DataField(String name, DataType dataType) {
		this.name = name;
		this.dataType = dataType;
	}

	public DataType getDataType() {
		return dataType;
	}

	public String getName() {
		return name;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean validate(String s) {
		boolean isValid = true;

		return isValid;
	}
}
