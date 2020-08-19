<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/resources/styles/style.css">

    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>
<body>
    <div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

	<form class="form-signin" id="loginForm">
		<h1 class="form-signin-heading text-muted">Logowanie</h1>
		<input type="text" name="login" class="form-control" placeholder="Login" required="" autofocus="">
        <input type="password" name="password" class="form-control" placeholder="Hasło" required="">
        <label class="checkbox">
            <input type="checkbox" name="remember" value="1"> Zapamiętaj mnie
        </label>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Zaloguj
        </button>
 
	</form>

</div>

<script>

    $("#loginForm").on("submit", function(event) {

       event.preventDefault();
       var login=$(this).find("[name=login]").val();
       var password=$(this).find("[name=password]").val();




        //POST request
        $.post('http://localhost:8081/login', { "login": login,
                                                    "password": password,
                                                    },
        function(returnedData){
            console.log(returnedData);
        }).fail(function(){
            console.log("error");
        });


       // process form
    });

</script>


</body>
</html>
