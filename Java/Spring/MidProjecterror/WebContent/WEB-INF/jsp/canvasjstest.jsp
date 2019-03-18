<!DOCTYPE HTML>
<html>
<head>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
  <script src="lib/jquery/jquery.min.js"></script>
<script type="text/javascript">

window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "My First Chart in CanvasJS"              
		},
		data: [              
		{
			// Change type to "doughnut", "line", "splineArea", etc.
			type: "column",
			dataPoints: [
				{ label: "apple",  y: 10  },
				{ label: "orange", y: 15  },
				{ label: "banana", y: 25  },
				{ label: "mango",  y: 30  },
				{ label: "grape",  y: 28  }
			]
		}
		]
	});
	chart.render();
	
	$('#btn').on('click',function(e){
		console.log('test');
		chart = new CanvasJS.Chart("chartContainer", {
			title:{
				text: "My First Chart in CanvasJS"              
			},
			data: [              
			{
				// Change type to "doughnut", "line", "splineArea", etc.
				type: "column",
				dataPoints: [
					{ label: "blue",  y: 10  },
					{ label: "hehe", y: 15  },
					{ label: "banana", y: 25  },
					{ label: "mango",  y: 30  },
					{ label: "grape",  y: 28  }
				]
			}
			]
		});
		chart.options.data[0].type = "line";
		
		chart.render();
		
	});
}


</script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 400px;"></div>
<div id="btnline">
<input type="button" id="btn"></div>
</body>
</html>