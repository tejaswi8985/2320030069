package com.tejaswi;


public class DocumentGeneratorTest {
	private DocumentGenerator generator;
    private DocumentFormat pdfFormat;
    private DocumentFormat wordFormat;
    public void setUp() {
        generator = new SimpleDocumentGenerator();
        pdfFormat = mock(DocumentFormat.class);
        wordFormat = mock(DocumentFormat.class);
    }
    private DocumentFormat mock(Class<DocumentFormat> class1) {
		
		return null;
	}
	public void testGeneratePdfDocument() {
        generator.setFormat(pdfFormat);
        generator.generate("Test PDF content", "test.pdf");
        verify(pdfFormat).generateDocument("Test PDF content", "test.pdf");
    }
    public void testGenerateWordDocument() {
        generator.setFormat(wordFormat);
        generator.generate("Test Word content", "test.docx");
        verify(wordFormat).generateDocument("Test Word content", "test.docx");
    }
    private DocumentFormat verify(DocumentFormat wordFormat2) {
		
		return null;
	}
	public void testGenerateWithoutFormat() {
        generator.generate("Test content", "test.txt");
    }
}
