'use strict';

angular.module('crudApp').factory('EmployeeService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllEmployees: loadAllEmployees,
                getAllEmployees: getAllEmployees,
                getEmployee: getEmployee,
                createEmployee: createEmployee,
                updateEmployee: updateEmployee,
                removeEmployee: removeEmployee
            };

            return factory;

            function loadAllEmployees() {
                console.log('Fetching all employees now');
                var deferred = $q.defer();

                $http.get(urls.EMPLOYEE_SERVICE_API + 'get-employees')
                    .then(
                        function (response) {
                            console.log('Fetched successfully all employees');

                            $localStorage.employees = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading employees');

                            deferred.reject(errResponse);
                        }
                    );

                return deferred.promise;
                
            }

            function getAllEmployees(){
                return $localStorage.employees;
            }

            function getEmployee(id) {
                console.log('Fetching Employee with id :'+id);
                var deferred = $q.defer();

                $http.get(urls.EMPLOYEE_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Employee with id :'+id);

                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Employee with id :'+id);

                            deferred.reject(errResponse);
                        }
                    );
                
                return deferred.promise;

            }

            function createEmployee(employee) {
                console.log('Creating Employee');
                var deferred = $q.defer();
                
                $http.post(urls.EMPLOYEE_SERVICE_API + 'create', employee)
                    .then(
                        function (response) {
                            loadAllEmployees();

                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Employee : '+errResponse.data.errorMessage);

                           deferred.reject(errResponse);
                        }
                    );
                
                return deferred.promise;

            }

            function updateEmployee(employee, id) {
                console.log('Updating employee with id '+id);
                var deferred = $q.defer();
                
                $http.put(urls.EMPLOYEE_SERVICE_API + 'update', employee)
                    .then(
                        function (response) {
                            loadAllEmployees();

                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Employee with id :'+id);

                            deferred.reject(errResponse);
                        }
                    );
                
                return deferred.promise;

            }

            function removeEmployee(id) {
                console.log('Removing Employee with id '+id);
                var deferred = $q.defer();
                
                $http.delete(urls.EMPLOYEE_SERVICE_API + 'delete/'+ id)
                    .then(
                        function (response) {
                            loadAllEmployees();

                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Employee with id :'+id);

                            deferred.reject(errResponse);
                        }
                    );

                return deferred.promise;   
            }

            function loadAllJabatans() {
                console.log('Fetching all jabatans');
                var deferred = $q.defer();

                $http.get(urls.JABATAN_SERVICE_API + 'get-jabatans')
                    .then(
                        function (response) {
                            console.log('Fetched successfully all jabatans');

                            $localStorage.jabatans = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading jabatans');

                            deferred.reject(errResponse);
                        }
                    );

                return deferred.promise;
            }

            function getAllJabatans(){
                return $localStorage.jabatans;
            }

        }
    ]);