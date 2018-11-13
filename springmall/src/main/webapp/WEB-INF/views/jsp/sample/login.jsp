<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(()=>{
			$('#submitBtn').click(()=>{
				if($('#id').val().length > 3 && $('#pw').val().length > 3){
					$('#loginForm').submit();
				}
			});
			$('input').keypress((f)=>{
				console.log(f.keyCode);
				if(f.keyCode==13){
					$('#loginForm').submit();
				}
			});
		});
	</script>
	<title>Login</title>
</head>
<body>
	<div style="display:table; margin:0 auto;">
		<h1>Login</h1>
		<form id="loginForm" action="/sample/login" method="post">
			<table>
				<tr>
					<td><label for="id">ID</label></td>
					<td><input class="form-control" name="sampleId" id="id" autofocus required></td>
				</tr>
				<tr>
					<td><label for="pw">PW</label></td>
					<td><input class="form-control" name="samplePw" id="pw" required></td>
				</tr>
				<tr>
					<td colspan="2"><button id="submitBtn" class="btn btn-primary" type="button">로그인</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>