package com.mycompany.addressbookv4.dao;

import com.mycompany.addressbookv4.model.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBookDaoImpl implements AddressBook {
// holds all of our Address objects - simulates the database

    private Map<Integer, Address> addressMap = new HashMap<>();
// used to assign ids to Addresss - simulates the auto increment
// primary key for Addresss in a database
    private static int addressIdCounter = 0;

    @Override
    public Address addAddress(Address address) {
// assign the current counter values as the addressid
        address.setAddressId(addressIdCounter);
// increment the counter so it is ready for use for the next address
        addressIdCounter++;
        addressMap.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        addressMap.remove(addressId);
    }

    @Override
    public void updateAddress(Address address) {
        addressMap.put(address.getAddressId(), address);
    }

    @Override
    public List<Address> getAllAddresss() {
        Collection<Address> c = addressMap.values();
        return new ArrayList(c);
    }

    @Override
    public Address getAddressById(int addressId) {
        return addressMap.get(addressId);
    }

    @Override
    public List<Address> searchAddresss(Map<SearchTerm, String> criteria) {
// Get all the search terms from the map
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String streetCriteria = criteria.get(SearchTerm.STREET);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipCriteria = criteria.get(SearchTerm.ZIP);
// Declare all the
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> streetMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipMatches;
        //predicate conditions 
        
        
        
        
// Placeholder predicate - always returns true. Used for search terms
// that are empty
        Predicate<Address> truePredicate = (c) -> {
            return true;
        };
// Assign values to predicates. If a given search term is empty, just
// assign the default truePredicate, otherwise assign the predicate that
// properly filters for the given term.
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getfName().equals(firstNameCriteria);
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getlName().equals(lastNameCriteria);
        streetMatches = (streetCriteria == null || streetCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStreet().equals(streetCriteria);
        cityMatches = (cityCriteria == null || cityCriteria.isEmpty())
                ? truePredicate
                 :(c)-> c.getCity().equals(cityCriteria);
        stateMatches = (stateCriteria == null || stateCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getState().equals(stateCriteria);
        zipMatches = (zipCriteria == null || zipCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getZip().equals(zipCriteria);
// Return the list of Addresss that match the given criteria. To do this we
// just AND all the predicates together in a filter operation.
        return addressMap.values().stream()
                .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(streetMatches)
                        .and(cityMatches)
                        .and(stateMatches)
                        .and(zipMatches))
                .collect(Collectors.toList());
    }
}
