package com.mycompany.addressbookv4.controller;


import com.mycompany.addressbookv4.dao.AddressBook;
import com.mycompany.addressbookv4.model.Address;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller

//Author: Dessa 
public class HomeController {

    private AddressBook dao;

    @Inject
    public HomeController(AddressBook dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddress(@PathVariable("id") int id) {
        // retrieve the Address associated with the given id and return it
        return dao.getAddressById(id);
    }

    // This method will be invoked by Spring MVC when it sees a POST request for
// AddressListMVC/address. It persists the given Address to the data layer.
//
// @ResponseStatus tells Spring MVC to return an HTTP CREATED status upon
//success
//
// @ResponseBody indicates that the object returned by this method should
// be put in the body of the response going back to the caller.
//
// @RequestBody indicates that we expect a Address object
// in the body of the incoming request.
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address createAddress(@Valid @RequestBody Address address) {
        // persist the incoming address
        dao.addAddress(address);
        // The addAddress call to the dao assigned a addressId to the incoming
        // Address and set that value on the object. Now we return the updated
        // object to the caller.
        return address;

    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") int id) {
        // remove the Address associated with the given id from the datalayer
        dao.removeAddress(id);
    }

    // This method will be invoked by Spring MVC when it sees a PUT request for
// AddressListMVC/address/<some-address-id>. It updates the given Address
// to the data layer.
//
// @ResponseStatus tells Spring MVC to return HTTP NO_CONTENT from this call
// because this method has no return value.
//
// @PathVariable indicates that the portion of the URL path marked by curly
// braces {...} should be stripped out, converted to an int and passed into
// this method when it is invoked.
//
// @RequestBody indicates that we expect a Address object in the body of the
// incoming request.
    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putAddress(@PathVariable("id") int id, @RequestBody Address address) {
        // set the value of the PathVariable id on the incoming Address object
        // to ensure that a) the address id is set on the object and b) that
        // the value of the PathVariable id and the Address object id are the
        // same.
        address
                .setAddressId(id);
        // update the address
        dao.updateAddress(address);
    }

    // This method will be invoked by Spring MVC when it sees a GET request for
// AddressListMVC/addresss. It retrieves all of the Addresss from the
// data layer and returns them in a List.
//
// @ResponseBody indicates that the List returned by this method should
// be put in the body of the response going back to the caller.
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresss() {
// get all of the Addresss from the data layer
        return dao.getAllAddresss();
    }
}
