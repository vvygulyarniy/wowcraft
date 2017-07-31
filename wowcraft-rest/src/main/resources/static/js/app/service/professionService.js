(function () {
    angular.module(APP_NAME).service('$professionService', ['$http', $professionService]);

    function $professionService($http) {
        return {
            professionList: professionList,
            professionInfo: professionInfo,
            recipeList: recipeList,
            allReagentList: allReagentsList,
            saveReagent: saveReagent,
            updateReagent: updateReagent
        };


        function professionList() {
            return $http.get('rest/professions').then(function (response) {
                console.log('got response');
                console.info(response.data);
                return response.data;
            });
        }

        function professionInfo(professionId) {
            return $http.get('rest/professions/' + professionId).then(function (response) {
                return response.data;
            })
        }

        function recipeList(professionId) {
            return $http.get('rest/professions/' + encodeURIComponent(professionId) + '/recipes')
                .then(function (response) {
                    return response.data;
                });
        }

        function allReagentsList() {
            return $http.get('rest/reagents')
                .then(function (response) {
                    return response.data;
                });
        }

        function saveReagent(professionId, reagentName, price) {
            var newReagent = {
                name : reagentName,
                profession: {
                    id : professionId
                },
                price : price
            };

            return $http.put('rest/reagents', newReagent);
        }

        function updateReagent(reagent) {
            return $http.put('rest/reagents/' + reagent.id, reagent);
        }
    }
}());