var HOME_PATH = "https://navermaps.github.io/maps.js.ncp/docs";


var map = new naver.maps.Map("map", {
        zoom: 3,
        center: new naver.maps.LatLng(36.2253017, 127.6460516),
        zoomControl: true,
        zoomControlOptions: {
            position: naver.maps.Position.TOP_LEFT,
            style: naver.maps.ZoomControlStyle.SMALL
        }
    }),
    markers = [];

var htmlMarker1 = {
        content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url('+ HOME_PATH +'/img/cluster-marker-1.png);background-size:contain;"></div>',
        size: N.Size(40, 40),
        anchor: N.Point(20, 20)
    },
    htmlMarker2 = {
        content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url('+ HOME_PATH +'/img/cluster-marker-2.png);background-size:contain;"></div>',
        size: N.Size(40, 40),
        anchor: N.Point(20, 20)
    },
    htmlMarker3 = {
        content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url('+ HOME_PATH +'/img/cluster-marker-3.png);background-size:contain;"></div>',
        size: N.Size(40, 40),
        anchor: N.Point(20, 20)
    },
    htmlMarker4 = {
        content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url('+ HOME_PATH +'/img/cluster-marker-4.png);background-size:contain;"></div>',
        size: N.Size(40, 40),
        anchor: N.Point(20, 20)
    },
    htmlMarker5 = {
        content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url('+ HOME_PATH +'/img/cluster-marker-5.png);background-size:contain;"></div>',
        size: N.Size(40, 40),
        anchor: N.Point(20, 20)
    };

function onLoad() {
    var data = accidentDeath.searchResult.accidentDeath;

    for (var i = 0, ii = data.length; i < ii; i++) {
        var spot = data[i],
            latlng = new naver.maps.LatLng(spot.grd_la, spot.grd_lo),
            marker = new naver.maps.Marker({
                position: latlng,
                draggable: true
            });

        markers.push(marker);
    }

    var markerClustering = new MarkerClustering({
        minClusterSize: 2,
        maxZoom: 8,
        map: map,
        markers: markers,
        disableClickZoom: false,
        gridSize: 120,
        icons: [htmlMarker1, htmlMarker2, htmlMarker3, htmlMarker4, htmlMarker5],
        indexGenerator: [10, 100, 200, 500, 1000],
        stylingFunction: function(clusterMarker, count) {
            $(clusterMarker.getElement()).find('div:first-child').text(count);
        }
    });
}


var loaded = 0;
var list = [
    '/data/accidentdeath.js',
    '/js/MarkerClustering.js'
];

$(list).each(function(i, itm) {
    $.getScript(HOME_PATH + itm, function() {
        loaded++;
        if (loaded == 2) {
            onLoad();
        }
    });
})
