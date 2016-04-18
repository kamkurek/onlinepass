$(document).ready(function(){
    // var table = $('#myTable').DataTable({
    //     paging: false,
    //     ordering: false
    // });
    //
    // table.on( 'order.dt search.dt', function () {
    //     table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
    //         cell.innerHTML = i+1;
    //     } );
    // } ).draw();
    
    var clipboard = new Clipboard('#copyPassword');
    clipboard.on('success', function(e) {
        e.clearSelection();
    });
});

function showPassword(title, url, password) {
    $('#modalHeader').text(title);
    $('#modalPassword').val(password);
    $('#modalUrl').val(url);
    $('#myModal').modal();
}