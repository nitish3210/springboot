package restful.restful;

import restful.restful.employee.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    @Transactional
    Employee getEmployee(int id);

    List<Employee> getEmployees();
}
