package com.tejaswi;

public class SimpleDocumentGenerator implements DocumentGenerator {
    private DocumentFormat format;
    public void setFormat(DocumentFormat format) {
        this.format = format;
    }
    public void generate(String content, String filePath) {
        if (format == null) {
            throw new IllegalStateException("DocumentFormat must be set before generating the document.");
        }
        format.generateDocument(content, filePath);
    }

}
