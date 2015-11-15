/**
 * 
 */
var cms = angular.module('cms', [ 'ngRoute' ]);
var cmsUrl = '/contacts-management-system'

// configure for routing pages
cms.config(function($routeProvider, $locationProvider) {
	$routeProvider.

	// route for the member area
	when(cmsUrl + '/auth', {
		templateUrl : 'views/auth-user.jsp',
		controller : 'authCtrl'
	}).

	// route for the about us
	when(cmsUrl + '/about-us', {
		templateUrl : 'views/about-us.jsp',
		controller : 'aboutUsCtrl'
	}).

	// route for the contact us
	when(cmsUrl + '/contact-us', {
		templateUrl : 'views/contact-us.jsp',
		controller : 'contactUsCtrl'
	}).

	// route for the about us
	when(cmsUrl + '/dashboard', {
		templateUrl : 'views/dashboard.jsp',
		controller : 'dashboardCtrl'
	}).

	otherwise({
		redirectTo : cmsUrl
	});

	$locationProvider.html5Mode(true);
});

// Controllers definations

/** * Index Controller ** */
cms.controller('indexCtrl', function($scope, $http) {
	$scope.refresh = function() {
		window.location = '/cms';
	}
});

/** * Authentication & Authorization Controller ** */
cms.controller('authCtrl', function($scope, $http, $location) {
	/** ****************************************** */
	/** * Show div for signIn or signUp process ** */
	/** ****************************************** */
	$scope.authType = function() {
		var au = $('.auth-user');
		var aBtn = $('#authBtn');
		$('.auth-error').html('');
		if (au.attr('va') == '0') {
			au.attr('va', '1');
			aBtn.html('Sign in');
			au.css('margin', '0 33px 0 5px');
			au.html('Create a new account?');
			aBtn.attr('ng-click', 'signIn();');
		} else if (au.attr('va') == '1') {
			au.attr('va', '0');
			aBtn.html('Sign up');
			au.html('Already member?');
			au.css('margin', '0 72px 0 5px');
			aBtn.attr('ng-click', 'signUp();');

		} else {
			$('.auth-form-div').hide();
		}
	}

	/** ******************** */
	/** * Sign in process ** */
	/** ******************** */
	$scope.signIn = function() {
		$scope.username = $('#username').val();
		$scope.data = $scope.username + "," + $('#password').val();

		var signInMethod = $http.post('users/signIn', $scope.data);
		signInMethod.success(function(response) {
			if (response.charAt(0) != "0") {
				var htm = '<li class="nav-li"><a href="/cms/auth">'
						+ $scope.username + '</a></li>';
				localStorage.setItem("username", $scope.username);
				$location.path(cmsUrl + '/dashboard');
				var navbar = $('.navbar-cms').html('');
				navbar.html(htm);
			} else {
				console.log(response);
				$('.auth-error').html('Username or password is invalid!');
			}
		});
	}

	/** ******************** */
	/** * Sign up process ** */
	/** ******************** */
	$scope.signUp = function() {
		console.log('Sign up is coming soon . . .');
	}
});

cms.controller('aboutUsCtrl', function($scope) {
	$scope.msg = 'Laique Ali & Sharjeel Abbas';
});

cms.controller('contactUsCtrl', function($scope) {
	$scope.msg = 'Testing for contact us!';
});

cms.controller('dashboardCtrl', function($scope, $http) {
	$scope.msg = 'Welcome dear user ' + localStorage.getItem("username");
});