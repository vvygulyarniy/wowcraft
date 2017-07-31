(function () {
    angular.module(APP_NAME).service('$recipeService', ['$http', '$requestHandler', $recipeService]);

    function $recipeService($http, $requestHandler) {
        return {
            allRecipes: allRecipes,
            addRecipe: addRecipe
        };

        function allRecipes() {
            return $http.get('rest/recipes').then($requestHandler.parseResponse);
        }

        function addRecipe(professionId, name, reagents) {
            return $http.put('rest/recipes', {
                professionId: professionId,
                name: name,
                reagents: reagents
            }).then($requestHandler.parseResponse);
        }
    }
}());