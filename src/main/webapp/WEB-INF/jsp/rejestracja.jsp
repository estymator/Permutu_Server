<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/styles/style.css">
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>



<body>

<div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

	<form class="form-signin" id="registerForm">
		<h1 class="form-signin-heading text-muted">Rejestracja</h1>
		<input type="text" name="login" class="form-control" placeholder="Login" required="" autofocus=""> </br></br>
        <input type="password" name="password" class="form-control" placeholder="Hasło" required="">
        <input type="password" name="passwordRepeat" class="form-control" placeholder="Powtórz hasło" required=""></br></br>
        <input type="text" name="email" class="form-control" placeholder="Email" required="" autofocus=""></br></br></br>
        
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Rejestracja
        </button>
 
	</form>

</div>

<script>
   
    $("#registerForm").on("submit", function(event) {
        
       event.preventDefault();
       var login=$(this).find("[name=login]").val();
       var password=$(this).find("[name=password]").val();
       var passwordRepeat=$(this).find("[name=passwordRepeat]").val();
       var email=$(this).find("[name=email]").val();
       var userRoleID=1;



      
        //POST request
        $.post('http://localhost:8081/register', { "login": login,
                                                    "password": password,
                                                    "email": email,
                                                    "userRoleID": userRoleID,
                                                    },
        function(returnedData){
            console.log(returnedData);
            if(returnedData.login==login)
            {
                window.location='/login'
            }
        }).error(function(XHR, status, error){
            console.log(XHR.responseJSON.message);
            $(".container").append(XHR.responseJSON.message)

        });


       // process form
    });

</script>

</body>
</html>

