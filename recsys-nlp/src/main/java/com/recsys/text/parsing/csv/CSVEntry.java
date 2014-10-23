package com.recsys.text.parsing.csv;

import com.recsys.text.parsing.common.DataEntry;

public class CSVEntry extends DataEntry {

	public static final String DEFAULT_SEPARATOR = ",";
	private String separator;
	
	private String[] data;

	public CSVEntry(String csvLine) {
		this(csvLine,null);
	}
	
	public CSVEntry(String csvLine, String sepChar) {

		if (sepChar == null) {
			setSeparator(CSVEntry.DEFAULT_SEPARATOR);
		} else {
			setSeparator(sepChar);
		}
		
		data = csvLine.split(getSeparator());
	}

	public String getEntryAt(int i) {
		return data[i];
	}
	
	public String[] getData() {
		return data;
	}

	@Override
	public DataEntry getDataEntry() {

		return this;
	}

	@Override
	public String toString() {

		return toString(CSVEntry.DEFAULT_SEPARATOR);
	}

	public String toString(String printSeparator) {
		StringBuilder sb = new StringBuilder();
		int i=1;

		for (String s : data) {
			if (i<data.length) {
				sb.append(s).append(printSeparator);
			} else {
				sb.append(s);
			}
			i++;
		}
		return sb.toString();
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
	public void setSeparator(String separatorChar) {
		this.separator = separatorChar;
	}
}
