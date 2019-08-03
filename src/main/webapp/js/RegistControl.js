$(document).ready(function(){
    $("#name").blur(function(){


        var val=this.value;
        $.getJSON("CheckUserNameServlet",{"uname":this.value}, function(json){
            console.log(json);
            if(json.result+"" == "false"){
                $("#nameWarn2").hide();
            }
            else if(json.result+"" == "true"){
                $("#nameWarn2").show();
                $("#name").focus();
            }

            if(val.length > 10) {
                $("#nameWarn").show();
                $("#name").focus();
            }

            if(val.length <= 10){
                $("#nameWarn").hide();
            }
        });
    });


    $("#pwd").blur(function(){
        var pwdvalue = $("#pwd").value;
        var repwdvalue = $("#repwd").value;

        console.log("")
    });
});


























































































































































/*
$(document).ready(function(){
    $("#registbtn").hide();
    $("p").click(function(){
        $(this).hide();});

    $("#nameWarn").hide();
    $("#pwdWarn").hide();
    $("#repwdWarn").hide();

    $("#name").blur(function(){
        if(this.value.length > 10) {
            $("#registbtn").hide();
            $("#nameWarn").show();
            $("#name").focus();
        }
        else if(this.value.length <= 10){
            if(this.value.length != 0){
                $("#registbtn").show();
                $("#nameWarn1").hide();
            }
            else if(this.value.length == 0)
            {
                $("#registbtn").hide();
                $("#nameWarn1").show();
            }

        }
    });


    $("#pwd").blur(function(){
        if(this.value.length > 15){
            $("#pwdWarn").show();
            $("#registbtn").hide();
            $("#pwd").focus();
        }
        else if(this.value.length <= 15){
            if(this.value.length != 0){
                $("#registbtn").show();
                $("#pwdWarn1").hide();
            }
            else if(this.value.length == 0){
                $("#pwdWarn1").show();
                $("#registbtn").hide();
                $("#pwd").focus();
            }

        }
    });



    $("#repwd").blur(function(){
        if(this.value != $("#pwd").val() || this.value.length == 0){
            $("#repwdWarn").show();
            $("#registbtn").hide();
            $("#repwd").focus();
        }
        else if(this.value == $("#pwd").val() && this.value.length != 0){
            $("#repwdWarn").hide();
            $("#registbtn").show();
        }
    });



});*/
