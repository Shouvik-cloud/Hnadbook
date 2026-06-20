package FactoryMethodPatternExample;

public class DocumentFactory {

    public static Document createDocument(String type) {

        if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        }

        if (type.equalsIgnoreCase("pdf")) {
            return new PdfDocument();
        }

        return new ExcelDocument();
    }
}