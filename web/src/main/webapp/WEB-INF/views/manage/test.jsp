<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/manage/remoteMain.css" />
	
  <!-- in the <button> tags below the ID attribute is the value sent to the arduino -->
 <h>ESP8266 LED Control</h></br></br>
 <button id="11" class="led">LED PIN 11</button> <!-- button for pin 11 -->
 <button id="12" class="led">LED PIN 12</button> <!-- button for pin 12 -->
 <button id="13" class="led">LED PIN 13</button> <!-- button for pin 13 -->
  
 <script type="text/javascript">
  $(document).ready(function(){
   $(".led").click(function(){
    var p = $(this).attr('id'); // get id value (i.e. pin13, pin12, or pin11)
    alert($(this).attr('id'));
    // send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
    $.get("http://39.127.7.97:3434/", {pin:p}); // execute get request
    alert("pin: " + p);
   });
  });
 </script>

<script src='resources/js/manage/remoteMain.js'></script>
<%@include file="../include/footer.jsp" %>