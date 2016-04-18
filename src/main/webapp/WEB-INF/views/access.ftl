<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head-defaults.ftl"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/access.css'/>"/>
</head>
<body>

<div class="container">
    <div id="box" class="mainbox col-md-6 col-md-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title text-center"><b>Onlinepass</b></div>
            </div>
            <div class="panel-body" >
                <form class="form-horizontal" name="f" action="login" method="post">

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" id="login" name="login" class="form-control" placeholder="Login">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <div class="col-sm-12 controls">
                            <button type="submit" class="btn btn-primary pull-right"><i class="glyphicon glyphicon-log-in"></i> Log in</button>
                        </div>
                    </div>

                    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>