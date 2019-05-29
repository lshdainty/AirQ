$.ajax({
	type: "get",
	url: "/homedustdata",
	dataType:"json",
	async: false,
	success: function(data) {
		var test = data;
	}
});