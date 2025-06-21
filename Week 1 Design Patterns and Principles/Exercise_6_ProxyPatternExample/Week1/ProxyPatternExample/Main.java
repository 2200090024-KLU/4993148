package Week1.ProxyPatternExample;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature_photo.jpg");

        // Image is not loaded yet
        System.out.println("First call:");
        image1.display(); // Loads from disk

        System.out.println("\nSecond call:");
        image1.display(); // Uses cache
    }
}
