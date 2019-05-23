$(function(){
    $('.cat-content').click(function(){
        $(".cat-active").removeClass("cat-active");
        $('.top-cat__app').find(this).addClass("cat-active");
    });
    $('.select-place').click(function(){
        $( ".place-area" ).animate({
            opacity: "toggle",
            height: "toggle"
          }, 1000, function() {
            // Animation complete.
          });
    });
});