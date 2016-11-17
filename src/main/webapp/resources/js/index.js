$(document).ready(function(){
    var clipboardPassword = new Clipboard('#copyPassword');
    clipboardPassword.on('success', function(e) {
        e.clearSelection();
    });

    var clipboardLogin = new Clipboard('#copyLogin');
    clipboardLogin.on('success', function(e) {
        e.clearSelection();
    });

    loadTable();
});

function showPassword(uuid) {
    $('#myModal :input').each(function() {
        $(this).prop('readOnly', true);
    });
    $('#modalEditButton').removeClass('hidden');
    $('#modalSaveButton').addClass('hidden');


    $.get('/onlinepass/data/details/'+uuid, function(entry) {
        $('#modalHeader').text(entry.title);
        $('#modalPassword').val(entry.password);
        $('#modalUrl').val(entry.url);
        $('#modalTitle').val(entry.title);
        $('#modalLogin').val(entry.username);
    });


    $('#modalUuid').val(uuid);
    $('#myModal').modal();
}

function enableEdit() {
    $('#myModal :input').each(function() {
        $(this).prop('readOnly', false);
    });
    $('#modalEditButton').toggleClass('hidden');
    $('#modalSaveButton').toggleClass('hidden');
}

function loadTable(groupUuid) {
    $('#myTable').empty();
    var url = '/onlinepass/data';
    if(groupUuid) {
        url+='/'+groupUuid;
    }
    $.get(url, function(data){
            $.each(data, function(i, item) {
                $('<tr>').append(
                    $('<td>').text(i+1),
                    $('<td>').text(item.title),
                    $('<td>').text(item.url),
                    $('<td>').text(item.username),
                    $('<td>').append($('<div />', {
                        'class' : 'btn btn-primary',
                        'html'  : 'Show',
                        'click' : function() {
                            showPassword(item.uuid)
                        }
                    })                    )
                ).appendTo('#myTable');
            });
        }
    );
}


