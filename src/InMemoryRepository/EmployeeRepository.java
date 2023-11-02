package InMemoryRepository;
import Domain.Employee;
import java.util.ArrayList;

public class EmployeeRepository implements InMemoryRepository<Employee>{
    private final ArrayList<Employee> employees = new ArrayList<Employee>();

    @Override
    public void addItem(Employee newEmployee) {
        employees.add(newEmployee);
    }

    @Override
    public void deleteItem(Employee employeeToBeDeleted) {
        employees.remove(employeeToBeDeleted);
    }

    @Override
    public void updateItem(Employee oldEmployee, Employee newEmployee) {
        int index = employees.indexOf(oldEmployee);
        if (index != -1) {
            employees.set(index,newEmployee);
        }
    }

    @Override
    public ArrayList<Employee> getAllItems() {
        return employees;
    }

}
