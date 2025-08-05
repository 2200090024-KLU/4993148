package Week1.DependencyInjectionExample;

public class Main {
    public static void main(String[] args) {
        // Create repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject into service
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.getCustomerInfo("CUST1001");
    }
}
