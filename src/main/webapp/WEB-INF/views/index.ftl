<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head-defaults.ftl"/>
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/index.css'/>"/>
    <script src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    <script src="<@spring.url '/resources/js/clipboard.min.js'/>"></script>
    <script src="<@spring.url '/resources/js/index.js'/>"></script>
</head>
<body>

<nav class="navbar navbar-inverse" style="border-radius:0px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">Onlinepass</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="<@spring.url '/access?logout'/>">
                    <span class="glyphicon glyphicon-log-out"/> Logout
                </a>
            </li>
        </ul>
    </div>
</nav>

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
                                '${entry.getPassword()}'
                                )">Show
                        </div>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>
<#include "modal.ftl">
</body>
</html>