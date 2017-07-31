(function () {
    angular.module(APP_NAME).controller('ProfessionCtrl', ['$professionService', ProfessionCtrl]);

    function ProfessionCtrl($professionService) {
        var ctrl = this;
        ctrl.professions = [];

        loadProfessionList();

        function loadProfessionList() {
            return $professionService.professionList().then(function (list) {
                ctrl.professions = list;
            })
        }
    }
}());