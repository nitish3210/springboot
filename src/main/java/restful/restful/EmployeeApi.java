package restful.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.restful.Exception.ResourceNotFoundException;
import restful.restful.employee.Employee;
import restful.restful.employee.UserInfo;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeApi {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeApi(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee data = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee data = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
           throw new ResourceNotFoundException("id not exist", "id", id);
        }
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

}
