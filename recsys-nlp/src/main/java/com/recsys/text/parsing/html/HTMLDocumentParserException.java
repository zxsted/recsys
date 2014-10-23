package com.recsys.text.parsing.html;

import com.recsys.text.parsing.common.DocumentParserException;

public class HTMLDocumentParserException extends DocumentParserException {

	private static final long serialVersionUID = 3397930132653232196L;

	public HTMLDocumentParserException(String msg) {
		super(msg);
	}

	public HTMLDocumentParserException(String msg, Throwable t) {
		super(msg, t);
	}
}
