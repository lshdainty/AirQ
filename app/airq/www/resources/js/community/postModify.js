$(document).ready(function(){
    var postCode = window.location.search.substring(1).split('?').toString();
    var data = { post_code: postCode.toString() };
    $.ajax(
      {
        crossDomain: true,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: "http://39.127.7.69/m.postModify",
        headers: { "Access-Control-Allow-Origin": "*" },
        data: data,
        dataType: "json", //also tried "jsonp"
        success: function (data, status, jqXHR) {
            console.log(data);
            var p_creation_date = new Date(data.modifyPost.p_creation_date.time).toISOString().slice(0, 16);
            var test = p_creation_date.replace('T', ' ');
            console.log(data.modifyPost.post_content);  
            var postContent = (data.modifyPost.post_content).replace("<body>","").replace("</body>","");
            var modifyContent = $('#postContent').html(postContent).appendTo($('#postContent'));
            $('#postContent').html(postContent);
        },
        error: function (jqXHR, status) {
          alert('error');
        }
      });

});