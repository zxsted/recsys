package com.recsys.text.parsing.common;

public interface AbstractDocument {

	public String getContentCharset();

	public String getContentType();

	public byte[] getDocumentContent();

	public String getDocumentId();

	public String getDocumentURL();
}
