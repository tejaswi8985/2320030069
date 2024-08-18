package com.tejaswi;

public class WordFormat implements DocumentFormat {
	  @Override
	public void generateDocument(String content, String filePath) {
        System.out.println("Generating Word document at: " + filePath);
    }
}
