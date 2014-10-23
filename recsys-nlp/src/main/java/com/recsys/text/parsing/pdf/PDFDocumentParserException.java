package com.recsys.text.parsing.pdf;

import com.recsys.text.parsing.common.DocumentParserException;

public class PDFDocumentParserException extends DocumentParserException {

	private static final long serialVersionUID = -3005082246637918030L;

	public PDFDocumentParserException(String msg) {
		super(msg);
	}

	public PDFDocumentParserException(String msg, Throwable t) {
		super(msg, t);
	}
}
