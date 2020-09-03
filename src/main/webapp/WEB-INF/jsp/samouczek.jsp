<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public String generateSpecifiedBlock(String colour, String sign, String style, String script) {
    if (style != "") {
        String tmp = "style=\"" + style + "\"!important";
        style = tmp;
    }
    if (script == "red") {
        return "<button " + style + " onmouseout=\"unhoveredTutorialRed(this)\" onmousemove=\"hoveredTutorialRed(this)\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2" + "\" " +
                "id=\"" + colour + "-" + sign + "\">\n" +
                "<span class=\"icon-" + colour + "_" + sign + "\"></span></button>";
    } else if (script == "nohigh") {
        return "<button " + style + " onclick=\"selected(this)\" letter=\"" + sign + "\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2 " + colour + "\" " +
                " id=\"" + colour + "-" + sign + "\">\n" +
                "<span class=\"icon-" + colour + "_" + sign + "\"></span></button>";
    } else if (script == "nohighnosel") {
        return "<button " + style + "letter=\"" + sign + "\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2 " + colour + "\" " +
                "id=\"" + colour + "-" + sign + "\">\n" +
                "<span class=\"icon-" + colour + "_" + sign + "\"></span></button>";
    } else {
        return "<button " + style + " onclick=\"selected(this)\" onmouseout=\"unhovered(this)\" onmousemove=\"hovered(this)\" letter=\"" + sign + "\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2 " + colour + "\" " +
                "id=\"" + colour + "-" + sign + "\">\n" +
                "               " + "<span class=\"icon-" + colour + "_" + sign + "\"></span></button>";
    }
}
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Permutu - Samouczek</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/styles/style.css">
    <link rel="stylesheet" href="/resources/styles/pilestyle.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/c43499c33d.js" crossorigin="anonymous"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="../../resources/js/script.js"></script>
    <style>
        section.hidden {
            display: none;
        }
        section {
            display: block;
        }
    </style>
</head>
<body style="background-color: white">

<main style="
    display: flex;
    flex-direction: column;
    align-items: center;
