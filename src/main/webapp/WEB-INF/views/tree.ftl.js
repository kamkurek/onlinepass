var currentUuid;

function getTree() {
    var data = '${groups}';
    return data;
}

function nodeSelected(node) {
    console.log(node);
}

function filterViewToGroup(node) {
    window.location.href = '/onlinepass?groupUUID='+node.uuid;
}
document.addEventListener('DOMContentLoaded', function() {
    $('#tree').treeview({
        data: getTree(),
        onNodeSelected: function(event, node) {
            currentUuid = node.uuid;
            filterViewToGroup(node);
        }
    });
}, false);

