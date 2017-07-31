(function(){
    angular.module(APP_NAME).config(['$routeProvider', '$locationProvider', routeConfig]);

    function routeConfig($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider.when('/', {
            templateUrl: '/html/professions/professions.html'
        }).when('/recipes/:professionId', {
            templateUrl : '/html/recipes/list.html'
        }).when('/reagents', {
            templateUrl : '/html/reagents/reagents.html'
        });
    }
}());