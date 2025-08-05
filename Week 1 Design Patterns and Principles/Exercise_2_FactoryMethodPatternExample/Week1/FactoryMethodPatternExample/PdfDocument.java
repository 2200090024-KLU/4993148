package Week1.FactoryMethodPatternExample;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document.");
    }
}
