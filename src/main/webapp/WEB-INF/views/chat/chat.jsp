<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sockjs.js"/>"></script>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script type="text/javascript">

    $(document).ready(function() {
        $("#sendBtn").click(function() {
            sendMessage();
        });
    });
    
    var sock;
    function sendMessage() {
        sock = new SockJS("<c:url value="/echo"/>");
        alert("1");
        sock.onmessage = onMessage;
        alert("2");
        sock.onclose = onClose;
        alert("3");
        sock.onopen = function() {
        	alert("message 보냄");
            sock.send( $("#message").val() );
        };
    };
    
    function onMessage(evt) {
    	alert("onMessage 이벤트");
        var data = evt.data;
        $("#data").append(data);
        /* sock.close(); */
    };
    
    function onClose(evt) {
    	alert("클라이언트와 연결 끊김");
        $("#data").append("연결 끊김");
    };
</script>
</head>
<body>
    <input type="text" id="message" />
    <input type="button" id="sendBtn" value="전송" />
    <div id="data"></div>
</body>
</html>
