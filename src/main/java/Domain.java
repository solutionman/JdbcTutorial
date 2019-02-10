import bl.Util;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;

public class Domain {

    public static void main(String[] args){
        Util util = new Util();
        util.getConnection();

        AddressService addressService = new AddressService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street");
        address.setPostCode("12345");

        try{
            addressService.add(address);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
