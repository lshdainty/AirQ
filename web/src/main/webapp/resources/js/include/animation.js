var init = function() {
    TweenLite.to($('.load-gate'), 0.5, {opacity: 0, onComplete: function() {
        $('.load-gate').remove();
    }});
};

$(document).ready(function(){
	if (document.readyState == 'complete') {
	    init();
	} else {
	    $(window).on('load',init);
	};
	TweenMax.staggerFrom($('.post-item'),1,{autoAlpha:0,x:-100,ease:Power1.easeOut},0.1);
	$(document).bind("ajaxComplete", function(){
		TweenMax.staggerFrom($('.post-item'),1,{autoAlpha:0,x:-100,ease:Power1.easeOut},0.1);
	 });
});