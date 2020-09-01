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
}

function showState() {
    console.log("HERE");
    move.playerLogin = "";
    selectedBlocks = [];
    $('#players-block').load('../resources/playerBlocks.jsp');
    $('#main-board').load('../resources/mainBoard.jsp');

}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMove(); });
    $("#reset").click(function() {resetGame();});
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

    function winnerAlert(winner){
        $.post('http://localhost:8081/winner', { "winner": winner,
            }).error(function(XHR, status, error){
            console.log(XHR.responseJSON.message);
            $(".container").append(XHR.responseJSON.message)

        });

        alert("The winner is " + winner);

    }

function hovered(elem) {
    [].forEach.call(document.querySelectorAll('.btn[letter="' + elem.getAttribute('letter') + '"]'), (div) => {
        if (div.style.backgroundColor!="pink") {
            div.style.backgroundColor = 'lightgreen';
        }
    })
}

function unhovered(el) {
    var sign = el.getAttribute('letter');
    [].forEach.call(document.querySelectorAll('.btn[letter="' + sign + '"]'), (div) => {
        if (div.style.backgroundColor!="pink") {
            div.style.backgroundColor = 'rgba(159,151,151,0.46)';
        }
    })
}