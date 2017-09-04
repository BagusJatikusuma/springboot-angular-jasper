'use strict';

angular.module('crudApp').controller('EmployeeController',
	['EmployeeService', '$scope', function(EmployeeService, $scope) {
		
		var self = this;
		self.employee = {};
		self.employees = [];

		self.jabatan = {};
		self.jabatans = [];

		self.submit = submit;
        self.getAllEmployees = getAllEmployees;
        self.createEmployee = createEmployee;
        self.updateEmployee = updateEmployee;
        self.removeEmployee = removeEmployee;
        self.editEmployee = editEmployee;
        self.createReport = createReport;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        getAllJabatan();

        function submit() {
        	console.log('submitting');

        	if (self.employee.id === undefined || self.employee.id === null) {
        		console.log('Saving New employee', self.employee);
                createEmployee(self.employee);

        	} else {
        		updateEmployee(self.employee, self.employee.id);
                console.log('employee updated with id ', self.employee.id);
        	}

        }

        function createEmployee(employee) {
        	console.log('About to create employee');
        	EmployeeService.createEmployee(employee)
        		.then(
        			function (response) {
        				console.log('Employee created successfully');

                        self.successMessage = 'employee created successfully';
                        self.errorMessage = '';
                        self.done = true;
                        self.employee = {};
                        
                        $scope.myForm.$setPristine();
        			},
        			function (errResponse) {
        				console.error('Error while creating Employee');

                        self.errorMessage = 'Error while creating employee: ' + errResponse.data.errorMessage;
                        self.successMessage = '';
        			}
        		);

        }

        function getAllJabatan() {
            debugger
            EmployeeService.getAllJabatan()
                .then(
                    function (response) {
                        self.jabatans = response;
                    },
                    function () {
                        console.log('Gagal');
                    }
                )
        }

        function updateEmployee(employee, id) {
        	console.log('About to update employee');
            EmployeeService.updateEmployee(employee, id)
                .then(
                    function (response){
                        console.log('Employee updated successfully');

                        self.successMessage = 'employee updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Employee');

                        self.errorMessage = 'Error while updating employee '+errResponse.data;
                        self.successMessage = '';
                    }
                );
        }

        function removeEmployee(id) {
        	console.log('About to remove Employee with id '+id);
            EmployeeService.removeEmployee(id)
                .then(
                    function(){
                        console.log('Employee '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing employee '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllEmployees() {
        	console.log('about get all employees controller');
        	return EmployeeService.getAllEmployees();
        }

        function editEmployee(id) {
        	self.successMessage='';
            self.errorMessage='';

            EmployeeService.getEmployee(id)
            	.then(
	                function (employee) {
	                    self.employee = employee;
	                },
	                function (errResponse) {
	                    console.error('Error while removing employee ' + id + ', Error :' + errResponse.data);
	                }
	            );
        }	

        function reset() {
        	self.successMessage = '';
            self.errorMessage = '';
            self.employee = {};

            $scope.myForm.$setPristine(); //reset Form
        }

        function getAllJabatans() {
        	console.log('about get all jabatans controller');
        	return EmployeeService.getAllJabatans();
        }
        
        function createReport() {
            console.log('about create report controller');
            EmployeeService.createReport();
        }

	}

	]);
