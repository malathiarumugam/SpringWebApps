// Document ready function
// Document ready function
$(document).ready(function () {
    loadContacts();
    totalMovies();
});
//==========
// FUNCTIONS
//==========
function totalMovies() {
    clearTotal();
    var numOfMovies = $('#totalRows');
    numOfMovies.append($('<tr>')
            .append($('<td>').text(testContactData.length))
            );
}


function loadContacts() {
// clear the previous list
    clearContactTable();
// grab the tbody element that will hold the new list of contacts
    var cTable = $('#contentRows');
// Iterate through each of the JSON objects in the test contact data
// and render to the summary table
    $.each(testContactData, function (index, contact) {
        cTable.append($('<tr>')
                .append($('<td>')
                    .append($('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(contact.title)
                                ) // ends the <a> tag
                        ) 
                .append($('<td>').text(contact.releaseDate))
//                .append($('<td>').text(contact.mpaaRating))
//                .append($('<td>').text(contact.director))
//                .append($('<td>').text(contact.studio))
//                .append($('<td>').text(contact.note))
                );
    });
}

function clearContactTable() {
    $('#contentRows').empty();
}

function clearTotal() {
    $('#totalRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a contact
// name link in the summary table. This link has an attribute that contains
// the contactId for the given contact. We'll use that to retrieve the
// contact's details.
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    $('#modalRows').empty();
// grab the contact id
    var cTable = $('#modalRows');
// PLACEHOLDER: Eventually we'll make an ajax call to the server to get the

    var modal = $(this);
    cTable.append($('<tr>')
                .append($('<td>').text(testContactData[contactId-1].title))
                .append($('<td>').text(testContactData[contactId-1].releaseDate))
                .append($('<td>').text(testContactData[contactId-1].mpaaRating))
                .append($('<td>').text(testContactData[contactId-1].director))
                .append($('<td>').text(testContactData[contactId-1].studio))
                .append($('<td>').text(testContactData[contactId-1].note))
                );
});

var dummyDetailsContact =
        {
            contactId: 1,
            title: "Susan",
            releaseDate: "2015, 05, 31",
            mpaaRating: "R",
            director: "That one dude",
            studio: "Orlando Studios",
            note: "good things and stuff about the acting and props"
        };


// TEST DATA
var testContactData = [
    {
        contactId: 1,
        title: "Star Wars!",
        releaseDate: "2015, 05, 31",
        mpaaRating: "R",
        director: "That one dude",
        studio: "Orlando Studios",
        note: "good things and stuff about the acting and props"},
    {
        contactId: 2,
        title: "Lord of the Rings",
        releaseDate: "2015, 05, 31",
        mpaaRating: "R",
        director: "That one dude",
        studio: "Orlando Studios",
        note: "good things and stuff about the acting and props"},
    {
        contactId: 3,
        title: "The Hobbit",
        releaseDate: "2015, 05, 31",
        mpaaRating: "R",
        director: "That one dude",
        studio: "Orlando Studios",
        note: "good things and stuff about the acting and props"},
];
