package FactoryMethodPatternExample;

public class Main {

    public static void main(String[] args) {

        Document doc1 = DocumentFactory.createDocument("word");
        Document doc2 = DocumentFactory.createDocument("pdf");
        Document doc3 = DocumentFactory.createDocument("excel");

        doc1.open();
        doc2.open();
        doc3.open();
    }
}