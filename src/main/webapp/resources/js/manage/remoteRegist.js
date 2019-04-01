/**
 * 
 */
$(document).ready(function(){
	$("#btn-can").click(function(){
		location.href="remoteMain"
	});
});

function SelectValue(idvalue){
    var obj_id = document.getElementById('s_id');
    obj_id.value = idvalue;
}

function SelectValue2(idvalue2){
    var obj_id2 = document.getElementById('s_id2');
    obj_id2.value = idvalue2;
}