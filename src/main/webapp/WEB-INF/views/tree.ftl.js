var currentUuid;

function getTree() {
    var data = '${groups}';
    console.log('${groups}');
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
        }
    });
}, false);

