import bl.Util;
import entity.Address;
import entity.Employee;
import service.AddressService;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.Calendar;

public class Domain {

    public static void main(String[] args){
        Util util = new Util();
        util.getConnection();

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.AUGUST, 15);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        try{
            addressService.add(address);
            employeeService.add(employee);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
