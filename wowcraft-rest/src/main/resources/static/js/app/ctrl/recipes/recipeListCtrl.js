(function () {
    angular.module(APP_NAME).controller('RecipeListCtrl', ['$routeParams', '$professionService', '$uibModal', RecipeListCtrl]);

    function RecipeListCtrl($routeParams, $professionService, $modal) {
        var ctrl = this;
        ctrl.profession = {};
        ctrl.recipes = [];
        ctrl.addDialog = addDialog;

        loadProfessionInfo().then(loadRecipes);

        function loadProfessionInfo() {
            return $professionService.professionInfo($routeParams.professionId).then(function (info) {
                ctrl.profession = info;
            });
        }

        function loadRecipes() {
            return $professionService.recipeList($routeParams.professionId)
                .then(function (recipes) {
                    ctrl.recipes = recipes;
                })
        }

        function addDialog() {
            $modal.open({
                templateUrl: 'html/recipes/add.html',
                controller: 'AddRecipeCtrl',
                controllerAs: 'ctrl'
            }).result.then(loadRecipes);
        }
    }
}());