package restful.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import restful.restful.employee.Employee;
import restful.restful.employee.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    public static final Logger logInfo = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * create new employee
     * @param employee
     * @return
     */
    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        //logging using slf4j
//        logInfo.debug("New Employee Created successfully");
        return employeeRepository.save(employee);
    }

    /**
     * get employee by empId
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Employee getEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
//        if(employee.getFirstname().equals("Suresh") ){
//            throw new RuntimeException("Name Matched");
//        }
        //logging using slf4j
//        logInfo.warn(" employee fetched successfully");
        return employee;
    }

    /**
     * get all employees
     * @return
     */
    @Transactional
    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if(!CollectionUtils.isEmpty(employees)){
            //logging using slf4j
//            logInfo.debug("list of employee fetched successfully");
            return employees;
        }
        return null;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
