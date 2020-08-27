let selectedBlocks = [];

let move = {};


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $('#main-board').load('../resources/mainBoard.jsp');
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
    if (move !== null) {
        move.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
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
});


function selected(elem){
    let blockId =  document.getElementById(elem.id);
    if(blockId.style.backgroundColor === "pink"){
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