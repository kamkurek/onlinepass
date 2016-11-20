$(document).ready(function(){
    var clipboardPassword = new Clipboard('#copyPassword');
    clipboardPassword.on('success', function(e) {
        e.clearSelection();
    });

    var clipboardLogin = new Clipboard('#copyLogin');
    clipboardLogin.on('success', function(e) {
        e.clearSelection();
    });

    Entries.fetch(appendTable);
});

function showPassword(uuid) {
    $('#myModal :input').each(function() {
        $(this).prop('readOnly', true);
    });
    $('#modalEditButton').removeClass('hidden');
    $('#modalSaveButton').addClass('hidden');

    Entries.fetch(function(entry){
        $('#modalHeader').text(entry.title);
        $('#modalPassword').val(entry.password);
        $('#modalUrl').val(entry.url);
        $('#modalTitle').val(entry.title);
        $('#modalLogin').val(entry.username);
    }, '/'+uuid);

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

function appendTable(entries) {
    $('#myTable').empty();
    $.each(entries, function(i, entry) {
        $('<tr>').append(
            $('<td>').text(i+1),
            $('<td>').text(entry.title),
            $('<td>').text(entry.url),
            $('<td>').text(entry.username),
            $('<td>').append($('<div />', {
                'class' : 'btn btn-primary',
                'html'  : 'Show',
                'click' : function() {
                    showPassword(entry.uuid)
                }
            })                    )
        ).appendTo('#myTable');
    });
}

