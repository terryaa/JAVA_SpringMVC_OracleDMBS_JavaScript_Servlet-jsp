


<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spline Chart | CanvasJS Chart using Spring Web MVC</title>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="/assets/css/style.css" rel="stylesheet">
<!-- scripts -->
<script src="/assets/script/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="/assets/script/bootstrap.min.js"	type="text/javascript"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="/assets/script/html5shiv.min.js"></script>
      <script src="/assets/script/respond.min.js"></script>
    <![endif]-->
<script src="https://canvasjs.com/assets/script/canvasjs.min.js" type="text/javascript"></script>
<script>
	$(function() {
		// #sidebar-toggle-button
		$('#sidebar-toggle-button').on('click', function() {
			$('#sidebar').toggleClass('sidebar-toggle');
			$('#page-content-wrapper').toggleClass('page-content-toggle');
			fireResize();
		});

		// sidebar collapse behavior
		$('#sidebar').on('show.bs.collapse', function() {
			$('#sidebar').find('.collapse.in').collapse('hide');
		});

		// To make current link active
		(function addActiveToNestedList () {
			var pageURL = $(location).attr('href');
			var URLSplits = pageURL.split('/');
		
			
			var routeURL = '/' + URLSplits[URLSplits.length - 2] + '/' + URLSplits[URLSplits.length - 1];
			var activeNestedList = $(
					'.sub-menu > li > a[href$="' + routeURL + '"]').parent();
			
			if (activeNestedList.length !== 0
					&& !activeNestedList.hasClass('active')) {
				$('.sub-menu > li').removeClass('active');
				activeNestedList.addClass('active');
			}
		})();

		function fireResize() {
			if (document.createEvent) { // W3C
				var ev = document.createEvent('Event');
				ev.initEvent('resize', true, true);
				window.dispatchEvent(ev);
			} else { // IE
				element = document.documentElement;
				var event = document.createEventObject();
				element.fireEvent("onresize", event);
			}
		}

	})
</script>
</head>

<body>
	<!-- header -->
	<nav id="header" class="navbar navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<div id="sidebar-toggle-button">
				<i class="fa fa-bars" aria-hidden="true"></i>
			</div>
			<div class="brand">
				<a href="/"> CanvasJS Examples <span
					class="hidden-xs text-muted">SPRING WEB MVC</span>
				</a>
			</div>
		</div>
	</div>
</nav>

	<!-- /header -->

	<!-- sidebar -->
	
