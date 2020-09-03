<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="permutu.Models.*" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Permutu - Play</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/styles/startPagestyle.css">

    <script src="https://kit.fontawesome.com/c43499c33d.js" crossorigin="anonymous"></script>
    <script src="../../resources/js/script.js"></script>
</head>
<body>
<div class="containter">


        <a id="button1" class="btn btn-1" >Poznaj zasady</a>

        <a id="button2"class="btn btn-1" >Rejestracja</a>

        <a id="button3"class="btn btn-1" >Logowanie</a>

    </div>

    <script type="text/javascript">
        document.getElementById("button1").onclick = function () {
            location.href = "/samouczek";
        };
        document.getElementById("button2").onclick = function () {
            location.href = "/register";
        };
        document.getElementById("button3").onclick = function () {
            location.href = "/login";
        };
    </script>
</body>

</html>