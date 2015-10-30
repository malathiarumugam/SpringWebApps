$(document).ready(function () {
    loadDVDs();
    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'dvd',
            data: JSON.stringify({
                title: $('#add-title').val(),
                releaseDate: $('#add-release').val(),
                mpaaRating: $('#add-rating').val(),
                director: $('#add-director').val(),
                studio: $('#add-studio').val(),
                note: $('#add-note').val()
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
            loadDVDs();
            $('#validationErrors').empty();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index,
                    validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });

    });
});
//==========
// FUNCTIONS
//==========
function totalMovies() {
    clearTotal();
    var numOfMovies = $('#totalRows');
    $.ajax({
        url: "count"
    }).success(function (data, status) {
        numOfMovies.append($('<tr>')
                .append($('<td>').text(data))
                );
    });
}

function searchMovies() {
    clearSTotal();
    var numOfMovies = $('#searchRows');
    $.ajax({
        url: "count2"
    }).success(function (data, status) {
        numOfMovies.append($('<tr>')
                .append($('<td>').text(data))
                );
    });
}



function loadDVDs() {
// clear the previous list
    totalMovies();
    clearSTotal();
// Iterate through each of the JSON objects in the test DVD data
// and render to the summary table
    $.ajax({
        url: "dvds"
    }).success(function (data, status) {
        fillDvdTable(data, status);
        fillHomeTable(data, status);
    });
}

function fillDvdTable(data, status) {
        clearDVDTable();
    var cTable = $('#contentRows');
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
                                        'onClick': 'deleteDvd(' + dvd.id + ')'
                                    })
                                    .text('Delete')
                                    ) // ends the <a> tag
                            ) // ends the <td> tag for Delete
                    );
    });
}

function fillHomeTable(data, status) {
        clearDVDTable();
    var cTable = $('#contentRows2');
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
//                    .append($('<td>')
//                            .append($('<a>')
//                                    .attr({
//                                        'data-DVD-id': dvd.id,
//                                        'data-toggle': 'modal',
//                                        'data-target': 'editModal'
//                                    })
//                                    .text('Edit')
//                                    ) // ends the <a> tag
//                            )
                    );
    });
}

$('#search-button').click(function (event) {
// we don’t want the button to actually submit
// we'll handle data submission via ajax
    event.preventDefault();
    $.ajax({
        type: 'POST',
        url: 'search/dvds',
        data: JSON.stringify({
            id: $('#search-id').val(),
            title: $('#search-title').val(),
            releaseDate: $('#search-release').val(),
            mpaaRating: $('#search-rating').val(),
            director: $('#search-director').val(),
            studio: $('#search-studio').val(),
            note: $('#search-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {data: JSON.stringify
        $('#search-title').val(''),
        $('#search-release').val(''),
        $('#search-rating').val(''),
        $('#search-director').val('');
        $('#search-studio').val('');
        $('#search-note').val('');
        fillDvdTable(data, status);
        searchMovies();
    });
});

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
    $('#contentRows2').empty();
}

function clearTotal() {
    $('#totalRows').empty();
}

function clearSTotal() {
    $('#searchRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
// Get the element that triggered this event - in our case it is a DVD
// name link in the summary table. This link has an attribute that contains
// the DVDId for the given DVD. We'll use that to retrieve the
// DVD's details.
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
// make an ajax call to get address information for given address id
// this is a GET request to address/{id}
// upon success, put the returned JSON data into the modal dialog
    $.ajax({
        type: 'GET',
        url: 'dvdi/' + dvdId
    }).success(function (dvd) {
        modal.find('#add-id').text(dvd.id);
        modal.find('#add-title').text(dvd.title);
        modal.find('#add-release').text(dvd.releaseDate);
        modal.find('#add-rating').text(dvd.mpaaRating);
        modal.find('#add-director').text(dvd.director);
        modal.find('#add-studio').text(dvd.studio);
        modal.find('#add-note').text(dvd.note);
    });
});
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.id);
        modal.find('#edit-DVD-id').val(dvd.id);
        modal.find('#edit-title').val(dvd.title);
        modal.find('#edit-release').val(dvd.releaseDate);
        modal.find('#edit-rating').val(dvd.mpaaRating);
        modal.find('#edit-director').val(dvd.director);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-note').val(dvd.note);
    });
});
$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'dvd/' + $('#edit-DVD-id').val(),
        data: JSON.stringify({
            id: $('#edit-DVD-id').val(),
            title: $('#edit-title').val(),
            releaseDate: $('#edit-release').val(),
            mpaaRating: $('#edit-rating').val(),
            director: $('#edit-director').val(),
            studio: $('#edit-studio').val(),
            note: $('#edit-note').val()
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
