var currentUuid;

function getTree() {
    var data = '${groups}';
    return data;
}

function nodeSelected(node) {
    console.log(node);
}

document.addEventListener('DOMContentLoaded', function() {
    $('#tree').treeview({
        data: getTree(),
        onNodeSelected: function(event, node) {
            currentUuid = node.uuid;
            loadTable(node.uuid);
        }
    });
}, false);

