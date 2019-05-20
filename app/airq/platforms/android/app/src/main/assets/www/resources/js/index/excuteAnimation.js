function isLogin(){
    
    var localUserInfo = JSON.parse(localStorage.getItem("user"));
    var sessionUserInfo;
    if(localStorage.getItem("user")!=null){
        sessionStorage.setItem("user",JSON.stringify(localUserInfo));
        window.location.href="../../../www/views/service/introMain.html";
    }
    else{
        window.location.href="../../../www/views/login/loginMain.html";
    }
}

$(document).ready(function(){
	
    var bgImage = $(".bg-image"),
        logo = $(".logo");

    var tLoader = new TimelineMax();
        tLoader
        .from(logo,3.5,{autoAlpha:0});

    setTimeout(function(){
        clearTimeout();
        isLogin();
    },4000);
});