<div id="sidebar" class="sidebar-toggle">
	<ul class="nav nav-sidebar">
		<li><a href="/"> <i class="fa fa-home" aria-hidden="true"></i>
				<span>HOME</span>
		</a></li>
		<li role="separator" class="divider"></li>
		<!-- chart types -->
		<li data-toggle="collapse" href="#chart-types" aria-expanded="false"
			aria-controls="chart-types"><a href="#"> 
			<i class="fa fa-area-chart" aria-hidden="true"></i><span>CHART TYPES</span>
		</a></li>
		<li>
			<ul id="chart-types" class="sub-menu collapse in">
				<li><a href="/chart-types/column">Column Chart</a></li>
				<li><a href="/chart-types/line">Line Chart</a></li>
				<li><a href="/chart-types/step-line">Step Line Chart</a></li>
				<li><a href="/chart-types/spline">Spline Chart</a></li>
				<li><a href="/chart-types/step-area">Step Area Chart</a></li>
				<li><a href="/chart-types/area">Area Chart</a></li>
				<li><a href="/chart-types/spline-area">Spline Area Chart</a></li>
				<li><a href="/chart-types/bar">Bar Chart</a></li>
				<li><a href="/chart-types/pie">Pie Chart</a></li>
				<li><a href="/chart-types/doughnut">Doughnut Chart</a></li>
				<li><a href="/chart-types/bubble">Bubble Chart</a></li>
				<li><a href="/chart-types/scatter">Scatter Chart</a></li>
				<li><a href="/chart-types/stacked-column">Stacked Column Chart</a></li>
				<li><a href="/chart-types/stacked-column100">Stacked Column 100% Chart</a></li>
				<li><a href="/chart-types/stacked-area">Stacked Area Chart</a></li>
				<li><a href="/chart-types/stacked-area100">Stacked Area 100% Chart</a></li>
				<li><a href="/chart-types/stacked-bar">Stacked Bar Chart</a></li>
				<li><a href="/chart-types/stacked-bar100">Stacked Bar 100% Chart</a></li>






			</ul>
		</li>
		<!-- /chart types -->
		<li role="separator" class="divider"></li>
		<!--  features -->
		<li data-toggle="collapse" href="#features" aria-expanded="false"
			aria-controls="features"><a href="#"> <i class="fa fa-flask"
				aria-hidden="true"></i> <span>FEATURES</span>
		</a></li>
		<li>
			<ul id="features" class="sub-menu collapse ">
				<li><a href="/features/zooming-panning">Zooming &amp; Panning</a></li>
				<li><a href="/features/export-chart">Export Chart as Image</a></li>
				<li><a href="/features/events-handling">Event Handling</a></li>
				<li><a href="/features/log-axis">Logarithmic Axis</a></li>
				<li><a href="/features/date-time">Date-Time Axis</a></li>
				<li><a href="/features/reverse-axis">Reverse Axis</a></li>
				<li><a href="/features/striplines">StripLines</a></li>
				<li><a href="/features/multiple-y-axis">Multiple Y Axis</a></li>
				<li><a href="/features/multi-series-chart">Multiseries Charts</a></li>
			</ul>
		</li>
		<!--  /features -->
		<li role="separator" class="divider"></li>
		<!--  how to  -->
		<li data-toggle="collapse" href="#how-to" aria-expanded="false"
			aria-controls="how-to"><a href="#"> <i class="fa fa-wrench"
				aria-hidden="true"></i> <span>HOW TO</span>
		</a></li>
		<li>
			<ul id="how-to" class="sub-menu collapse ">
				<li><a href="/how-to/enable-disable-ds">Hide / Show DataSeries</a></li>
                <li><a href="/how-to/live-chart">Dynamic / Live Chart</a></li>
                <li><a href="/how-to/sync-multiple-charts">Sync Multiple Charts</a></li>
                <li><a href="/how-to/datapoints-from-user-input">Add Data Points From User Input</a></li>
                <li><a href="/how-to/multiple-charts-in-a-page">Multiple Charts in a Page</a></li>
                <li><a href="/how-to/play-stop-live-chart">Play / Stop Live Chart</a></li>
                <li><a href="/how-to/create-chart-from-json">Charts using JSON &amp; AJAX</a></li>
                <li><a href="/how-to/create-chart-from-xml">Charts using XML &amp; AJAX</a></li>
                <li><a href="/how-to/create-chart-from-csv">Charts using CSV &amp; AJAX</a></li>
                <li><a href="/how-to/data-from-database">Render Data From Database</a></li>
			</ul>
		</li>
		<!--  /how to  -->
		<li role="separator" class="divider"></li>
	</ul>
</div>
	<!-- /sidebar -->

	<div id="page-content-wrapper" class="page-content-toggle">
		<div class="container-fluid">
			<h1>Spline Chart</h1>

			<div class="row">
				<div id="content" class="col-md-8 col-md-offset-1 col-xs-12">
					



<div id='chartContainer'></div>



<script type="text/javascript">

   $(function () {
       var chart = new CanvasJS.Chart("chartContainer", {
           theme: "light2",
           animationEnabled: true,
           title: {
               text: "Analysis of Pepper Export - India"
           },
           axisX: {
               title: "Year"
           },
           axisY: {
               title: "In Tonnes"
           },

           data: [
           {
               type: "spline",
               dataPoints: [{"y":17363,"label":"2005-06"},{"y":28726,"label":"2006-07"},{"y":35000,"label":"2007-08"},{"y":25250,"label":"2008-09"},{"y":19750,"label":"2009-10"},{"y":18850,"label":"2010-11"},{"y":26700,"label":"2011-12"},{"y":16000,"label":"2012-13"},{"y":19000,"label":"2013-14"},{"y":18000,"label":"2014-15"}]
           }
           ]
       });

       chart.render();
   });
</script></div>
			</div>
			<!-- /row -->
		</div>

		<!-- footer -->
		<div id="footer">
	<p class="text-muted">&#169; 2017 fenopix</p>
</div>

		<!-- /footer -->
	</div>
</body>
</html>