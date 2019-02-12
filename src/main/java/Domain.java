import bl.Util;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class Domain {

    public static void main(String[] args){
        Util util = new Util();
        util.getConnection();

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("USA");
        address.setCity("Miami");
        address.setStreet("Ocean Drive");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Vasiliy");
        employee.setLastName("Suhov");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.AUGUST, 15);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("The perfect coders project");

        try{
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
