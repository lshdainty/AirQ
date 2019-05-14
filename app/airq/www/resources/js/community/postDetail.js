$(document).ready(function () {
  var postCode = window.location.search.substring(1).split('?').toString();
  var data = { post_code: postCode.toString() };
  $.ajax(
    {
      crossDomain: true,
      type: "GET",
      contentType: "application/json; charset=utf-8",
      url: "http://39.127.7.69/m.postDetail",
      headers: { "Access-Control-Allow-Origin": "*" },
      data: data,
      dataType: "json", //also tried "jsonp"
      success: function (data, status, jqXHR) {
        console.log(data);
        var p_creation_date = new Date(data.detailPost.p_creation_date.time).toISOString().slice(0, 16);
        var test = p_creation_date.replace('T', ' ');

        var article = $('.article');
        var articleHeader = $('<div/>').addClass('article-header').appendTo(article);
        var articleTitle = $('<div/>').addClass('article__title').text(data.detailPost.post_title).appendTo(articleHeader);
        var articleMeta = $('<div/>').addClass('article-meta').appendTo(articleHeader);
        var articleMetaList = $('<div/>').addClass('article-meta-list').appendTo(articleMeta);
        var articleMetaItem_member = $('<div/>').addClass('article-meta__item article-meta__item--name').appendTo(articleMetaList);
        var member_id = $('<a/>').text(data.detailPost.member_id).appendTo(articleMetaItem_member);
        var articleMetaItem_date = $('<div/>').addClass('article-meta__item').appendTo(articleMetaList);
        var date = $('<span/>').text(test).appendTo(articleMetaItem_date);
        var articleMetaListRight = $('<div/>').addClass('article-meta-list article-meta-list--right').appendTo(articleMeta);
        var articlemetaItem = $('<div/>').addClass('article-meta__item').appendTo(articleMetaListRight)
        var articleMetaItem_viewNum = $('<span/>').text('조회 ' + data.detailPost.view_num).appendTo(articlemetaItem);
        var articlemetaItem2 = $('<div/>').addClass('article-meta__item').appendTo(articleMetaListRight)
        var articleMetaItem_reply = $('<span/>').text('댓글 ' + data.detailPost.reply_count).appendTo(articlemetaItem2);
        var articlemetaItem3 = $('<div/>').addClass('article-meta__item recommend_num').appendTo(articleMetaListRight)
        var articleMetaItem_reply = $('<span/>').text('추천수 ' + data.detailPost.recommend_num).appendTo(articlemetaItem3);


        var articleContainerWrap = $('<div/>').addClass('article-content-wrap').appendTo(article);
        var articleContent = $('<div/>').addClass('article-content').html(data.detailPost.post_content).appendTo(articleContainerWrap);


        var articleVote = $('<div/>').addClass('article-vote').appendTo(article);
        var articleVoteBtn = $('<button/>').addClass('article-vote__button button').attr('type', 'submit').attr('id', 'post-vote').appendTo(articleVote);
        var articleVoteRec = $('<span/>').addClass('article-vote__up-arrow').text('추천 ').appendTo(articleVoteBtn);
        var articleVoteNum = $('<span/>').addClass('article-vote__count recommend_num').text(data.detailPost.recommend_num).appendTo(articleVoteBtn);

        $('.comment__title').append('<span class="comment__count"> 총 <em id="reply_count">' + data.detailPost.reply_count + '</em>개</span>');
        $('.comment-write-inner').prepend('<div class="comment-write__name" id="member_id">' + data.detailPost.member_id + '</div>');
        $.each(data.replys, function (index) {
          var r_creation_date = new Date(data.replys[index].r_creation_date.time).toISOString().slice(0, 16);
          var test = r_creation_date.replace('T', ' ');
          
          var replyContent = ['<div class="comment-l">',
            '<div class="comment">',
            '<div class="comment-meta">',
            '<span class="comment__name"><a href="#">' + data.replys[index].member_id + '</a></span>',
            '<span class="comment__date"> ' + test + '</span>',
            '</div>',
            '<div class="comment-content">',
            '<div>',
            '<p>',
            '<br>' + data.replys[index].reply_content,
            '</p>',
            '</div>',
            '</div>',
            '</div>',
            '</div>',
            '</div>'].join("");
          $('.comment-list').append(replyContent);
        });
      },
      error: function (jqXHR, status) {
        alert('error');
      }
    });
    $(document).on("click","#post-vote",function(){
      $.ajax({
        type:'post',
        data:{'post_code':postCode},
        url:'http://39.127.7.69/m.postVote',
        success:function(result){
          console.log(result);
          var recommend_num = parseInt($('.recommend_num').last().text());
          recommend_num=recommend_num+1;
          $('.recommend_num').text(recommend_num);
          $('.recommend_num').first().html('추천&nbsp'+recommend_num);
        }
      });
    });
    $(document).on("click","#reply-insert",function(){
      var reply_content = $('#reply_content').val();
      var member_id = $('#member_id').text();
      var post_code = $('#post_code').val();
      var replyVO = new Object();
      
      replyVO.member_id = member_id;
      replyVO.post_code = postCode;
      replyVO.reply_content = reply_content;
      console.log(replyVO);
      $.ajax({
        type:'POST',
        url:'http://39.127.7.69/m.addReply',
        data:replyVO,
        success:function(result){	
          var content ='<div class="comment-list"><div class="comment-l"><div class="comment"><div class="comment-meta">'+
          '<span class="comment__name"><a href="#">'+member_id+'</a></span><span class="comment__date"> 방금 전'+
          '</span></div><div class="comment-content"><div><p><br>'+reply_content+'</p></div></div><div class="comment-button">'+
          '</div></div></div></div>';
           var reply_count =parseInt($('#reply_count').text());
          $('#replys').prepend(content);
          $('#reply_content').val("");
          reply_count = reply_count+1;
          $('#reply_count').text(reply_count);
          $('#post_ReplyCount').html('댓글&nbsp'+reply_count);
        }
      }); 
    });
    $(document).on("click","#postModify",function(){
      var data = {post_code : postCode};
      window.location.href = "../../../www/views/community/postModify.html?"+postCode;
    });
});