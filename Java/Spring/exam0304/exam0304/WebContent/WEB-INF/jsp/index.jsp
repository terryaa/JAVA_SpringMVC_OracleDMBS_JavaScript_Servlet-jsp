<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mybatis-spring</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>

<script>
	$(document).ready(function() {
		var chartdata = [];
		
		$.getJSON('traffic/traffic1', function(data) {
			console.log(data);
			data.forEach(function(row) {
				var num = 0;
				console.log(row.list);
				for (key in row.list) {
					num += row.list[key];

				}
// 				console.log(row.date);
// 				console.log(typeof(parseFloat(num.toFixed(2))));
				
				chartdata.push([row.date,parseFloat(num.toFixed(2))]);
				
			});
			console.log(chartdata);
			$('#container').highcharts({
				chart : {
					type : 'column'
				//column,bar,line
				},
				title : {
					text : 'Traffic'
				},
				xAxis : {
					type: 'category',
					labels: {
			            rotation: -45,
			            style: {
			                fontSize: '13px',
			                fontFamily: 'Verdana, sans-serif'
			            }
			        }
				},
				yAxis : {
					min: 0,
					title : {
						text : "traffic"
					}
				},
				legend: {
			        enabled: false
			    },
			    plotOptions: {
			        series: {
			            cursor: 'pointer',
			            events: {
			                click: function (e) {
			                	window.location.href='/exam0304/traffic.load?idx='+e.point.x;
// 			                    		e.point.x
			                }
			            }
			        }
			    },
				series : [ {
					name : 'traffic',
					colorByPoint : true,
					data : 
						chartdata
					,
			        dataLabels: {
			            enabled: true,
			            rotation: -90,
			            color: '#FFFFFF',
			            align: 'right',
			            format: '{point.y:.1f}', // one decimal
			            y: 10, // 10 pixels down from the top
			            style: {
			                fontSize: '13px',
			                fontFamily: 'Verdana, sans-serif'
			            }
			        }

				} ]

			});
		});
		
// 		(function (H) {
// 		    H.addEvent(H.Chart, 'load', function (e) {
// 		        var chart = e.target;
// 		        H.addEvent(chart, 'click', function (e) {
// 		            e = chart.series.toString;
// 		            console.log('Clicked chart at ' + e.);
// 		        });
		  
// 		    });
// 		}(Highcharts));
		
	});
</script>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
</head>
<body>
	<div id="wrap">
		<div id="header">
			<ul>
				<li><a href="/">Home</a>|</li>
				<li><c:choose>
						<c:when test="${sessionScope.uid==null }">
							<a href="loginForm">로그인</a>
						</c:when>
						<c:otherwise>
						${sessionScope.uname }님 <a href="logout">로그아웃</a>
						</c:otherwise>
					</c:choose> |</li>
				<li><c:choose>
						<c:when test="${sessionScope.uid == null }">
							<a href="member">회원가입</a>
						</c:when>
						<c:otherwise>
							<a href="mypage">마이페이지</a>
						</c:otherwise>
					</c:choose> |</li>
				<li><a href="">부서리스트</a>|</li>
				<li><a href="">사원리스트</a>|</li>
				<li>IP:</li>
			</ul>
		</div>
		<div id="content">메인페이지 내용입니다.</div>
		<br>

		<div id="container" style="width: 100%; height: 400px;"></div>

		<!-- 		<p><a href="/imgview"></a></p> -->
		<div id="footer">
			<ul>
				<li>개인정보 보호정책</li>
				<li>회사소개</li>
				<li>사이트맵</li>
			</ul>
		</div>
	</div>

</body>
</html>