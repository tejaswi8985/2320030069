package com.tejaswi;

public class Main {
	public static void main(String[] args) {
        DocumentGenerator generator = new SimpleDocumentGenerator();

        generator.setFormat(new PdfFormat());
        generator.generate("This is a PDF document.", "document.pdf");

     I   
        generator.setFormat(new WordFormat());
        generator.generate("This is a Word document.", "document.docx");
    }the 

}
