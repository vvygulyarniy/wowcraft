(function () {
    angular.module(APP_NAME).controller('ReagentsCtrl', ['$professionService', ReagentsCtrl]);

    function ReagentsCtrl($professionService) {
        var ctrl = this;
        ctrl.reagents = [];
        ctrl.professions = [];
        ctrl.filter = {
            name: ''
        };
        ctrl.addInProgress = false;

        ctrl.addForm = {
            profession: '',
            name: '',
            price: 0.0
        };

        ctrl.editInProgress = false;

        ctrl.editForm = {
            id: 0,
            name: '',
            price: 0.0,
            editedEntity: null
        };

        ctrl.startAdding = startAdding;
        ctrl.addNewReagent = addNewReagent;

        ctrl.startEditing = startEditing;
        ctrl.updateReagent = updateReagent;

        loadReagentList().then(loadProfessions).then(emptyAddForm);

        function loadReagentList() {
            return $professionService.allReagentList().then(function (list) {
                ctrl.reagents = list;
            })
        }

        function loadProfessions() {
            $professionService.professionList().then(function (professions) {
                ctrl.professions = professions;
                return professions;
            })
        }

        function startAdding() {
            ctrl.addInProgress = true;
        }

        function finishAdding() {
            ctrl.addInProgress = false;
        }

        function addNewReagent() {
            $professionService.saveReagent(ctrl.addForm.profession, ctrl.addForm.name, ctrl.addForm.price)
                .then(finishAdding)
                .then(emptyAddForm)
                .then(loadReagentList);
        }

        function startEditing(id) {
            console.log('editing ' + id);
            var reagentToEdit;
            for (var i = 0; i < ctrl.reagents.length; i++) {
                if (ctrl.reagents[i].id === id) {
                    reagentToEdit = ctrl.reagents[i];
                }
            }

            if (reagentToEdit !== undefined) {
                console.log('reagent found: ' + reagentToEdit.id);
                ctrl.editForm = {
                    id: reagentToEdit.id,
                    name: reagentToEdit.name,
                    price: reagentToEdit.price,
                    editedEntity: reagentToEdit
                };

                ctrl.editInProgress = true;
            }
        }

        function stopEditing() {
            ctrl.editInProgress = false;
        }

        function updateReagent() {
            ctrl.editForm.editedEntity.price = ctrl.editForm.price.replace(/,/,".");
            $professionService.updateReagent(ctrl.editForm.editedEntity).then(stopEditing).then(loadReagentList);
        }

        function emptyAddForm() {
            ctrl.addForm = {
                profession: '',
                name: '',
                price: 0.0
            };
        }
    }
}());