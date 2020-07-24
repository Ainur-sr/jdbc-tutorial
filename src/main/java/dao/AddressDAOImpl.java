package dao;

import config.UtilDB;
import entity.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

    @Override
    public void add(Address address) {
        String sqlQuery = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM ADDRESS";

        try (Statement statement = UtilDB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));

                addressList.add(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return addressList;
    }

    @Override
    public Address getById(Long id) {
        String sqlQuery = "SELECT * FROM ADDRESS WHERE ID=?";
        Address address = null;
        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            address = new Address();
            if (resultSet.next()) {
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return address;
    }

    @Override
    public void update(Address address) {
        String sqlQuery = "UPDATE ADDRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?";
        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setString(5, address.getId().toString());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(Address address) {
        String sqlQuery = "DELETE FROM ADDRESS WHERE ID=?";

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, address.getId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
