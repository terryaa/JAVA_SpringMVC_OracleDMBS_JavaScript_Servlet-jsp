var days = [ 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday',
				'Saturday', 'Sunday' ];
		var months = [ "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November",
				"December" ];
		var date = new Date();
		var array = new Array();
		var period_selected=0;
		var log_selected=1;
		var x_axis=getSelected(period_selected);
		var y_axis=getSelected_Log_Data(log_selected,period_selected);

		
		
function start() {

	window.onload = function() {
		// 버튼 클릭시 실행할 함수
		// 나중에 y-axis에 들어갈 값도 배열형식으로 만들어 로드되는 값이 그래프에들어가도록수정.

		// 차트 initiate
		var chart = new CanvasJS.Chart("chartContainer", {

			animationEnabled : true,
			animationDuration : 1000,
			theme : "light2",
			title : {
				text : "총 방문자수"
			},
			axisY : {
				includeZero : false
			},
			// { label:days[0] ,y: 520, indexLabel: "highest",markerColor:
			// "red",
			// markerType: "triangle" },
			data : [ {
				type : "area",
				dataPoints : [ {
					label : x_axis[0],
					y : y_axis[0]
				}, {
					label : x_axis[1],
					y :y_axis[1]
				}, {
					label : x_axis[2],
					y : y_axis[2]
				}, {
					label : x_axis[3],
					y :y_axis[3]
				}, {
					label : x_axis[4],
					y :y_axis[4]
				} ]
			} ]
		});
		chart.render();

		// 기간 변경 버튼 listener
		$('#period a').on('click',function(e) {

					var select = $(this).data('value');
					x_axis = getSelected(select);
					chart.options.data[0].dataPoints = [ {
						label : x_axis[0],
						y : 400
					}, {
						label : x_axis[1],
						y : 300
					}, {
						label : x_axis[2],
						y : 100
					}, {
						label : x_axis[3],
						y : 150
					}, {
						label : x_axis[4],
						y : 500
					} ];
					chart.options.animationEnabled = true;
					$('#periodbtn').html(
							$(this).text() + "<span class='caret'></span>");
					chart.render();

				});
		// 그래프 타입 변경 버튼 listener
		$('#type a').on('click', function(e) {
			var selecttype = $(this).data('value');
			var charttype;
			if (selecttype == 0)
				charttype = 'column';
			else if (selecttype == 1)
				charttype = 'doughnut';
			else
				charttype = 'area';
			console.log(charttype);
			$('#typebtn').html($(this).text() + "<span class='caret'></span>");
			chart.options.data[0].type = charttype;
			chart.render();
		});

		// 통계 아이콘 클릭 listener
		// 이미지를 눌렀을때 그래프가 해당 통계의 그래프로 바뀌게 하는 로직

		$(".icon").click(function() {
			var test = $(this).attr("id");
			var header;
			if (test == "signupicon") {
				header = "총 가입수";
				log_selected=5;
			} else if (test == "watchicon") {
				header = "총 시청수";
				log_selected=4;
			} else if (test == "viewicon") {
				header = "총 조회수";
				log_selected=3;
			} else if (test == "moneyicon") {
				header = "총 판매액";
				log_selected=2;
			} else if (test == "usericon") {
				header = "총 로그인수";
				log_selected=1;
			}
			
			// 판권 이익은 그래프 다른형식으로뿌려야함.
			else {
				header = "판권 이익";
			}
			//y_axis에 선택된 로그의 데이터 업데이트
			getSelected_Log_Data(log_selected,period_selected);
			chart.options.data[0].dataPoints = [ {
				label : x_axis[0],
				y : y_axis[0]
			}, {
				label :  x_axis[1],
				y : y_axis[1]
			}, {
				label :  x_axis[2],
				y : y_axis[2]
			}, {
				label :  x_axis[3],
				y : y_axis[3]
			}, {
				label :  x_axis[4],
				y : y_axis[4]
			} ];
			chart.options.animationEnabled = true;

			chart.options.title.text = header;
			chart.render();

		});
	}
};
//선택된 기간을 판단하여 그래프에 표시될 기간 x축의 배열을 만들어 리턴함.
//요일,월,년의 결과를 x_axis에 할당하기위함.
function getSelected(selected) {
	var result;

	if (selected == 0) {
		result = date.getDay();
		for (var i = 0; i < 5; i++) {
			array[4 - i] = days[result - 1];
			if (0 == (--result)) {
				result = 6;
			}

		}
	} else if (selected == 1) {
		result = date.getMonth();
		for (var i = 0; i < 5; i++) {
			array[4 - i] = months[result];
			if (0 == (--result)) {
				result = 11;
			}
		}
	} else {
		result = date.getFullYear();
		for (var i = 0; i < 5; i++) {
			array[4 - i] = result;
			result--;
		}
	}
	return array;

};

function getSelected_Log_Data(log_selected,period_selected) {
	 $.ajax({
        url: "/MidProject2/getLogData"+log_selected+"?cmd="+period_selected,
        success: function (data,status) {
        	y_axis=data;
        },
        error:function(e){
            alert(e);
        }
    });
	 return y_axis;
};