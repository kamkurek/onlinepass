<div class="table-responsive">
    <table id="myTable" class="table table-striped">
        <thead><tr><th>#</th><th>Title</th><th>Url</th><th>Login</th><th>Show</th></tr></thead>
        <tbody>
        <#list entries as entry>
        <tr>
            <td>${entry?counter}</td>
            <td>${entry.getTitle()}</td>
            <td>${entry.getUrl()}</td>
            <td>${entry.getUsername()}</td>
            <td>
                <div id="showPassword" class="btn btn-primary" onClick="showPassword(
                        '${entry.getTitle()}',
                        '${entry.getUrl()}',
                        '${entry.getUsername()}',
                        '${entry.getPassword()}',
                        '${entry.getUuid()}'
                        )">Show
                </div>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>