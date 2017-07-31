(function () {
    angular.module(APP_NAME).service('$reagentService', ['$http', '$requestHandler', $reagentService]);

    function $reagentService($http, $requestHandler) {
        return {
            reagentList: reagentList,
        };

        function reagentList() {
            return $http.get('rest/reagents').then($requestHandler.parseResponse);
        }
    }
}());