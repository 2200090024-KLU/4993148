package Week1.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String customerId) {
        // Simulated DB lookup
        return "Customer{id='" + customerId + "', name='Aparna Uppala'}";
    }
}
