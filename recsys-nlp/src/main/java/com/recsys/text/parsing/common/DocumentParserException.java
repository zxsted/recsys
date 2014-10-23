package com.recsys.text.parsing.common;

public class DocumentParserException extends Exception {

	private static final long serialVersionUID = 4938858042489090351L;

	public DocumentParserException(String msg) {
		super(msg);
	}

	public DocumentParserException(String msg, Throwable t) {
		super(msg, t);
	}
}
