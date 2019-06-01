$(function(){
    $('.category-option').click(function(){
        $(".option-active").removeClass("option-active");
        $('.post-category').find(this).addClass("option-active");
    });
});
