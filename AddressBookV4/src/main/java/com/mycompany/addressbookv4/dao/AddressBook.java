package com.mycompany.addressbookv4.dao;

import com.mycompany.addressbookv4.model.Address;
import java.util.List;
import java.util.Map;

public interface AddressBook {
// add the given Address to the data store

    public Address addAddress(Address address);
// remove the Address with the given id from the data store

    public void removeAddress(int addressId);
// update the given Address in the data store

    public void updateAddress(Address address);
// retrieve all Addresss from the data store

    public List<Address> getAllAddresss();
// retrieve the Address with the given id from the data store

    public Address getAddressById(int addressId);
// search for Addresss by the given search criteria values

    public List<Address> searchAddresss(Map<SearchTerm, String> criteria);
}

