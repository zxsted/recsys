package com.recsys.text.parsing.pdf;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.recsys.text.parsing.common.AbstractDocument;
import com.recsys.text.parsing.common.DataEntry;
import com.recsys.text.parsing.common.DocumentParser;
import com.recsys.text.parsing.common.DocumentParserException;
import com.recsys.text.parsing.common.ProcessedDocument;

public class PDFDocumentParser implements DocumentParser {

	// Just set it to something large
	private static final int STRING_BUFFER_SIZE = 16*1024*1024;
	
	ProcessedDocument pdfDoc = new ProcessedDocument();

	@Override
	public DataEntry getDataEntry(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcessedDocument parse(AbstractDocument doc) throws DocumentParserException {

		Parser parser = new AutoDetectParser();
		ContentHandler handler = new BodyContentHandler(STRING_BUFFER_SIZE);
	  
		Metadata metadata = new Metadata();

		try (ByteArrayInputStream is = new ByteArrayInputStream(doc.getDocumentContent())) {
			 		  
			parser.parse(is, handler, metadata, new ParseContext());
		  
		 } catch (IOException ioX) {
			 throw new PDFDocumentParserException(ioX.getLocalizedMessage());
		 } catch (TikaException tikaX) {
			 throw new PDFDocumentParserException(tikaX.getLocalizedMessage());
		 } catch (SAXException eX) {
			 throw new PDFDocumentParserException(eX.getLocalizedMessage());
		 } 
		 
		pdfDoc.setDocumentType(ProcessedDocument.TYPE_PDF);
		pdfDoc.setDocumentId(doc.getDocumentId());
		pdfDoc.setDocumentURL(doc.getDocumentURL());
		pdfDoc.setText(handler.toString());
		pdfDoc.setContent(handler.toString());
		pdfDoc.setDocumentTitle(metadata.get("title"));

		return pdfDoc;
	}
}
