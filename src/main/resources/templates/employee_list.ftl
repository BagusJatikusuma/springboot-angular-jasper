<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Employee </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.employee.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="birthday">Birth day</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.employee.birthday" id="birthday" class="form-control input-sm" placeholder="Enter your birthday"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="location">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.location" id="location" class="form-control input-sm" placeholder="Enter your Address"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="depatementId">Departement Id</label>
                            <div class="col-md-7">
                                <#--<select ng-model="ctrl.employee.departement">-->
                                    <#--<div ng-repeat="">-->
                                        <#--<option value="a">a</option>-->
                                    <#--</div>-->
                                <#--</select>-->
                                <input type="text" ng-model="ctrl.employee.departement" id="departement" class="form-control input-sm" placeholder="Enter your departement id"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="jabatanId">Jabatan Id</label>
                            <div class="col-md-7">
                                <#--<select ng-model="ctrl.employee.jabatan">-->
                                    <#--<div ng-repeat="jbtn in ctrl.jabatans">-->
                                        <#--<option value="{{jbtn.id}}">{{jbtn.name}}</option>-->
                                    <#--</div>-->
                                <#--</select>-->
                                <input type="text" ng-model="ctrl.employee.jabatan" id="jabatan" class="form-control input-sm" placeholder="Enter your jabatan id"/>
                            </div>
                        </div>
                    </div>
                    <#--<div class="row">-->
                        <#--<div class="form-group col-md-12">-->
                            <#--<label class="col-md-2 control-lable" for="age">Age</label>-->
                            <#--<div class="col-md-7">-->
                                <#--<input type="text" ng-model="ctrl.employee.age" id="age" class="form-control input-sm" placeholder="Enter your Age." required ng-pattern="ctrl.onlyIntegers"/>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="row">-->
                        <#--<div class="form-group col-md-12">-->
                            <#--<label class="col-md-2 control-lable" for="salary">Salary</label>-->
                            <#--<div class="col-md-7">-->
                                <#--<input type="text" ng-model="ctrl.employee.salary" id="salary" class="form-control input-sm" placeholder="Enter your Salary." required ng-pattern="ctrl.onlyNumbers"/>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.employee.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Employee </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BIRTH DAY</th>
                        <th>ADDRESS</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllEmployees()">
                        <td>{{u.id}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.birthday}}</td>
                        <td>{{u.location}}</td>
                        <td><button type="button" ng-click="ctrl.editEmployee(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeEmployee(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div>
        <button type="button" ng-click="ctrl.createReport()" class="btn btn-success">Create Report</button>
    </div>

    <#--<div class="panel panel-default">-->
        <#--<!-- Default panel contents &ndash;&gt;-->
        <#--<div class="panel-heading"><span class="lead">List of Jabatan </span></div>-->
        <#--<div class="panel-body">-->
            <#--<div class="table-responsive">-->
                <#--<table class="table table-hover">-->
                    <#--<thead>-->
                    <#--<tr>-->
                        <#--<th>ID</th>-->
                        <#--<th>NAME</th>-->
                    <#--</tr>-->
                    <#--</thead>-->
                    <#--<tbody>-->
                    <#--<tr ng-repeat="u in ctrl.getAllJabatans()">-->
                        <#--<td>{{u.id}}</td>-->
                        <#--<td>{{u.name}}</td>-->
                    <#--</tr>-->
                    <#--</tbody>-->
                <#--</table>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->

</div>