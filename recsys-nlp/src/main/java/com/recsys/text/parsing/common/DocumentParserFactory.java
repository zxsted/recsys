package com.recsys.text.parsing.common;

import com.recsys.text.parsing.html.HTMLDocumentParser;
import com.recsys.text.parsing.msword.MSWordDocumentParser;
import com.recsys.text.parsing.pdf.PDFDocumentParser;

public class DocumentParserFactory {

	private static DocumentParserFactory instance = new DocumentParserFactory();

	public static DocumentParserFactory getInstance() {
		return instance;
	}

	private DocumentParserFactory() {
		// empty
	}

	/**
	 * Returns an instance of the <code>DocumentParser</code> based on the
	 * document type.
	 * 
	 * @param type
	 *            document type.
	 * @return
	 * @throws DocumentParserException
	 */
	public DocumentParser getDocumentParser(String type)
			throws DocumentParserException {
		
		if (ProcessedDocument.TYPE_HTML.equalsIgnoreCase(type)) {
			return new HTMLDocumentParser();
		} else if (ProcessedDocument.TYPE_MSWORD.equalsIgnoreCase(type)) {
			return new MSWordDocumentParser();
		} else if (ProcessedDocument.TYPE_PDF.equalsIgnoreCase(type)) { 
			return new PDFDocumentParser();
		} else if (ProcessedDocument.TYPE_TEXT.equalsIgnoreCase(type)) { 
			return new PDFDocumentParser();
		}else {
			throw new DocumentParserException("Unsupported document type: '"
					+ type + "'.");
		}
	}
}
