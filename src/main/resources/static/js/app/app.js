var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    EMPLOYEE_SERVICE_API : 'http://localhost:8080/employee/',
    JABATAN_SERVICE_API : 'http://localhost:8080/jabatan/',
    DEPARTEMENT_SERVICE_API : 'http://localhost:8080/departement/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/employee_list',
                controller:'EmployeeController',
                controllerAs:'ctrl'
                // ,
                // resolve: {
                //     employees : function ($q, EmployeeService) {
                //         console.log('Load all employees');
                //         var deferred = $q.defer();
                //
                //         EmployeeService.loadAllEmployees()
                //             .then(deferred.resolve, deferred.resolve);
                //
                //         return deferred.promise;
                //     }
                    // ,
                    // jabatans : function ($q, EmployeeService) {
                    //     console.log('Load all employees');
                    //     var deferred = $q.defer();

                    //     EmployeeService.loadAllJabatans()
                    //         .then(deferred.resolve, deferred.resolve);
                        
                    //     return deferred.promise;
                    // }
                // }
            });
        $urlRouterProvider.otherwise('/');
    }]);