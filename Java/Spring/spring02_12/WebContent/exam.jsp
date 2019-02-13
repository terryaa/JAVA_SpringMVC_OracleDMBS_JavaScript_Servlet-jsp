<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>
   #wrap{
   width: 300px; margin: auto;
   background-color: orange;
   height: 200px;
   }
   #res{
      background-color: gray; 
      width: 80%; margin: auto;
   }
   #condition{ margin-left: 50px;}
</style>

<script>
   $(function() {
      $('#btn1').click(function() {
         var condition = $('#condition').val();
         $.ajax({
            url : "examdata2.jsp",
            data : {
               con : condition
            },
            success : function(data, status) {
               $('#res').html(data);
            },
            error : function(e) {
               alert(e);
            }
         });
      });
   });
</script>
</head>
<body>
   <div id="wrap">
      <select id="condition">
         <option>-선택하시오-</option>
         <option>type1</option>
         <option>type2</option>
         <option>type3</option>
      </select> <input type="button" value="send" id="btn1">
      <div id="res"></div>
   </div>
</body>
</html>