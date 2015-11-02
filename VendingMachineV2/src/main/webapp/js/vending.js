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
            'dataType': 'json'
        }).success(function (data, status) {
                $('#add-name').val('');
                $('#add-cost').val('');
                $('#add-code').val('');
                $('#add-count').val('');
                loadItems();
            $('#validationErrors').empty();
        }).error(function (data, status) {
            if (status === 'parsererror') {
                $('#add-code').val('');
                alert('You cannot have two items with the same code.');
            } else {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
            }
        });

    });

});
var totalTwoDec = 0;

$('#change-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'item/change',
        data: JSON.stringify({
            total: totalTwoDec
        }),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).success(function (data, status) {
        $('#moneyRows').empty();
        $('#changeRows').empty();
        var aTable = $('#changeRows');
        aTable.append($('<tr>')
                .append($('<td>').text(data.response)
                        )
                )
        totalTwoDec = 0;
    }).error(function (data, status) {
        alert('error');
    });
});


$('#vend-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'item/vend',
        data: JSON.stringify({
            code: $('#vend-code').val(),
            money: $('#vend-money').val(),
            leftover: totalTwoDec
        }),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).success(function (data, status) {
        $('#moneyRows').empty();
        var cTable = $('#moneyRows');
        if (data < 0) {
            alert('Insufficient funds');
            totalTwoDec += Math.abs(data);
            cTable.append($('<tr>')
                    .append($('<td>').text("$" + totalTwoDec.toFixed(2))
                            )
                    )
        } else {
            alert('Purchase Successful');
            totalTwoDec = data;
            cTable.append($('<tr>')
                    .append($('<td>').text("$" + totalTwoDec.toFixed(2))
                            )
                    )
        }
        $('#vend-code').val('');
        $('#vend-money').val('');
        loadItems();
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
    $('#vend-code').empty();
    var sel = document.getElementById('vend-code');
    var fragment = document.createDocumentFragment();
    $.each(data, function (index, item) {
        if (item.count === 0) {

        } else {
            cTable.append($('<tr>')
                    .append($('<td>').text(item.name))
                    .append($('<td>').text(item.count))
                    .append($('<td>').text('$' + item.cost))
                    .append($('<td>').text(item.code))
                    );
            var opt = document.createElement('option');
            opt.innerHTML = item.code + '  ⇓';
            opt.value = item.code ;
            fragment.appendChild(opt);
            sel.appendChild(fragment);
        }
    });
    
}

function fillEditItems(data, status) {
    clearEditTable();
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
                .append($('<td>').text('$' + item.cost.toFixed(2)))
                .append($('<td>').text(item.code))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteItem(\"' + item.code + '\")'
                                })
                                .text('Delete')
                                ) // ends the <a> tag
                        )
                );
    });
}

function deleteItem(code) {
    var answer = confirm("Do you really want to delete this item?");
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

function clearEditTable() {
    $('#editRows').empty();
}

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var itemCode = element.data('code');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'item/' + itemCode
    }).success(function (item) {
        modal.find('#code').text(item.code);
        modal.find('#edit-Item-code').val(item.code);
        modal.find('#edit-name').val(item.name);
        modal.find('#edit-cost').val(item.cost);
        modal.find('#edit-count').val(item.count);
    });
});
$('#edit-button').click(function (event) {
    event.preventDefault();
    $.ajax({
        type: 'PUT',
        url: 'item/' + $('#edit-Item-code').val(),
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
        $('editModal').modal('hide');
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



