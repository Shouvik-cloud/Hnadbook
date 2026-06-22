package DependencyInjectionExample;

public class CustomerService {

    private CustomerRepository customerRepository;

    // Dependency Injection through Constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer() {
        System.out.println(customerRepository.findCustomer());
    }
}