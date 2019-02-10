package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    // create
    void add(Address address) throws SQLException;

    // read
    List<Address> getAll() throws SQLException;

    Address getById(Long id);

    // update
    void update(Address address);

    // delete
    void delete(Address address);
}

