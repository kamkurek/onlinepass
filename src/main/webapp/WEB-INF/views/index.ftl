<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head-defaults.ftl"/>
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/bootstrap-treeview.min.css'/>"/>
    <script src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    <script src="<@spring.url '/resources/js/clipboard.min.js'/>"></script>
    <script src="<@spring.url '/resources/js/index.js'/>"></script>
    <script src="<@spring.url '/resources/js/bootstrap-treeview.min.js'/>"></script>
    <#--<script src="<@spring.url '/resources/js/tree.js'/>"></script>-->
    <script>
        <#include "tree.ftl.js">
    </script>
</head>
<body>
<#include "navbar.ftl">

<div class="container-fluid">
    <div class="col-md-3">
        <#include "tree.ftl">
    </div>
    <div class="col-md-9">
        <#include "table.ftl">
    </div>
</div>

<#include "modal.ftl">
</body>
</html>