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

});