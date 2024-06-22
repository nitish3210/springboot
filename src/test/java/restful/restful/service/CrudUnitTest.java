//package restful.restful.service;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.web.client.RestTemplate;
//import restful.restful.employee.Employee;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CrudUnitTest {
//    @LocalServerPort
//    private int port;
//
//    private String baseUrl = "http://localhost";
//
//    private static RestTemplate restTemplate;
//
//    @Autowired
//    private TestH2Repository h2Repository;
//
//    @BeforeAll
//    public static void init() {
//        restTemplate = new RestTemplate();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        baseUrl = baseUrl.concat(":").concat(port + "").concat("/employee");
//    }
//
//
//    @Test
//    public void testAddEmployee() {
//        Employee employee = new Employee("Shubham", "Singh", "shu@gmail.com");
//        Employee response = restTemplate.postForObject(baseUrl, employee, Employee.class);
//        assertEquals("Shubham", response.getFirstname());
//        assertEquals(1, h2Repository.findAll().size());
//    }
//
//    @Test
//    public void testGetEmployees() {
//        List<Employee> employees = restTemplate.getForObject(baseUrl, List.class);
//        assertEquals(1, employees.size());
//        assertEquals(1, h2Repository.findAll().size());
//    }
//
//    @Test
//    public void testUpdateEmployee(){
//        Employee employee = new Employee("Shubham", "Murmu", "shu@gmail.com");
//        restTemplate.put(baseUrl, employee, 6);
//        Employee employeeFromDB = h2Repository.findById(2).get();
//        assertAll(
//                () -> assertNotNull(employeeFromDB),
//                () -> assertEquals("Shubham", employee.getFirstname())
//        );
//    }
//
//    @Test
//    public void testGetEmployeeById() {
//        Employee employee = restTemplate.getForObject(baseUrl + "/{id}", Employee.class, 1);
//        assertAll(
//                () -> assertNotNull(employee),
//                () -> assertEquals(1, employee.getId()),
//                () -> assertEquals("Ramesh", employee.getFirstname())
//        );
//
//    }
//}
