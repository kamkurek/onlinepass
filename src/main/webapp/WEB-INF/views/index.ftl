<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head-defaults.ftl"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/jquery-datatables.min.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/bootstrap-treeview.min.css'/>"/>
    <script src="<@spring.url '/resources/js/jquery-datatables.min.js'/>"></script>
    <script src="<@spring.url '/resources/js/clipboard.min.js'/>"></script>
    <script src="<@spring.url '/resources/js/bootstrap-treeview.min.js'/>"></script>
    <script src="<@spring.url '/resources/js/model.js'/>"></script>
    <script src="<@spring.url '/resources/js/index.js'/>"></script>
    <script src="<@spring.url '/resources/js/tree.js'/>"></script>
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