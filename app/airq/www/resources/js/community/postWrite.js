$(document).ready(function(){
    $(document).on("click","#postWriteBtn",function(){
        var post_content = CKEDITOR.instances.postContent.getData().replace("","");
        var post_title = $('#post_title').val();
        var member_id = sessionStorage.getItem("member_id");
        var data = {
          post_title : post_title,
          post_content : post_content,
          member_id : member_id,
          board_code : sessionStorage.getItem("board_code")
        }
        console.log(data);
        $.ajax(
          {
            crossDomain: true,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            url: sessionStorage.getItem("IP_ADDRESS")+"/m.postInsert",
            headers: { "Access-Control-Allow-Origin": "*" },
            data: data,
            success: function (data, status, jqXHR) {
              history.go(-1);
            },
            error: function (jqXHR, status) {
              alert('error');
            }
          });
      });
});