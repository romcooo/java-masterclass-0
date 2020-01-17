package com.romco.isp;

public class ISP {

}

class Document {

}

//this is too complex
interface Machine {
    void print(Document d);
    void fax(Document document);
    void scan(Document document);
}

interface PrintCapable {
    void print(Document document);
}

interface FaxCapable {
    void fax(Document document);
}

interface ScanCapable {
    void scan(Document document);
}

interface MultiPrinterCapable extends PrintCapable, FaxCapable, ScanCapable {

}

// YAGNI = you ain't going to need it

class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {
    
    }
    
    @Override
    public void fax(Document document) {
    
    }
    
    @Override
    public void scan(Document document) {
    
    }
}

class SimplePrinter implements PrintCapable {
    @Override
    public void print(Document document) {
    
    }
}

class SimpleScanner implements ScanCapable {
    @Override
    public void scan(Document document) {
    
    }
}

class SimpleFax implements FaxCapable {
    @Override
    public void fax(Document document) {
    
    }
}

class MultiFunctionPrinter2 implements PrintCapable, ScanCapable, FaxCapable {
    @Override
    public void print(Document document) {
    
    }
    
    @Override
    public void fax(Document document) {
    
    }
    
    @Override
    public void scan(Document document) {
    
    }
}

class ProperMultiFunctionDevice implements MultiPrinterCapable {
    private SimplePrinter printer;
    private SimpleScanner scanner;
    private SimpleFax faxer;
    
    @Override
    public void print(Document document) {
        printer.print(document);
    }
    
    @Override
    public void fax(Document document) {
        faxer.fax(document);
    }
    
    @Override
    public void scan(Document document) {
        scanner.scan(document);
    }
}