package Week1.DependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerInfo(String customerId) {
        String customerData = repository.findCustomerById(customerId);
        System.out.println("Fetched: " + customerData);
    }
}
