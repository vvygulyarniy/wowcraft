(function () {
    angular.module(APP_NAME).factory('$requestHandler', [$requestHandler]);

    function $requestHandler() {
        return {
            parseResponse : parseResponse
        };

        function parseResponse(response) {
            return response.data;
        }
    }
}());