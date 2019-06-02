
var page = 'connect';
var slidePage = 0;
var slideCategory = ['connect', 'tender'];
var swiper = new Swiper('.swiper-container', {
  scrollbar: {
    el: '.swiper-scrollbar',
    hide: false,
  },
  effect: 'coverflow'
});
swiper.on('slideNextTransitionEnd', function () {
  $("html, body").animate({ scrollTop: 0 }, 1);
  var slideActive = $('swiper-slide-active');
  console.log(slideActive.css('background',"black"));
  slidePage++;
  page = 'tender';
  console.log(slidePage);
  console.log(page);
});
swiper.on('slidePrevTransitionEnd', function () {
  $("html, body").animate({ scrollTop: 0 }, 1);
  var slideActive = $('swiper-slide-active');
  console.log(slideActive);
  slidePage--
  page = 'compare';
  console.log(slidePage);
  console.log(page);
  
});
$('#comCatBtn').click(function (e) {

  swiper.slidePrev();
  $("html, body").animate({ scrollTop: 0 }, 1);
});
$('#tenCatBtn').click(function (e) {

  swiper.slideNext();
  $("html, body").animate({ scrollTop: 0 }, 1);
});

$(function () {
  $('.cat-content').click(function () {
    $(".cat-active").removeClass("cat-active");
    $('.top-cat__app').find(this).addClass("cat-active");
  });
  $('.select-place').click(function () {
    $(".place-area").animate({
      opacity: "toggle",
      height: "toggle"
    }, 200, function () {
      // Animation complete.
    });
  });
  $(function () {
    $('.connect-post').click(function () {
      var selectPost = $($(this).parent().parent().find('.post-detail'));
      selectPost.animate({
        opacity: "toggle",
        height: "toggle"
      }, 200, function () {
        // Animation complete.
      });
    });
  });
});