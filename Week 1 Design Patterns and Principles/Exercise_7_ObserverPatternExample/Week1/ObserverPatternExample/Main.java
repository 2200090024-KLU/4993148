package Week1.ObserverPatternExample;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileClient = new MobileApp("Client1");
        Observer webClient = new WebApp("Client2");

        stockMarket.registerObserver(mobileClient);
        stockMarket.registerObserver(webClient);

        stockMarket.setStock("INFY", 1745.50);
        System.out.println("-----");
        stockMarket.setStock("TCS", 3699.95);
    }
}
