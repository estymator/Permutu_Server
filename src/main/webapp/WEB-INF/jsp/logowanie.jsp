<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Permutu - logowanie </title>
    <link rel="stylesheet" type="text/css" href="/resources/styles/LoginPageStyle.css">

    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>

<div class="container">

    <form class="form-signin" id="loginForm" action="./login" method="post">
        <h1 class="form-signin-heading ">Logowanie</h1>
        <input type="text" name="login" class="form-control" placeholder="Login" required="" autofocus="">
        <input type="password" name="password" class="form-control" placeholder="Hasło" required="">
        <label class="checkbox">
            <input type="checkbox" name="remember" value="1"> Zapamiętaj mnie
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            Zaloguj
        </button>
        </br>
        <a href="/register" class="btn btn-lg btn-primary btn-block">Zarejestruj się</a>

    </form>
    <% if(request.getParameter("error")!=null)
    {   %>
    <script> $(".container").append("Błędne dane logowania") </script>
    <% } %>
</div>




</body>
</html>