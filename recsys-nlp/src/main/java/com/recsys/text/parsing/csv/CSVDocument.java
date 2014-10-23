package com.recsys.text.parsing.csv;

import java.util.ArrayList;

import com.recsys.text.parsing.common.ProcessedDocument;

public class CSVDocument extends ProcessedDocument {

	private CSVEntry headers;
	private ArrayList<CSVEntry> csvData;
	private boolean hasHeaders;

	public CSVDocument() {
		csvData = new ArrayList<CSVEntry>();
	}
	
	public CSVDocument(ArrayList<CSVEntry> data) {
		csvData = data;
	}

	public CSVEntry getHeaders() {
		return headers;
	}
	
	public boolean hasHeaders() {
		return	hasHeaders;
	}
	
	public void hasHeaders(boolean val) {
		hasHeaders = val;
	}

	/**
	 * @return the csvData
	 */
	public ArrayList<CSVEntry> getCsvData() {
		return csvData;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(CSVEntry headers) {
		this.headers = headers;
	}
}
