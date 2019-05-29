$.ajax({
	type: "get",
	url: "/homematterdata?matter=PM10",
	dataType:"json",
	async: false,
	success: function(data) {
		var result = "";
		for(var i=0; i<data.result.length; i++){
			result += '<div class="city-forecast">' +
						'<div class="ng-star-inserted">' +
							'<a class="city-forecast-link">' +
								'<div class="city-forecast-header">' +
									'<div style="flex: 1 1 0%; box-sizing: border-box;">' +
										'<span>'+data.result[i].name+'</span>' +
									'</div>' +
								'</div>' +
								'<div class="city-forecast-body aqi-bg-light-yellow aqi-yellow" style="place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 auto;">' +
									'<div style="place-content: stretch space-between; align-items: stretch; flex-direction: row; box-sizing: border-box; display: flex; flex: 1 1 0%;">' +
										'<div class="aqi-container">' +
											'<span class="aqi">'+data.result[i].data+'</span><span class="pollutant" fxlayoutalign="center center">µg/m³ | PM10</span>' +
										'</div>' +
										'<div style="flex-direction: column; box-sizing: border-box; display: flex; place-content: stretch space-between; align-items: stretch; flex: 1 1 124px; max-width: 124px; min-width: 124px; margin: auto">' +
											'<span class="status">Moderate</span>' +
										'</div>' +
									'</div>' +
								'</div>' +
							'</a>' +
						'</div>' +
					'</div>';
		}
		$(".measure-container").append(result);
	}
});