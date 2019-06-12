<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/manage/remoteMain.css" />
	
 <!-- in the <button> tags below the ID attribute is the value sent to the arduino -->
 
 <button id="11" class="led">Toggle Pin 11</button> <!-- button for pin 11 -->
 <button id="12" class="led">Toggle Pin 12</button> <!-- button for pin 12 -->
 <button id="13" class="led">Toggle Pin 13</button> <!-- button for pin 13 -->
  

 <script type="text/javascript">
  $(document).ready(function(){
   $(".led").click(function(){
    var p = $(this).attr('id'); // get id value (i.e. pin13, pin12, or pin11)
    // send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
    alert(p);
    
    $.get("http://192.168.0.9:90/", {pin:p}); // execute get request (아두이노 웹서버 IP 주소로 고쳐 준다)
   alert("pin: " + p);
   });
  });
 </script>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/manage/remoteMain.js'></script>
<%@include file="../include/footer.jsp" %>