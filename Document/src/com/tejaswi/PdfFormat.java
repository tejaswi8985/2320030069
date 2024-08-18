package com.tejaswi;

public class PdfFormat implements DocumentFormat {
	public void generateDocument(String content, String filePath) {
        System.out.println("Generating PDF document at: " + filePath);
    }
}
