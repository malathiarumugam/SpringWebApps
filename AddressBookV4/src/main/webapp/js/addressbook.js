// Document ready function
// Document ready function
$(document).ready(function () {
    loadContacts();
});
//==========
// FUNCTIONS
//==========
function loadContacts() {
// clear the previous list
    clearContactTable();
// grab the tbody element that will hold the new list of contacts
    var cTable = $('#contentRows');
// Iterate through each of the JSON objects in the test contact data
// and render to the summary table
    $.each(testContactData, function (index, contact) {
        cTable.append($('<tr>')
                .append($('<td>').text(contact.fName + ' ' + contact.lName))
                .append($('<td>').text(contact.street))
                .append($('<td>').text(contact.city))
                .append($('<td>').text(contact.state))
                .append($('<td>').text(contact.zip))
                );
    });
}

// Clear all content rows from the summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// TEST DATA
var testContactData = [
    {
        contactId: 1,
        fName: "Susan",
        lName: "Williams",
        street: "IBM",
        city: "IBM",
        state: "swilliams@ibm.com",
        zip: "555-1212"},
    {
        contactId: 2,
        fName: "Susan",
        lName: "Williams",
        street: "IBM",
        city: "IBM",
        state: "swilliams@ibm.com",
        zip: "555-1212"},
    {
        contactId: 3,
        fName: "Susan",
        lName: "Williams",
        street: "IBM",
        city: "IBM",
        state: "swilliams@ibm.com",
        zip: "555-1212"},
];
