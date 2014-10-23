package com.recsys.text.parsing.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.recsys.text.parsing.common.DataField;
import com.recsys.text.parsing.common.DataType;

public class CSVFile {

	private File file;

	private String separator;

	private CSVDocument doc;
	
	// Whether a CSV file has Headers
	private boolean hasHeaders;

	public CSVFile(String fileName, boolean hasHeaders, CSVSchema schema) {

		this.hasHeaders = hasHeaders;

		file = new File(fileName);
	}

	public CSVEntry getHeaders() {

		CSVEntry e = null;

		if (doc.hasHeaders()) {
			e = doc.getHeaders();
		}

		return e;
	}

	public boolean hasHeaders() {
		return hasHeaders;
	}

	public CSVDocument read() throws IOException {

		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);

		CSVParser csvParser = new CSVParser(this);
		doc = csvParser.parse(bReader);

		bReader.close();
		
		return doc;
	}

	/**
	 * @return the doc
	 */
	public CSVDocument getDoc() {
		return doc;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		CSVSchema s = new CSVSchema();

		DataField f1 = new DataField("Order Id", DataType.LONG);
		s.addColumn(f1);

		DataField f2 = new DataField("Order Status", DataType.STRING);
		s.addColumn(f2);

		DataField f3 = new DataField("Order  Amount", DataType.DOUBLE);
		s.addColumn(f3);

		DataField f4 = new DataField("Product Id", DataType.STRING);
		s.addColumn(f4);

		CSVFile f = new CSVFile(args[0], true, s);
		f.read();
	}

	/**
	 * @return the separatorChar
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * @param separatorChar the separatorChar to set
	 */
	public void setSeparator(String val) {
		separator = val;
	}
}
