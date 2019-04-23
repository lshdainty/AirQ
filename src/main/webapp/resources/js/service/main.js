$(document).ready(function(){
	
    var bgImage = $(".bg-image"),
        dude = $(".dude"),
        scrollLine = $(".scroll-line"),
        scrollDown = $(".scrolldown"),
        titleMain = $(".title-main")

    var tLoader = new TimelineMax();
        tLoader
        .from(titleMain,1,{autoAlpha:0})
        .from(scrollLine,0.5,{scaleY:0,transformOrigin:"center top",ease:Power1.easeOut})
        .from(bgImage,2,{autoAlpha:0,scale:4.5,ease:Power1.easeOut},'-=2')
        .from(dude,2,{autoAlpha:0,scale:4.5,ease:Power1.easeOut},'-=2.5')


    
    var controller = new ScrollMagic.Controller();

    var tlMainScroll = new TimelineMax()
    .add([
        TweenMax.to(dude,4,{scale:2,y:150,x:"-20%",ease:Power1.easeInOut}),
        TweenMax.to(titleMain,1,{autoAlpha:0}),
        TweenMax.to(bgImage,4,{scale:2,ease:Power1.easeInOut})
    ])

    var tweenHome = new ScrollMagic.Scene({
        triggerElement:'.pin-scene',
        triggerHook:0,
        duration:'110%'
    })
    .setTween(tlMainScroll)
    .setPin('.pin-scene')
    .addTo(controller);

    var tlMainScrollOut = new TimelineMax()
    .add([
        TweenMax.to(bgImage,5,{autoAlpha:0}),
        TweenMax.from('.section2',4,{autoAlpha:0}),
        TweenMax.to(dude,5,{autoAlpha:0}),
    ])

    var section2 = new ScrollMagic.Scene({
        triggerElement:'.section2',
        triggerHook:0,
        duration:'30%'
    })
    .setTween(tlMainScrollOut)
    .setPin('.section2')
    .addTo(controller);

});

