import config.UtilDB;
import entity.Address;
import org.junit.Before;
import org.junit.Test;
import service.AddressService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AppJdbcTest {

    private static AddressService addressService;

    @Before
    public void init() throws SQLException {
        addressService = new AddressService();
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try (Connection connection = UtilDB.getConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }

    @Test
    public void shouldAddAddress() {
        addressService.add(createAdsress());
        Address address = addressService.getById(111L);
        assertNotNull(address);
        assertEquals(111L, (long) address.getId());
        assertEquals("TestCountry", address.getCountry());
        assertEquals("654321", address.getPostCode());

    }

    private Address createAdsress() {
        Address address = new Address();
        address.setId((long) 111);
        address.setCountry("TestCountry");
        address.setCity("TestCity");
        address.setStreet("TestStreet");
        address.setPostCode("654321");
        return address;
    }

    @Test
    public void shouldGetAddressList(){
        List<Address> addressList = addressService.getAll();
        assertNotNull(addressList);
        assertTrue(addressList.size() > 0);
    }

    @Test
    public void shouldDeleteAddress(){
        addressService.remove(createAdsress());
        List<Address> addressList = addressService.getAll();
        assertFalse(addressList.contains(createAdsress()));
    }

    @Test
    public void shouldUpdateAddress(){
        Address a = new Address();
        a.setId(222L);
        a.setCountry("OldCountry");
        a.setCity("OldCity");
        a.setStreet("OldStreet");
        a.setPostCode("3421234");
        addressService.add(a);
        a.setStreet("NewStreet");
        addressService.update(a);

        Address updatedAddress = addressService.getById(a.getId());
        addressService.remove(a);

        assertEquals(updatedAddress.getStreet(), a.getStreet());
    }




}
