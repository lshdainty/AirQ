var init = function() {
    TweenLite.to($('.load-gate'), 0.5, {opacity: 0, onComplete: function() {
        $('.load-gate').remove();
    }});
};
var pAnimation = function(){
	TweenMax.staggerFrom($('.post-item'),1,{autoAlpha:0,x:-150,ease:Power1.easeOut},0.1);
}

$(document).ready(function(){
	if (document.readyState == 'complete') {
	    init();
	} else {
	    $(window).on('load',init);
	};
	pAnimation();
});