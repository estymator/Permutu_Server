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
    }

    toggleTimer(period, flag, div){
        console.log("Odpalanie timera dla "+ div);
        this.isPaused=flag;
        var _this=this;
        if(this.remainingTime==null&&!flag)
        {


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
                    console.log("ustalenie czasu dwa"+_this.remainingTime);
                    _this.remainingTime=_this.remainingTime-1;
                    console.log("ustalenie czasu trzy"+_this.remainingTime);
                    _this.minutes = Math.floor((_this.remainingTime / 60) % 60);
                    _this.seconds = Math.floor(_this.remainingTime % 60);
                    _this.remainingTimeString= _this.minutes + "m : " + _this.seconds + "s ";
                    console.log("Pozostało - "+_this.remainingTimeString)
                    document.getElementById(div).innerHTML = _this.minutes + "m : " + _this.seconds + "s ";


                    // If the count down is finished, write some text
                    if (_this.remainingTime < 0) {
                      clearInterval(_this.clock);
                      document.getElementById(div).innerHTML = "00 : 00";
                    }
                }else
                {
                    document.getElementById(div).innerHTML = _this.remainingTimeString;
                }
            },1000);

        }
    }

}