package service;

import dao.AddressDAO;
import dao.AddressDAOImpl;
import entity.Address;

import java.util.List;

public class AddressService  {

    private AddressDAO addressDAO = new AddressDAOImpl();;

    public AddressService() {
    }

    public void add(Address address){
        addressDAO.add(address);
    }

    public List<Address> getAll(){
        return addressDAO.getAll();
    }

    public Address getById(Long id){
        return addressDAO.getById(id);
    }

    public void update(Address address){
        addressDAO.update(address);
    }

    public void remove(Address address){
        addressDAO.remove(address);
    }
}
