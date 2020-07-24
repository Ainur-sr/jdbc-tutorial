import entity.Address;
import service.AddressService;

import java.util.Random;

public class Domain {

    public static void main(String[] args) {

        AddressService addressService = new AddressService();

        //add
        /*
        Address address1 = new Address();
        address1.setId((long) (Math.random() * 1000));
        address1.setCountry("Ufa");
        address1.setCity("Str");
        address1.setStreet("Volcovo");
        address1.setPostCode("6436452");
        addressService.add(address1);
        */

        //getAll
//        System.out.println(addressService.getAll());

        //getById
/*        Address address = addressService.getById((long) 2);

        System.out.println(address);

        address.setStreet("Holinson");

        //update
        addressService.update(address);

        //delete
        addressService.remove(address);*/

    }
}
