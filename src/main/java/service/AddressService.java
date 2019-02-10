package service;

import bl.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong( 1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<Address>();

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));

                addressList.add(address);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return addressList;
    }

    @Override
    public Address getById(Long id) {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void delete(Address address) {

    }
}
