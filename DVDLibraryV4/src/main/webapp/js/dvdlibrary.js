$(document).ready(function () {
    loadDVDs();
    totalMovies();
    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'dvd',
            data: JSON.stringify({
                Title: $('#add-title').val(),
                ReleaseDate: $('#add-release').val(),
                MPAARating: $('#add-rating').val(),
                Director: $('#add-director').val(),
                Studio: $('#add-studio').val(),
                Note: $('#add-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#add-title').val('');
            $('#add-release').val('');
            $('#add-rating').val('');
            $('#add-director').val('');
            $('#add-studio').val('');
            $('#add-note').val('');
            //  loadDVDs();
//return false;
        });
    });

    
});
//==========
// FUNCTIONS
//==========
function totalMovies() {
    //clearTotal();
    var numOfMovies = $('#totalRows');
    $.ajax({
        url: "count"
    }).success(function (data, status) {
        numOfMovies.append($('<tr>')
                .append($('<td>').text(data))
                );
    });
}


function loadDVDs() {
// clear the previous list
    //clearDVDTable();
// grab the tbody element that will hold the new list of DVDs
    var cTable = $('#contentRows');
// Iterate through each of the JSON objects in the test DVD data
// and render to the summary table
    $.ajax({
        url: "dvd"
    }).success(function (data, status) {
        $.each(data, function (index, dvd) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-DVD-id': dvd.id,
                                        'data-toggle': 'modal',
                                        'data-target': '#detailsModal'
                                    })
                                    .text(dvd.title)
                                    ) // ends the <a> tag
                            )
                    .append($('<td>').text(dvd.releaseDate))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-DVD-id': dvd.id,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    })
                                    .text('Edit')
                                    ) // ends the <a> tag
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteDvd(' +
                                                dvd.id + ')'
                                    })
                                    .text('Delete')
                                    ) // ends the <a> tag
                            ) // ends the <td> tag for Delete
                    );
        });
    });
}

function deleteDvd(id) {
    var answer = confirm("Do you really want to delete this movie?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            loadDVDs();
        });
    }
}

function clearDVDTable() {
    $('#contentRows').empty();
}

function clearTotal() {
    $('#totalRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a DVD
// name link in the summary table. This link has an attribute that contains
// the DVDId for the given DVD. We'll use that to retrieve the
// DVD's details.
    var element = $(event.relatedTarget);
    var dvdId = element.data('DVD-id');
    var modal = $(this);
// make an ajax call to get address information for given address id
// this is a GET request to address/{id}
// upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#add-id').text(dvd.id);
        modal.find('#add-title').text(dvd.title);
        modal.find('#add-release').text(dvd.release);
        modal.find('#add-rating').text(dvd.rating);
        modal.find('#add-director').text(dvd.director);
        modal.find('#add-studio').text(dvd.studio);
        modal.find('#add-note').text(dvd.note);
    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('DVD-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#add-id').text(dvd.id);
        modal.find('#add-title').text(dvd.title);
        modal.find('#add-release').text(dvd.release);
        modal.find('#add-rating').text(dvd.rating);
        modal.find('#add-director').text(dvd.director);
        modal.find('#add-studio').text(dvd.studio);
        modal.find('#add-note').text(dvd.note);
    });
});

$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-id').val(),
            data: JSON.stringify({
                movieId: $('#edit-id').val(),
                firstName: $('#edit-title').val(),
                lastName: $('#edit-release').val(),
                street: $('#edit-rating').val(),
                city: $('#edit-director').val(),
                state: $('#edit-studio').val(),
                zip: $('#edit-note').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadDVDs();
        });
    });

//
//var dummyDetailsDVD =
//        {
//            DVDId: 1,
//            title: "Susan",
//            releaseDate: "2015, 05, 31",
//            mpaaRating: "R",
//            director: "That one dude",
//            studio: "Orlando Studios",
//            note: "good things and stuff about the acting and props"
//        };


// TEST DATA
//var testDVDData = [
//    {
//        DVDId: 1,
//        title: "Star Wars!",
//        releaseDate: "2015, 05, 31",
//        mpaaRating: "R",
//        director: "That one dude",
//        studio: "Orlando Studios",
//        note: "good things and stuff about the acting and props"},
//    {
//        DVDId: 2,
//        title: "Lord of the Rings",
//        releaseDate: "2015, 05, 31",
//        mpaaRating: "R",
//        director: "That one dude",
//        studio: "Orlando Studios",
//        note: "good things and stuff about the acting and props"},
//    {
//        DVDId: 3,
//        title: "The Hobbit",
//        releaseDate: "2015, 05, 31",
//        mpaaRating: "R",
//        director: "That one dude",
//        studio: "Orlando Studios",
//        note: "good things and stuff about the acting and props"}
//];
