$(document).ready(function(){
    var clipboardPassword = new Clipboard('#copyPassword');
    clipboardPassword.on('success', function(e) {
        e.clearSelection();
    });

    var clipboardLogin = new Clipboard('#copyLogin');
    clipboardLogin.on('success', function(e) {
        e.clearSelection();
    });
});

function showPassword(title, url, login, password, uuid) {
    $('#myModal :input').each(function() {
        $(this).prop('readOnly', true);
    });
    $('#modalEditButton').removeClass('hidden');
    $('#modalSaveButton').addClass('hidden');

    $('#modalHeader').text(title);
    $('#modalPassword').val(password);
    $('#modalUrl').val(url);
    $('#modalTitle').val(title);
    $('#modalLogin').val(login);
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
