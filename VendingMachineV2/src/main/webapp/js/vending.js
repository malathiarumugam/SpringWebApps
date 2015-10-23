$(document).ready(function () {
    loadItems();
});
//    $('#add-button').click(function (event) {
//        event.preventDefault();
//        $.ajax({
//            type: 'POST',
//            url: 'dvd',
//            data: JSON.stringify({
//                title: $('#add-title').val(),
//                releaseDate: $('#add-release').val(),
//                mpaaRating: $('#add-rating').val(),
//                director: $('#add-director').val(),
//                studio: $('#add-studio').val(),
//                note: $('#add-note').val()
//            }),
//            headers: {
//                'Accept': 'application/json',
//                'Content-Type': 'application/json'
//            },
//            'dataType': 'json'
//        }).success(function (data, status) {
//            $('#add-title').val('');
//            $('#add-release').val('');
//            $('#add-rating').val('');
//            $('#add-director').val('');
//            $('#add-studio').val('');
//            $('#add-note').val('');
//            loadDVDs();
////return false;
//        });
//    });



//==========
// FUNCTIONS
//==========


function loadItems() {
    clearTable();
    var cTable = $('#contentRows');
//    $.ajax({
//        url: "dvds"
//    }).success(function (data, status) {
        $.each(vendingData, function (index, item) {
            cTable.append($('<tr>')
                    .append($('<td>')
//                            .append($('<a>')
//                                    .attr({
//                                        'data-DVD-id': dvd.id,
//                                        'data-toggle': 'modal',
//                                        'data-target': '#detailsModal'
//                                    })
                                    .text(item.name)
//                                    ) // ends the <a> tag
                            )
                    .append($('<td>').text(item.count))
                    .append($('<td>').text('$'+item.cost))
                    .append($('<td>').text(item.code))
//                    .append($('<td>')
//                            .append($('<a>')
//                                    .attr({
//                                        'data-DVD-id': dvd.id,
//                                        'data-toggle': 'modal',
//                                        'data-target': '#editModal'
//                                    })
//                                    .text('Edit')
//                                    ) // ends the <a> tag
//                            )
                    );
        });
//    });
}

//function deleteDvd(id) {
//    var answer = confirm("Do you really want to delete this movie?");
//    if (answer === true) {
//        $.ajax({
//            type: 'DELETE',
//            url: 'dvd/' + id
//        }).success(function () {
//            loadDVDs();
//        });
//    }
//}

function clearTable() {
    $('#contentRows').empty();
}

//$('#detailsModal').on('show.bs.modal', function (event) {
//    var element = $(event.relatedTarget);
//    var dvdId = element.data('dvd-id');
//    var modal = $(this);
//    $.ajax({
//        type: 'GET',
//        url: 'dvd/' + dvdId
//    }).success(function (dvd) {
//        modal.find('#add-id').text(dvd.id);
//        modal.find('#add-title').text(dvd.title);
//        modal.find('#add-release').text(dvd.releaseDate);
//        modal.find('#add-rating').text(dvd.mpaaRating);
//        modal.find('#add-director').text(dvd.director);
//        modal.find('#add-studio').text(dvd.studio);
//        modal.find('#add-note').text(dvd.note);
//    });
//});

//$('#editModal').on('show.bs.modal', function (event) {
//    var element = $(event.relatedTarget);
//    var dvdId = element.data('dvd-id');
//    var modal = $(this);
//    $.ajax({
//        type: 'GET',
//        url: 'dvd/' + dvdId
//    }).success(function (dvd) {
//        modal.find('#dvd-id').text(dvd.id);
//        modal.find('#edit-DVD-id').val(dvd.id);
//        modal.find('#edit-title').val(dvd.title);
//        modal.find('#edit-release').val(dvd.releaseDate);
//        modal.find('#edit-rating').val(dvd.mpaaRating);
//        modal.find('#edit-director').val(dvd.director);
//        modal.find('#edit-studio').val(dvd.studio);
//        modal.find('#edit-note').val(dvd.note);
//    });
//});

//$('#edit-button').click(function (event) {
//// prevent the button press from submitting the whole page
//    event.preventDefault();
//    $.ajax({
//        type: 'PUT',
//        url: 'dvd/' + $('#edit-DVD-id').val(),
//        data: JSON.stringify({
//            id: $('#edit-DVD-id').val(),
//            title: $('#edit-title').val(),
//            releaseDate: $('#edit-release').val(),
//            mpaaRating: $('#edit-rating').val(),
//            director: $('#edit-director').val(),
//            studio: $('#edit-studio').val(),
//            note: $('#edit-note').val()
//        }),
//        headers: {
//            'Accept': 'application/json',
//            'Content-Type': 'application/json'
//        },
//        'dataType': 'json'
//    }).success(function () {
//        loadDVDs();
//    });
//});

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
var vendingData = [
    {
        code: "A1",
        name: "Big Red",
        count: 10,
        cost: "0.50"},
    {
        code: "A2",
        name: "Juicy Fruit",
        count: 10,
        cost: "0.50"},
    {
        code: "A3",
        name: "Spearmint Gum",
        count: 10,
        cost: "0.50"},
    {
        code: "B1",
        name: "Snickers",
        count: 10,
        cost: "1.10"},
    {
        code: "B2",
        name: "Reese's Sticks",
        count: 10,
        cost: "1.00"},
    {
        code: "B3",
        name: "Three Muskateers",
        count: 10,
        cost: "1.10"}
];



