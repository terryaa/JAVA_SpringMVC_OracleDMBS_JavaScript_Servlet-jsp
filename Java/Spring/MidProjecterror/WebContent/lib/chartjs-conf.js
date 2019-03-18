var Script = function () {


    var doughnutData = [
        {
            value: 50,
            color:"#1abc9c"
        },
        {
            value : 30,
            color : "#2ecc71"
        },
        {
            value : 100,
            color : "#3498db"
        },
        {
            value : 40,
            color : "#9b59b6"
        },
        {
            value : 120,
            color : "#34495e"
        }

    ];
    var lineChartData = {
        labels : ["","","","","","",""],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
            },
            {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
            }
        ]

    };
    var pieData = [
        {
            value: 100,
            color:"#1abc9c"
        },
        {
            value : 30,
            color : "#16a085"
        },
        {
            value : 50,
            color : "#27ae60"
        }

    ];
	var DateObj = new Date(); 
	  
	var months = DateObj.getMonth(); 
	const monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"
		];
    let barChartData = {
    	
        labels : [monthNames[months-3],monthNames[months-2],monthNames[months-1]
        ,monthNames[months],monthNames[months+1],monthNames[months+2],monthNames[months+3]],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                data : [85,200,90,81,56,55,70]
            }
//            ,
//            {
//                fillColor : "rgba(151,187,205,0.5)",
//                strokeColor : "rgba(151,187,205,1)",
//                data : [28,48,40,19,96,27,100]
//            }
        ]

    };
    var chartData = [
        {
            value : Math.random(),
            color: "#D97041"
        },
        {
            value : Math.random(),
            color: "#C7604C"
        },
        {
            value : Math.random(),
            color: "#21323D"
        },
        {
            value : Math.random(),
            color: "#9D9B7F"
        },
        {
            value : Math.random(),
            color: "#7D4F6D"
        },
        {
            value : Math.random(),
            color: "#584A5E"
        }
    ];
    var radarChartData = {
        labels : ["","","","","","",""],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
            },
            {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
            }
        ]

    };
//    new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(doughnutData);
//    new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
//    new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
//    new Chart(document.getElementById("polarArea").getContext("2d")).PolarArea(chartData);
   let chart= new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
//    new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);

   $('#period a').on('click',function(e){
	   barchart.option.labels[0]='why';
	   barchart.option.labels[1]='not';
   });
//    $('#period a').on('click',function(e){
//    	let barChartData;
//		e.preventDefault();
//		var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
//		var months =["January", "February", "March", "April", "May", "June",
//			  "July", "August", "September", "October", "November", "December"];
//		
//		var selected=$(this).data('value');
//		var DateObj = new Date(); 
//		if(selected===0){
//			selected= DateObj.getDay(); 
//			barChartData = {
//			    	
//			        labels : [ days[selected-3],days[selected-2],days[selected-1]
//			        ,days[selected],days[selected+1],days[selected+2],days[selected+3]
//			        ],
//			        datasets : [
//			            {
//			                fillColor : "rgba(220,220,220,0.5)",
//			                strokeColor : "rgba(220,220,220,1)",
//			                data : [85,200,90,81,56,55,70]
//			            }
//			        ]
//
//			    };
//		} else if(selected===1){
//			selected=DateObj.getMonth(); 
//			barChartData = {
//			    	
//			        labels : [ months[selected-3],months[selected-2],months[selected-1]
//			        ,months[selected],months[selected+1],months[selected+2],months[selected+3]
//			        ],
//			        datasets : [
//			            {
//			                fillColor : "rgba(220,220,220,0.5)",
//			                strokeColor : "rgba(220,220,220,1)",
//			                data : [85,200,90,81,56,55,70]
//			            }
//			        ]
//
//			    };
//		} else{
//			selected=DateObj.getFullYear(); 
//			barChartData = {
//			    	
//			        labels : [ selected-6,selected-5,selected-4,selected-3,selected-2,selected-1,selected],
//			        datasets : [
//			            {
//			                fillColor : "rgba(220,220,220,0.5)",
//			                strokeColor : "rgba(220,220,220,1)",
//			                data : [85,200,90,81,56,55,70]
//			            }
//			        ]
//
//			    };
//		}
//		$('#periodbtn').html($(this).text()+"<span class='caret'></span>");
//	    new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
//	    $('#bar').css('width','400').css('height','300');
//	});

}();