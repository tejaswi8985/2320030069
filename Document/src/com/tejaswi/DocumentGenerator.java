package com.tejaswi;

public interface DocumentGenerator {
	void generate(String content, String filePath);
    void setFormat(DocumentFormat format);

}
