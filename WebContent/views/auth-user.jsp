<div class="auth-form-div">
	<form>
		<label class="lbl">Username:</label> <input type="text" id="username"
			name="username" class="form-control" placeholder="Username *">
		<label class="lbl">Password:</label> <input type="password"
			id="password" name="password" class="form-control"
			placeholder="Password *" style="margin-bottom: 10px;"> <input
			type="hidden" id="authType" name="authType">
		<p class="cp auth-error" style="color: red;"></p>
		<a href="#" class="auth-user" va="1" style="text-decoration: none;" ng-click="authType();">Create
			a new account?</a>
		<button id="authBtn" type="submit" class="btn btn-default lfb" style="width: 75px;" ng-click="signIn();">Sign
			in</button>
	</form>
</div>