package com.recsys.text.parsing.msword;

import com.recsys.text.parsing.common.DocumentParserException;

public class MSWordDocumentParserException extends DocumentParserException {

	private static final long serialVersionUID = -3005082246637918030L;

	public MSWordDocumentParserException(String msg) {
		super(msg);
	}

	public MSWordDocumentParserException(String msg, Throwable t) {
		super(msg, t);
	}
}
