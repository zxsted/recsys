package com.recsys.text.parsing.csv;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

import com.recsys.text.parsing.common.DataField;

public class CSVSchema implements Serializable {

	private static final long serialVersionUID = -8265277706414216835L;

	private String name;
	private HashMap<UUID, DataField> columnMap;

	public CSVSchema() {
		columnMap = new HashMap<>();
	}

	public void addColumn(DataField field) {
		
		columnMap.put(UUID.randomUUID(), field);
	}

	public int getNumberOfColumns() {
		return columnMap.size();
	}
			
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
