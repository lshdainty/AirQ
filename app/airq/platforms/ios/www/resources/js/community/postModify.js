$(document).ready(function(){
    var postCode = window.location.search.substring(1).split('?').toString();
    var data = { post_code: postCode.toString() };
    function check (){
      alert("check");
    }
    $.ajax(
      {
        crossDomain: true,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: sessionStorage.getItem("IP_ADDRESS")+"/m.postModify",
        headers: { "Access-Control-Allow-Origin": "*" },
        data: data,
        dataType: "json", //also tried "jsonp"
        success: function (data, status, jqXHR) {
            console.log(data);
            var p_creation_date = new Date(data.modifyPost.p_creation_date.time).toISOString().slice(0, 16);
            var test = p_creation_date.replace('T', ' ');
            console.log(data.modifyPost.post_content);  
            var postContent = (data.modifyPost.post_content).replace("<body>","").replace("</body>","");
            var postTitle = data.modifyPost.post_title;
            $('#postTitle').val(postTitle);
            var modifyContent = $('#postContent').html(postContent).appendTo($('#postContent'));
            $('#postContent').html(postContent);
        },
        error: function (jqXHR, status) {
          alert('error');
        }
      });
      $(document).on("click","#modifyUpdateBtn",function(){
        var post_code = postCode;
        var post_content = CKEDITOR.instances.postContent.getData().replace("","");
        var test = $('form[name=testForm]').serialize();
        alert(post_content);
        var post_title = $('#postTitle').val();

        var data = {
          post_code : post_code,
          post_title : post_title,
          post_content : post_content
        }
        $.ajax(
          {
            crossDomain: true,
            type: "GET",
            contentType: "application/json; charset=utf-8",
            url: sessionStorage.getItem("IP_ADDRESS")+"/m.postUpdate",
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