let selectedBlocks = [];

let move = {};


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#reset").prop("disabled", !connected);
    $('#main-board').load('../resources/mainBoard.jsp');
    $('#players-block').load('../resources/playerBlocks.jsp');
    $("#disconnect").prop("disabled", !connected);
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    move = Stomp.over(socket);
    move.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        move.subscribe('/play', function (play) {
            showState();
        });

        // Powiadomienie dla innych graczy ze ktos wszedł do pokoju
        move.send("/knock",{},JSON.stringify(move));

    });

}

function disconnect() {
    move.playerLogin=document.getElementById("login").innerText ;
    move.send("/leave",{},JSON.stringify(move));
    if (move !== null) {
        move.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
    window.location='/home'
}

function sendMove() {
    move.playerLogin = document.getElementById("login").innerText ;
    move.selectedBlocks = selectedBlocks;
    move.roomName = document;
    console.log(move);
    move.send("/move", {}, JSON.stringify(move));
    var mainboard=document.querySelector('#main-board').outerHTML;
    var players=document.querySelector('#players-block').outerHTML;
    sendHistory(mainboard, players);
}

function showState() {
    console.log("HERE");
    move.playerLogin = "";
    selectedBlocks = [];
    $('#playersLoginSection').load('../resources/loginBoard.jsp');
    $('#main-board').load('../resources/mainBoard.jsp');
    $('#players-block').load('../resources/playerBlocks.jsp');
    /*
    var mainboard=document.querySelector('#main-board').outerHTML;
    var players=document.querySelector('#players-block').outerHTML;
    sendHistory(mainboard, players);
     */
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMove(); });
    $("#reset").click(function() {resetGame();});
    $("#change").click(function() {change();});
});


function selected(elem){
    let blockId =  document.getElementById(elem.id);
    if(blockId.getAttribute("selected")=='true'){
        blockId.setAttribute('selected','false');
        blockId.style.backgroundColor = "gray";
        let index = selectedBlocks.indexOf(blockId.id);
        if(index > -1){
            selectedBlocks.splice(index,1);
        }
        console.log(selectedBlocks);

    }
    else{
        blockId.setAttribute('selected','true');
        blockId.style.backgroundColor = "pink";
        selectedBlocks.push(blockId.id);
        console.log(selectedBlocks);
    }
}

function resetGame(){

    if(move.connected)
    {
        move.playerLogin = document.getElementById("login").innerText;
        console.log(move);
        move.send("/reset",{}, JSON.stringify(move));
    }else
    {
        console.log("Not connected yet")
    }
}

function sendHistory(main, players){
    $.post('http://localhost:8081/historyKK', {
        "room": document.getElementById("roomName").value,
        "mainBoard" : main,
        "playersBlocks" : players,
    }).error(function(XHR,status,error){
        console.log(XHR.responseJSON.message);
        $(".container").append(XHR.responseJSON.message)
    });
}

function sendHistoryD(direction){
    $.post('http://localhost:8081/historyKKK', {
        "room": document.getElementById("roomName").value,
        "direction": direction,
    },
        function (returnedData) {
            if(returnedData==="fine"){
                $('#history-section').load('../resources/history.jsp');
            }
    }).error(function(XHR,status,error){
        console.log(XHR.responseJSON.message);
        $(".container").append(XHR.responseJSON.message)
    });
}

function winnerAlert(winner){
    $.post('http://localhost:8081/winner', {
        "winner": winner,
        "room" : document.getElementById("roomName").value,
        },
        function(returnedData){
            console.log(returnedData);
            if(returnedData === winner)
            {
                alert("Wygrał " + winner);
                $('#watch-replay').css('display', 'block');
            }
        }).error(function(XHR, status, error){
        console.log(XHR.responseJSON.message);
        $(".container").append(XHR.responseJSON.message)

    });

}

function timeGoOut(userId){

}

function hovered(elem) {
    [].forEach.call(document.querySelectorAll('.btn[letter="' + elem.getAttribute('letter') + '"]'), (div) => {
        if (div.style.backgroundColor!="pink") {
            div.style.backgroundColor = 'lightgreen';
        }
    })
}

function hoveredTutorialRed(elem) {
    elem.style.backgroundColor="red"
}
function unhoveredTutorialRed(elem) {
    if (elem.style.backgroundColor="red") {
        elem.style.backgroundColor="rgba(159,151,151,0.46)";
    }
}

function unhovered(el) {
    var sign = el.getAttribute('letter');
    [].forEach.call(document.querySelectorAll('.btn[letter="' + sign + '"]'), (div) => {
        if (div.style.backgroundColor!="pink") {
            div.style.backgroundColor = 'rgba(159,151,151,0.46)';
        }
    })
}

function change(){

    $.post('http://localhost:8081/change', { "inputLogin": document.getElementById("inputLogin").value,
            "inputPassword4": document.getElementById("inputPassword4").value,
            "inputEmail4": document.getElementById("inputEmail4").value,
            "inputPassword24": document.getElementById("inputPassword24").value,
            "currentLogin": document.getElementById("currentLogin").value
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

}

function showNext() {
    var first = document.querySelectorAll('section.hidden.toshow')[0];
    first.classList.remove('hidden');
    first.classList.remove('toshow');
    first.classList.add('active');
}

function hideActive() {
    var active = document.querySelector('section.active');
    active.classList.add('hidden');
    active.classList.remove('active');
}

function potwierdzSamouczek0(elem) {
    showNext();
    document.querySelector('#first-section').classList.add('hidden');
}

function potwierdzSamouczek1(elem) {
    if((document.querySelector('#black-B')).style.backgroundColor==="pink"){
        console.log("potwierdz1 dziala");
        hideActive();
        showNext();
    } else {
        console.log("potwierdz1 nie dziala")
    }
}

function potwierdzSamouczek12(elem) {
    hideActive();
    showNext();
}

function potwierdzSamouczek2() {
    if((document.querySelector('#red-G')).style.backgroundColor==="pink"&&(document.querySelector('#black-H')).style.backgroundColor==="pink"&&(document.querySelector('#green-I')).style.backgroundColor==="pink"){
        console.log("potwierdz2 dziala");
        hideActive();
        showNext();
    } else {
        console.log("potwierdz2 nie dziala")
    }
}
function potwierdzSamouczek21() {
    hideActive();
    showNext();
}

function potwierdzSamouczek3() {
    if((document.querySelector('#black-M')).style.backgroundColor==="pink"&&(document.querySelector('#green-N')).style.backgroundColor==="pink"){
        console.log("potwierdz2 dziala");
        hideActive();
        showNext();
    } else {
        console.log("potwierdz2 nie dziala")
    }
}

function potwierdzSamouczek31() {
    hideActive();
    showNext();
}

function potwierdzSamouczek4() {
    window.location.replace("home");
}

function redirectToHistory(){
    showState();
    $('#players-block').remove();
    $('#main-board').remove();
    $('#control-panel').remove();
    $('#history-section').load('../resources/history.jsp');
    $('#buttons-replay').css('display', 'block');
}