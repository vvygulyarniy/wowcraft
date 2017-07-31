(function () {
    angular.module(APP_NAME).controller('AddRecipeCtrl',
        ['$professionService', '$uibModalInstance', '$recipeService', '$reagentService', RecipeListCtrl]);

    function RecipeListCtrl($professionService, $modalInstance, $recipeService, $reagentService) {
        var ctrl = this;
        ctrl.allProfessions = [];
        ctrl.allReagents = [];
        ctrl.name = '';
        ctrl.profession = null;
        ctrl.reagents = [];

        ctrl.newReagent = {
            reagent: null,
            quantity: null
        };
        ctrl.canAddReagent = canAddReagent;
        ctrl.addReagent = addReagent;
        ctrl.dataIsValid = dataIsValid;
        ctrl.closeWindow = closeWindow;
        ctrl.save = save;

        loadProfessionInfo().then(loadAllReagents);

        function loadProfessionInfo() {
            return $professionService.professionList().then(function (info) {
                ctrl.allProfessions = info;
            });
        }

        function loadAllReagents() {
            return $reagentService.reagentList().then(function (reagents) {
                ctrl.allReagents = reagents;
            })
        }

        function canAddReagent() {
            return ctrl.newReagent.reagent != null
                && ctrl.newReagent.reagent.id > 0
                && ctrl.newReagent.quantity > 0;
        }

        function addReagent() {
            ctrl.reagents.push({
                id: ctrl.newReagent.reagent.id,
                name: ctrl.newReagent.reagent.name,
                quantity: ctrl.newReagent.quantity
            });

            ctrl.newReagent = {
                reagent: null,
                quantity: null
            };
        }

        function save() {
            if (dataIsValid()) {
                $recipeService.addRecipe(ctrl.profession, ctrl.name, ctrl.reagents).then(closeWindow);
            }
        }

        function closeWindow() {
            $modalInstance.close(true);
        }

        function dataIsValid() {
            return ctrl.name.length > 0
                && ctrl.profession > 0
                && ctrl.reagents.length > 0;
        }
    }
}());