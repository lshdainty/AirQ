function getThumbnailPosts(board_code, pagenum) {
	var data = { board_code: board_code, pagenum: pagenum };
	$.ajax(
		{
			crossDomain: true,
			type: "GET",
			contentType: "application/json; charset=utf-8",
			url: sessionStorage.getItem('IP_ADDRESS')+"/m.getPosts", // 로그인 페이지 경로
			headers: { "Access-Control-Allow-Origin": "*" },
			data: data,
			dataType: "json", //also tried "jsonp"
			success: function (data, status, jqXHR) {
				var postRow = $('.post-row');
				postRow.empty();
				var posts = '';
				var page = '';
				$.each(data.pList, function (index) {

					var postContainer = $('<div/>').addClass('col-md-4 post-item');
					var postCard = $('<div/>').addClass('card mb-4').appendTo(postContainer);
					if ((data.pList[index].post_thumbnail).substring(0, 1) == 'h')
						var postImg = $('<img>').attr('src', data.pList[index].post_thumbnail).addClass('card-img-top').attr('style', 'height: 200px; overflow: hidden').appendTo(postCard);
					else
						var postImg = $('<img>').attr('src', sessionStorage.getItem("IP_ADDRESS") + data.pList[index].post_thumbnail).addClass('card-img-top').attr('style', 'height: 200px; overflow: hidden').appendTo(postCard);
					var postBody = $('<div/>').addClass('card-body').appendTo(postCard);
					var cardTitle = $('<h5/>').addClass('card-title').appendTo(postBody).text(data.pList[index].post_title + '[' + data.pList[index].reply_count + ']').appendTo(postBody);
					var postWirteBtn = $('<a/>').attr('href', '../../../www/views/community/postDetail.html?' + data.pList[index].post_code).addClass('btn btn-primary').text('자세히').appendTo(postBody);

					postContainer.appendTo(postRow);

				});
				if (data.criteria.prev) {
					page += '<li class="page-item"><a class="page-link" href="javascript:thumbnailPage(' + (data.criteria.startPage - 1) + ');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for (var i = data.criteria.startPage; i <= data.criteria.endPage; i++) {
					page += '<li class="page-item"><a class="page-link" href="javascript:thumbnailPage(' + i + ');">' + i + '</a></li>'
				}
				if (data.criteria.next) {
					page += '<li class="page-item"><a class="page-link" href="javascript:thumbnailPage(' + (data.criteria.endPage + 1) + ');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".pagination").empty();
				$(".pagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			},
			error: function (jqXHR, status) {
				alert('error');
			}
		});
}
function getTablePosts(board_code, pagenum) {
	var data = { board_code: board_code, pagenum: pagenum };
	$.ajax(
		{
			crossDomain: true,
			type: "GET",
			contentType: "application/json; charset=utf-8",
			url: sessionStorage.getItem("IP_ADDRESS") + "/m.getPosts",
			headers: { "Access-Control-Allow-Origin": "*" },
			data: data,
			dataType: "json", //also tried "jsonp"
			success: function (data, status, jqXHR) {
				var postRow = $('.post-row');
				postRow.empty();
				var posts = '';
				var page = '';
				$.each(data.pList, function (index) {

					var p_creation_date = new Date(data.pList[index].p_creation_date.time).toISOString().slice(0, 16);
					var test = p_creation_date.replace('T', ' ');


					var tableContainer = $('<li/>').addClass('tableListContent post-detail post-item');
					var postCode = $('<input/>').attr('type', 'hidden').val(data.pList[index].post_code).appendTo(tableContainer);
					var tableNum = $('<div/>').addClass('tableColumn tableCol-10-1').text(data.pList[index].rownum).appendTo(tableContainer);
					var tableTitle = $('<div/>').addClass('tableColumn tableCol-30').text(data.pList[index].post_title).appendTo(tableContainer);
					var tableContent = $('<div/>').addClass('tableColumn tableCol-15').html(data.pList[index].post_content).appendTo(tableContainer);
					var tableAuthor = $('<div/>').addClass('tableColumn tableCol-15').text(data.pList[index].member_id).appendTo(tableContainer);
					var tableDate = $('<div/>').addClass('tableColumn tableCol-15').text(test).appendTo(tableContainer);
					tableContainer.appendTo(postRow);

				});
				if (data.criteria.prev) {
					page += '<li class="page-item"><a class="page-link" href="javascript:tablePage(' + (data.criteria.startPage - 1) + ');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for (var i = data.criteria.startPage; i <= data.criteria.endPage; i++) {
					page += '<li class="page-item"><a class="page-link" href="javascript:tablePage(' + i + ');">' + i + '</a></li>'
				}
				if (data.criteria.next) {
					page += '<li class="page-item"><a class="page-link" href="javascript:tablePage(' + (data.criteria.endPage + 1) + ');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".pagination").empty();
				$(".pagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			},
			error: function (jqXHR, status) {
				alert('error');
			}
		});
}

$(document).on('click', '.post-detail', function () {
	var post_code = $(this).children('input').val();
	window.location.href = "../../../www/views/community/postDetail.html?" + post_code;
});

function thumbnailPage(idx) {
	var pagenum = idx;
	var board_code = window.location.search.split("?").toString().split("board_code=").toString();
	board_code = board_code.substr(board_code.indexOf("bd_"));
	sessionStorage.setItem("board_code", board_code);
	sessionStorage.setItem("pagenum", pagenum);
	var pageURL = sessionStorage.getItem("IP_ADDRESS") + "/m.getPosts?board_code=" + board_code + "&pagenum=" + pagenum;
	getThumbnailPosts(board_code.toString(), pagenum)
}
function tablePage(idx) {
	var pagenum = idx;
	var board_code = window.location.search.split("?").toString().split("board_code=").toString();
	board_code = board_code.substr(board_code.indexOf("bd_"));
	sessionStorage.setItem("board_code", board_code);
	sessionStorage.setItem("pagenum", pagenum);
	var pageURL = sessionStorage.getItem("IP_ADDRESS") + "/m.getPosts?board_code=" + board_code + "&pagenum=" + pagenum;
	getTablePosts(board_code.toString(), pagenum)
}
(function () {
	'use strict'

	window.addEventListener('load', function () {
		// Fetch all the forms we want to apply custom Bootstrap validation
		// styles to
		var forms = document.getElementsByClassName('needs-validation')

		// Loop over them and prevent submission
		Array.prototype.filter.call(forms, function (form) {
			form.addEventListener('submit', function (event) {
				if (form.checkValidity() === false) {
					event.preventDefault()
					event.stopPropagation()
				}
				form.classList.add('was-validated')
			}, false)
		})
	}, false)
}())

$(document).ready(function () {
	var init = function () {
		var board_code = window.location.search.split("?").toString().split("board_code=").toString();
		board_code = board_code.substr(board_code.indexOf("bd_"));
		if (board_code != "")
			sessionStorage.setItem("board_code", board_code);
		sessionStorage.setItem("pagenum", 1);

		$('#header').load('../../../www/views/include/header.html');
		$('#footer').load('../../../www/views/include/footer.jsp');
		var path;
		if (window.location.pathname.match('/tableBoardMain.html'))
			path = 'tableBoardMain.html';
		else
			path = 'thumbnailBoardMain.html';

		switch (path) {
			case 'tableBoardMain.html':
				getTablePosts(board_code.toString(), "1");
				if ((board_code.toString()) == 'bd_lib') {
					var header = $('<div/>').addClass('page-header');
					var headerTitle = $('<h3/>').text('커뮤니티 - 자유게시판').appendTo(header);
					var headerSubTitle = $('<p/>').text('Liberty Board').appendTo(header);
					header.prependTo($('#content'));
				}
				break;
			case 'thumbnailBoardMain.html':
				getThumbnailPosts(board_code.toString(), "1");
				switch (board_code.toString()) {
					case 'bd_rec':
						var header = $('<div/>').addClass('page-header');
						var headerTitle = $('<h3/>').text('커뮤니티 - 상품추천').appendTo(header);
						var headerSubTitle = $('<p/>').text('Product Recommand').appendTo(header);
						header.prependTo($('#content'));
						break;
					case 'bd_met':
						var header = $('<div/>').addClass('page-header');
						var headerTitle = $('<h3/>').text('커뮤니티 - 대기오염물질').appendTo(header);
						var headerSubTitle = $('<p/>').text('ATMOSPHERE POLLUTION MATTER').appendTo(header);
						header.prependTo($('#content'));
						break;
					case 'bd_imp':
						var header = $('<div/>').addClass('page-header');
						var headerTitle = $('<h3/>').text('커뮤니티 - 공기질향상방법').appendTo(header);
						var headerSubTitle = $('<p/>').text('AIR QUALITY ENHANCEMENT METHODR').appendTo(header);
						header.prependTo($('#content'));
						break;
					case 'bd_hea':
						var header = $('<div/>').addClass('page-header');
						var headerTitle = $('<h3/>').text('커뮤니티 - 건강지킴이').appendTo(header);
						var headerSubTitle = $('<p/>').text('HEALTH GUARD').appendTo(header);
						header.prependTo($('#content'));
						break;
				}
				break;
		}
	};
	init();
	$('#post-write').click(function () {
		window.location.href = "postWriteForm.html";
	});

	$(document).on("click", ".reply-delete", function () {
		var post_code = $('#post_code').val();
		var reply_code = $(this).next().val();
		var data = { 'reply_code': reply_code, 'post_code': post_code };
		$(this).parent().parent().parent().parent().remove();
		$.ajax({
			type: 'post',
			data: data,
			url: 'replyDelete',
			success: function (result) {
				var reply_count = parseInt($('#reply_count').text());
				reply_count = reply_count - 1;
				$('#reply_count').text(reply_count);
				$('#post_ReplyCount').html('댓글&nbsp' + reply_count);
			}
		});
	});
});