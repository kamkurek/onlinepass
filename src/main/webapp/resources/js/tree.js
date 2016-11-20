
$(document).ready(function() {
    Groups.fetch(function(groups){
        groups = JSON.stringify(groups);
        groups = groups.split('"name":').join('"text":');
        groups = groups.split('"groups":').join('"nodes":');

        $('#tree').treeview({
            data: groups,
            onNodeSelected: function(event, node) {
                Entries.fetchForGroup(node.uuid, appendTable);
            },
            onNodeUnselected: function () {
                setTimeout(function(){
                    var selected = $('#tree').treeview('getSelected');
                    if(selected.length == 0) {
                        Entries.fetch(appendTable);
                    }
                }, 0);
            }
        });
    });
});

