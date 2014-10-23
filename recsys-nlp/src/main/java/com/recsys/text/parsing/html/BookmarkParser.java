package com.recsys.text.parsing.html;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.recsys.text.parsing.common.ProcessedDocument;

public class BookmarkParser extends HTMLDocumentParser {

	/**
	 * 
	 */
	public BookmarkParser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param reader
	 * @throws HTMLDocumentParserException
	 */
	public BookmarkParser(Reader reader) throws HTMLDocumentParserException {
		super(reader);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String filename = args[0];
		BookmarkParser bookParser = null;
		ProcessedDocument doc = null;
		try {
			bookParser = new BookmarkParser();
			InputStream inputStream = new BufferedInputStream(
					new FileInputStream(filename));
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			doc = bookParser.parse(reader);
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse html from file: "
					+ filename, e);
		}

		//P.println(doc.getText());
		
	}

}
