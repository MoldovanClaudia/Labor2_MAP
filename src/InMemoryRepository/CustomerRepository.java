package InMemoryRepository;
import Domain.Customer;
import java.util.ArrayList;

public class CustomerRepository implements InMemoryRepository<Customer> {
    private final ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    public void addItem(Customer newCustomer) {
        customers.add(newCustomer);
    }

    @Override
    public void deleteItem(Customer customerToBeDeleted) {
         customers.remove(customerToBeDeleted);
    }

    @Override
    public void updateItem(Customer oldCustomer, Customer newCustomer) {
        int index = customers.indexOf(oldCustomer);
        if (index != -1) {
            customers.set(index,newCustomer);
        }
    }

    @Override
    public ArrayList<Customer> getAllItems() {
        return customers;
    }

    @Override
    public Customer findById(int cutomerId) {
        for(Customer customer : customers) {
            if (customer.getCustomerIdId() == cutomerId) {
                return customer;
            }
        }
        return null;
    }





}
