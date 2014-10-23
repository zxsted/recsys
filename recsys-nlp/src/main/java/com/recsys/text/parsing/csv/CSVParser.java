package com.recsys.text.parsing.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;

import com.recsys.text.parsing.common.AbstractDocument;
import com.recsys.text.parsing.common.DataEntry;
import com.recsys.text.parsing.common.DocumentParser;
import com.recsys.text.parsing.common.DocumentParserException;
import com.recsys.text.parsing.common.ProcessedDocument;

public class CSVParser implements DocumentParser {

	private CSVDocument d;

	private CSVFile csvFile;
	
	private long linesParsed = 0;

	/**
	 * 
	 */
	public CSVParser(CSVFile f) {
		this.csvFile = f;
	}

	@Override
	public DataEntry getDataEntry(int i) {
		return d.getCsvData().get(i);
	}

	public long getLinesParsed() {
		return linesParsed;
	}

	@Override
	public ProcessedDocument parse(AbstractDocument abstractDocument)
			throws DocumentParserException {
		ProcessedDocument processedDocument = null;
		String content = new String(abstractDocument.getDocumentContent(),
				Charset.forName(abstractDocument.getContentCharset()));
		BufferedReader reader = new BufferedReader(new StringReader(content));
		try {
			abstractDocument = parse(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return processedDocument;
	}

	/**
	 * 
	 * @param bR
	 * @return
	 * @throws IOException
	 */
	public CSVDocument parse(BufferedReader bR) throws IOException {

		d = new CSVDocument();

		linesParsed = 0;

		boolean hasMoreLines = true;
		String line;

		while (hasMoreLines) {

			line = bR.readLine();

			if (line == null) {

				hasMoreLines = false;

			} else {

				CSVEntry csvEntry = new CSVEntry(line, getSeparator());
				if (linesParsed == 0) {
					d.setHeaders(csvEntry); 
				} else {
					d.getCsvData().add(csvEntry);					
				}
				linesParsed++;
			}
		}

		return d;
	}

	/**
	 * @return the separator
	 */
	public String getSeparator() {
		return csvFile.getSeparator();
	}
}
