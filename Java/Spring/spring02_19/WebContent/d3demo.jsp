<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
  .chart div{
  	font: 10px sans-serif;
  	background: #6633cc;
  	text-align: right;
  	padding: 3px;
  	margin: 1px;
  	color : white;
</style>
</head>
<body>
<div class="chart"></div>
   <script src="//d3js.org/d3.v3.min.js"></script>
   <script>
      // let ECMA JS 6에 추가 변수 선언 방식 ( var 대신 )
      let data = [ 30, 85, 120, 300, 200, 380 ]
      d3.select(".chart")
      .selectAll("div")
      .data(data)
      .enter()
      .append("div")
      .style("width", function(d) { return d + "px";})
      .text(function(d){ return "$"+d});
   </script>
</body>
</html>