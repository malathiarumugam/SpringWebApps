/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Document ready function
$(document).ready(function () {
    loadContacts();
    // on click for our add button
    $('#add-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
        event.preventDefault();
// Make an Ajax call to the server. HTTP verb = POST, URL = address
        $.ajax({
            type: 'POST',
            url: 'address',
// Build a JSON object from the data in the form
            data: JSON.stringify({
                fName: $('#add-first-name').val(),
                lName: $('#add-last-name').val(),
                street: $('#add-street').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
// If the call succeeds, clear the form and reload the summary table
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-street').val('');
            $('#add-city').val('');
            $('#add-state').val('');
            $('#add-zip').val('');
            loadContacts();
//return false;
        });
    });
});
//==========
// FUNCTIONS
//==========
// Load addresss into the summary table
// Load addresss into the summary table
// Load addresss into the summary table
function loadContacts() {
// clear the previous list
    clearContactTable();
// grab the tbody element that will hold the new list of addresss
    var cTable = $('#contentRows');
// Make an Ajax GET call to the 'addresss' endpoint. Iterate through
// each of the JSON objects that are returned and render them to the
// summary table.
    $.ajax({
        url: "address"
    }).success(function (data, status) {
        $.each(data, function (index, address) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-address-id': address.addressId,
                                        'data-toggle': 'modal',
                                        'data-target': '#detailsModal'
                                    })
                                    .text(address.firstName + ' ' +
                                            address.lastName)
                                    ) // ends the <a> tag
                            ) // ends the <td> tag for the address name
                    .append($('<td>').text(address.street))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-address-id': address.addressId,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    })
                                    .text('Edit')
                                    ) // ends the <a> tag
                            ) // ends the <td> tag for Edit
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteContact(' +
                                                address.addressId + ')'
                                    })
                                    .text('Delete')
                                    ) // ends the <a> tag
                            ) // ends the <td> tag for Delete
                    ); // ends the <tr> for this Contact
        }); // ends the 'each' function
    });
}

function deleteContact(id) {
    var answer = confirm("Do you really want to delete this Address?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id
        }).success(function () {
            loadContacts();
        });
    }
}
// Clear all content rows from the summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// This code runs in response to show.bs.modal event for the details Modal
$('#detailsModal').on('show.bs.modal', function (event) {
// get the element that triggered the event
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
// make an ajax call to get address information for given address id
// this is a GET request to address/{id}
// upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#address-firstName').text(address.fName);
        modal.find('#address-lastName').text(address.lName);
        modal.find('#address-street').text(address.street);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
        modal.find('#address-zip').text(address.zip);
    });
});

// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#edit-address-id').val(address.addressId);
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-street').val(address.street);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-zip').val(address.zip);
    });
});

// onclick handler for edit button
$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
    event.preventDefault();
// Ajax call -
// Method - PUT
// URL - address/{id}
// Just reload all of the Contacts upon success
    $.ajax({
        type: 'PUT',
        url: 'address/' + $('#edit-address-id').val(),
        data: JSON.stringify({
            addressId: $('#edit-address-id').val(),
            firstName: $('#edit-first-name').val(),
            lastName: $('#edit-last-name').val(),
            street: $('#edit-street').val(),
            city: $('#edit-city').val(),
            state: $('#edit-state').val(),
            zip: $('#edit-zip').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadContacts();
    });
});