">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Permutu        Witaj ${pageContext.request.userPrincipal.name}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="/home">Home <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="/score">Wyniki</a>
                <a class="nav-item nav-link" href="/history">Historia Twoich gier</a>
                <a class="nav-item nav-link" href="/settings">Ustawienia</a>
                <a class="nav-item nav-link" href="/samouczek">Samouczek</a>
                <a class="nav-item nav-link" href="/logout">Wyloguj się</a>
            </div>
        </div>
    </nav>
    <section id="first-section">
        <div class="rules"><h1>Poznaj grę PERMUTU!</h1></div>
        <button class="btn btn-default" onclick="potwierdzSamouczek0()">Dalej</button>
    </section>
    <section class="hidden toshow">
        <div class="rules" style="text-align: center;">
            <h3 style="text-align: center">Zasada A</h3>
            <div class="sentence" style="display: flex;align-items: center;flex-direction: column;">
                Możesz wziąć pojedynczy klocek, jeśli:
                <ul style="display: flex; align-items: center; flex-direction: column;">
                    <li>
                        leży on w kolumnie zawierającej 3 klocki
                    </li>
                    <li>
                        ani Ty, ani przeciwnik nie ma klocka z takim symbolem
                    </li>
                </ul>
            </div>

            <div style="border: 1px solid black;border-radius: 20px;padding: 20px;">
                <div class="sentence" style=" display: flex;align-items: center;flex-direction: column;">
                    <h5>Klocki przeciwnika</h5>
                    <div>
                        <%
                            out.print(generateSpecifiedBlock("black", "A", "color:black", "nohighnosel"));
                            out.print(generateSpecifiedBlock("black", "C", "color:black", "nohighnosel"));
                        %>
                    </div>
                </div>
                <div class="sentence" style=" display: flex; align-items: center;flex-direction: column;">
                    <h5 style=" text-decoration: underline;">Wez odpowiedni klocek z kolumny</h5>
                    <div style="display: flex; flex-direction: column;">
                        <%
                            out.print(generateSpecifiedBlock("red", "A", "color:red", "red"));
                            out.print(generateSpecifiedBlock("black", "B", "color:black", "nohigh"));
                            out.print(generateSpecifiedBlock("green", "C", "color:green", "red"));
                        %>
                    </div>
                </div>
            </div>
            <button class="btn btn-default" onclick="potwierdzSamouczek1()">Potwierdz Ruch</button>
        </div>
    </section>
    <section class="hidden toshow">
        <div style="text-align: center">
            <h1>DOBRZE!</h1>
            <button class="btn btn-default" onclick="potwierdzSamouczek12()">Dalej</button>
        </div>
    </section>
    <section class="hidden toshow">
        <h3 style="text-align: center">Zasada B</h3>
        <div class="sentence" style="display: flex;align-items: center;flex-direction: column;">Możesz wziąć całą
            kolumnę
            (kolumna może się składać z 2 lub 3 klocków), jeśli:
            <ul style="display: flex; align-items: center; flex-direction: column;">
                <li>masz wszystkie symbole leżące w tej kolumnie, lub jeśli</li>
                <li> jeden klocek w tej kolumnie ma symbol, którego nie masz</li>
            </ul>
        </div>
        <div id="part2.1"></div>
        <div style="border: 1px solid black;border-radius: 20px;padding: 20px;">
            <div class="sentence" style=" display: flex;align-items: center;flex-direction: column;">
                <h5 style=" text-decoration: underline;">Zbierz całą kolumnę!</h5>
                <div style="display: flex">
                    <div style="display: flex; flex-direction: column;">
                        <%
                            out.print(generateSpecifiedBlock("red", "D", "color:red", "red"));
                            out.print(generateSpecifiedBlock("black", "R", "color:black", "red"));
                            out.print(generateSpecifiedBlock("green", "F", "color:green", "red"));
                        %>
                    </div>
                    <div style="display: flex; flex-direction: column;">
                        <%
                            out.print(generateSpecifiedBlock("red", "G", "color:red", "nohigh"));
                            out.print(generateSpecifiedBlock("black", "H", "color:black", "nohigh"));
                            out.print(generateSpecifiedBlock("green", "I", "color:green", "nohigh"));
                        %>
                    </div>
                </div>
            </div>
            <div class="rules" style="display: flex; align-items: center; flex-direction: column;">
                <h5>Twoje klocki</h5>
                <div style="display: flex">
                    <%
                        out.print(generateSpecifiedBlock("black", "G", "color:black", "nohighnosel"));
                        out.print(generateSpecifiedBlock("green", "H", "color:green", "nohighnosel"));
                    %>
                </div>
            </div>
        </div>

        <button class="btn btn-default" onclick="potwierdzSamouczek2()">Potwierdz Ruch</button>
    </section>
    <section class="hidden toshow">
        <h1>DOBRZE!</h1>
        <button class="btn btn-default" onclick="potwierdzSamouczek21()">Dalej</button>
    </section>
    <section class="hidden toshow">
        </div>
        <div id="part2.2"></div>
        <div style="border: 1px solid black;border-radius: 20px;padding: 20px;">
            <div class="sentence" style=" display: flex;align-items: center;flex-direction: column;">
                <h5 style=" text-decoration: underline;">Zbierz całą kolumnę!</h5>
                <div style="display: flex">
                    <div style="display: flex; flex-direction: column;">
                        <%
                            out.print(generateSpecifiedBlock("red", "J", "color:red", "red"));
                            out.print(generateSpecifiedBlock("black", "K", "color:black", "red"));
                            out.print(generateSpecifiedBlock("green", "L", "color:green", "red"));
                        %>
                    </div>
                    <div style="display: flex; flex-direction: column;">
                        <%
                            out.print(generateSpecifiedBlock("black", "M", "color:black", "nohigh"));
                            out.print(generateSpecifiedBlock("green", "N", "color:green", "nohigh"));
                        %>
                    </div>
                </div>
                <h5>Twoje klocki</h5>
                <div style="display: flex">
                    <%
                        out.print(generateSpecifiedBlock("green", "M", "color:green", "nohighnosel"));
                    %>
                </div>
            </div>
        </div>
        <button class="btn btn-default" onclick="potwierdzSamouczek3()">Potwierdz Ruch</button>
    </section>
    <section class="hidden toshow">
        <h1>DOBRZE!</h1>
        <button class="btn btn-default" onclick="potwierdzSamouczek31()">Dalej</button>
    </section>
    <section class="hidden toshow">
        <div class="rules" style="text-align: center">Zbierz więcej punktów od przeciwnika, <br>
            za zebranie 3 klocków o tym samym znaku otrzymujesz 3 punkty <br>
            jeżeli zbierzesz dwa to otrzymujesz 1
        </div>
        <button class="btn btn-default" onclick="potwierdzSamouczek4()">Zrozumiałem</button>
    </section>
</main>
</body>
</html>
