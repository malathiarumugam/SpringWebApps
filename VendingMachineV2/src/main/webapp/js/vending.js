$(document).ready(function () {
    loadItems();
    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'item',
            data: JSON.stringify({
                name: $('#add-name').val(),
                cost: $('#add-cost').val(),
                code: $('#add-code').val(),
                count: $('#add-count').val()
            }),
            contentType: 'application/json; charset=utf-8',
//            headers: {
//                'Accept': 'application/json',
//                'Content-Type': 'application/json'
//            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#add-name').val('');
            $('#add-cost').val('');
            $('#add-code').val('');
            $('#add-count').val('');
            loadItems();
            $('#validationErrors').empty();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            alert('wrong stuff');
//            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
//                var errorDiv = $('#validationErrors');
//                errorDiv.append(validationError.message).append($('<br>'));
//            });
        });

    });

});

$('#vend-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'item/vend',
        data: JSON.stringify({
            code: $('#vend-code').val(),
            money: $('#vend-money').val()
        }),
        contentType: 'application/json; charset=utf-8',
//        headers: {
//            'Accept': 'application/json',
//            'Content-Type': 'application/json'
//        },
        dataType: 'json'
    }).success(function (data, status) {
//        alert('yay');
            if (data < 0) {
                alert('Insufficient funds');
            } else {
                alert('Purchase Successful');
            }
//        data: JSON.stringify(
        $('#vend-code').val('');
        $('#vend-money').val('');
        loadItems();
        var cTable = $('#moneyRows');
        cTable.append($('<tr>')
                    .append($('<td>').text(data)
                    )
            )
            
    });
});

function loadItems() {
    $.ajax({
        url: "items"
    }).success(function (data, status) {
        fillEditItems(data, status);
        fillItems(data, status);
    });
}


function fillItems(data, status) {
    clearTable();
    var cTable = $('#contentRows');
        $.each(data, function (index, item) {
            cTable.append($('<tr>')
                    .append($('<td>').text(item.name))
                    .append($('<td>').text(item.count))
                    .append($('<td>').text('$'+item.cost))
                    .append($('<td>').text(item.code))
                    );
        });
}

function fillEditItems(data, status) {
    clearTable();
    var cTable = $('#editRows');
        $.each(data, function (index, item) {
            cTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'data-code': item.code,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    })
                                    .text(item.name)
                                    ) // ends the <a> tag
                            )
                    .append($('<td>').text(item.count))
                    .append($('<td>').text('$'+item.cost))
                    .append($('<td>').text(item.code))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteItem(' + item.code + ')'
                                    })
                                    .text('Delete')
                                    ) // ends the <a> tag
                            ) 
                    );
        });
}

function deleteItem(code) {
    var answer = confirm("Do you really want to delete this movie?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'item/' + code
        }).success(function () {
            loadItems();
        });
    }
}

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

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var itemCode = element.data('item-code');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'item/' + itemCode
    }).success(function (item) {
        modal.find('#item-code').text(item.code);
        modal.find('#edit-Item-code').val(item.code);
        modal.find('#edit-name').val(item.name);
        modal.find('#edit-cost').val(item.cost);
        modal.find('#edit-count').val(item.count);
    });
});

$('#edit-button').click(function (event) {
// prevent the button press from submitting the whole page
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'item/' + $('#edit-item-code').val(),
        data: JSON.stringify({
            code: $('#edit-Item-code').val(),
            name: $('#edit-name').val(),
            cost: $('#edit-cost').val(),
            count: $('#edit-count').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function () {
        loadItems();
    });
});


// TEST DATA
//var vendingData = [
//    {
//        code: "A1",
//        name: "Big Red",
//        count: 10,
//        cost: "0.50"},
//    {
//        code: "A2",
//        name: "Juicy Fruit",
//        count: 10,
//        cost: "0.50"},
//    {
//        code: "A3",
//        name: "Spearmint Gum",
//        count: 10,
//        cost: "0.50"},
//    {
//        code: "B1",
//        name: "Snickers",
//        count: 10,
//        cost: "1.10"},
//    {
//        code: "B2",
//        name: "Reese's Sticks",
//        count: 10,
//        cost: "1.00"},
//    {
//        code: "B3",
//        name: "Three Muskateers",
//        count: 10,
//        cost: "1.10"}
//];



