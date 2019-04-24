$(document).ready(function(){
	
    var bgImage = $(".bg-image"),
        dude = $(".dude"),
        scrollLine = $(".scroll-line"),
        scrollDown = $(".scrolldown"),
        titleMain = $(".title-main")

    var tLoader = new TimelineMax();
        tLoader
        .from(titleMain,1,{autoAlpha:0})
        .from(scrollLine,0.5,{scaleY:0,transformOrigin:"center top",ease:Bounce.easeOut})
        .from(bgImage,2,{autoAlpha:0,scale:4.5,ease:Power1.easeOut},'-=2')
        .from(dude,2,{autoAlpha:0,scale:4.5,ease:Power1.easeOut},'-=2.5')
        .to(dude,2,{scale:2,y:150,x:"-20%",autoAlpha:0,ease:Power1.easeInOut})
        .to(titleMain,1,{autoAlpha:0})
        .to(bgImage,2,{scale:2,autoAlpha:0,ease:Power1.easeInOut})
        .from('.section2',1,{autoAlpha:0})
        .to(dude,5,{autoAlpha:0})

});

