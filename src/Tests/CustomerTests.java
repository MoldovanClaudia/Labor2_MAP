package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControllerDB.CustomerControllerDB;
import Domain.Customer;
import RepositoryDB.CustomerRepositoryDB;
import UiDB.CustomerUiDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerTests {

    private CustomerRepositoryDB customerRepository;
    private CustomerControllerDB customerController;
    private CustomerUiDB customerUi;

    @Before
    public void setUp() {
        customerRepository = new CustomerRepositoryDB();
        customerController = new CustomerControllerDB(customerRepository);
        customerUi = CustomerUiDB.getInstance(); // Assuming you have a getInstance method in CustomerUiDB
    }

    @Test
    public void testAddCustomer() {
        customerController.addCustomer(1, "John", "Doe", "123456789", "123 Main St");

        ArrayList<Customer> customers = customerController.getAllCustomers();
        assertEquals(1, customers.size());

        Customer addedCustomer = customers.get(0);
        assertEquals(1, addedCustomer.getCustomerIdId());
        assertEquals("John", addedCustomer.getFirstName());
        assertEquals("Doe", addedCustomer.getLastName());
        assertEquals("123456789", addedCustomer.getContact());
        assertEquals("123 Main St", addedCustomer.getBillingAddress());
    }

    @Test
    public void testUpdateCustomer() {
        customerController.addCustomer(2, "John", "Doe", "123456789", "123 Main St");

        Map<String, String> updates = new HashMap<>();
        updates.put("firstName", "UpdatedFirstName");
        updates.put("lastName", "UpdatedLastName");

        ArrayList<String> customerIdList = new ArrayList<>();
        customerIdList.add("2");

        customerController.update(customerIdList, updates);

        Customer updatedCustomer = customerController.getAllCustomers().get(1);
        assertEquals("UpdatedFirstName", updatedCustomer.getFirstName());
        assertEquals("UpdatedLastName", updatedCustomer.getLastName());
    }

    @Test
    public void testDeleteCustomer() {
        customerController.addCustomer(3, "John", "Doe", "123456789", "123 Main St");

        ArrayList<Customer> customersBeforeDelete = customerController.getAllCustomers();
        assertEquals(3, customersBeforeDelete.size());

        customerController.deleteCustomer(new ArrayList<String>(){{ add("1"); }});

        ArrayList<Customer> customersAfterDelete = customerController.getAllCustomers();
        assertEquals(2, customersAfterDelete.size());
    }

}
