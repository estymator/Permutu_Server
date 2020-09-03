class Timer {
    constructor(userId)
    {
        this.clock= null;
        this.isPaused= true;
        this.clockisRunning= false;
        this.remainingTime= null;
        this.userId= userId;
        this.remainingTimeString= "00:00";
        this.minutes=0;
        this.seconds=0;
        this.remove=false;
        this.divId=null;
    }

    toggleTimer(period, flag, div){
        console.log("Odpalanie timera dla "+ div);
        this.isPaused=flag;
        var _this=this;
        if(this.remainingTime==null&&!flag)
        {
            this.divId=div;


            if(period<0 || period >15)
            {
                return;
            }
            this.remainingTime=60*period;
            console.log("Ustalenie czasu - "+this.remainingTime );


            this.clock=setInterval(function(){
                console.log("Start interwału "+ div)
                _this.clockisRunning=true;

                if(!_this.isPaused){

                    _this.remainingTime=_this.remainingTime-1;

                    _this.minutes = Math.floor((_this.remainingTime / 60) % 60);
                    _this.seconds = Math.floor(_this.remainingTime % 60);
                    _this.remainingTimeString= _this.minutes + "m : " + _this.seconds + "s ";

                    document.getElementById(div).innerHTML = _this.minutes + "m : " + _this.seconds + "s ";


                    // If the count down is finished, write some text
                    if (_this.remainingTime < 0) {
                      clearInterval(_this.clock);
                      document.getElementById(div).innerHTML = "00 : 00";

                      if(div=="timeHost")
                      {
                          console.log("Wysyłam sendAlert");
                         _this.sendAlert();
                      }
                      _this.remove=true;
                    }
                }else
                {
                    document.getElementById(div).innerHTML = _this.remainingTimeString;
                }
            },1000);

        }
    }

    sendAlert(){
        $.post('http://localhost:8081/timeGoOut', { "userId": this.userId},
        function(returnedData){
            console.log(returnedData);
            if(returnedData=="1")
            {
                console.log("ladowanie");
                $('#playersLoginSection').load('../resources/loginBoard.jsp');
                $('#main-board').load('../resources/mainBoard.jsp');
                $('#players-block').load('../resources/playerBlocks.jsp');
            }else if(returnedData=="0")
            {
                console.log("Błąd");
            }else
            {
                    alert("Wygrał " + returnedData)
            }


        });
    }

}