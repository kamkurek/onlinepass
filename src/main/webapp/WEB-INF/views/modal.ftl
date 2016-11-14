<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="modalHeader">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form id="modalForm" class="form-horizontal" method="post">
                    <div class="row form-group">
                        <label for="modalTitle" class="control-label col-sm-2">Title:</label>
                        <div class="col-sm-9 input-group">
                            <input type="text" id="modalTitle" class="form-control" name="title" readonly>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="modalUrl" class="control-label col-sm-2">Url:</label>
                        <div class="col-sm-9 input-group">
                            <input type="text" id="modalUrl" class="form-control" name="url" readonly>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="modalLogin" class="control-label col-sm-2">Login:</label>
                        <div class="col-sm-9 input-group">
                            <input type="text" id="modalLogin" class="form-control" name="login" readonly>
                            <span class="input-group-addon btn" data-clipboard-target="#modalLogin" id="copyLogin"><i class="glyphicon glyphicon-copy"></i></span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label for="modalPassword" class="control-label col-sm-2">Password:</label>
                        <div class="col-sm-9 input-group">
                            <input type="text" id="modalPassword" class="form-control" name="password" readonly>
                            <span class="input-group-addon btn" data-clipboard-target="#modalPassword" id="copyPassword"><i class="glyphicon glyphicon-copy"></i></span>
                        </div>
                    </div>
                    <input type="hidden" name="uuid" id="modalUuid"/>
                </form>
            </div>
            <div class="modal-footer">
                <button id="modalEditButton" type="button" class="btn btn-primary" onclick="enableEdit()">Edit</button>
                <button id="modalSaveButton" type="submit" class="btn btn-primary hidden" form="modalForm">
                    Save
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>