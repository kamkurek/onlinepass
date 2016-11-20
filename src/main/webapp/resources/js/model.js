function Model(url) {

    this.baseUrl = '/onlinepass';
    this.url = url;
    this.fullUrl = this.baseUrl+this.url;

    this.fetch = function(callback, id) {
        var url = this.fullUrl;
        if(typeof id !== 'undefined') { url += id; }
        $.get(url, function(data){
            callback(data);
        });
    };

}

var Entries = new Model('/entries');
Entries.fetchForGroup = function(groupId, callback) {
    this.fetch(callback, '?group='+groupId);
};

var Groups = new Model('/groups');