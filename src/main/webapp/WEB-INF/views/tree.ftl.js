
function getTree() {
    var data = '${groups}';
    return data;
}

$(document).ready(function() {
    $('#tree').treeview({
        data: getTree(),
        onNodeSelected: function(event, node) {
            loadTable(node.uuid);
        },
        onNodeUnselected: function () {
            loadTable();
        }
    });
});

