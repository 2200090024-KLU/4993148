package Week1.BuilderPatternExample;

public class Main {
    public static void main(String[] args) {
        // Basic Computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB").build();
        basicComputer.displaySpecs();

        // Gaming Computer
        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3060")
                .setOperatingSystem("Windows 11")
                .build();
        gamingComputer.displaySpecs();

        // Office Computer
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Ubuntu 22.04")
                .build();
        officeComputer.displaySpecs();
    }
}
