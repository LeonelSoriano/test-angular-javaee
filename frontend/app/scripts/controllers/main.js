'use strict';

/**
 * @ngdoc function
 * @name sampleLoginApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sampleLoginApp
 */
angular.module('sampleLoginApp')
  .controller('MainCtrl', [ '$scope', '$http', '$location' , function ($scope, $http, $location) {
    $scope.eml_add = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;

     $scope.isNotFountUser = false;

    $scope.onLogin = function() {

        if($scope.inquiryForm.$valid){

            $http.post("http://localhost:8080/TestJersey2/rest/login", {"email": $scope.inquiryForm.email, "password": $scope.inquiryForm.password}).
                success(function(data, status, headers, config) {
                    $location.path("/home")
                }).
            error(function(data, status, headers, config) {

                if(status === 404){
                    $scope.isNotFountUser = true;
                }

            });
        }
    };


  }]);
