package com.recsys.text.parsing.common;

public interface DocumentParser {

	public DataEntry getDataEntry(int i);

	public ProcessedDocument parse(AbstractDocument doc)
			throws DocumentParserException;

}
