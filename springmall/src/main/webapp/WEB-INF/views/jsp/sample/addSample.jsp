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
			$('#id').blur(()=>{
				if($('#id').val().length < 4){
					$('#idHelper').text('아이디를 4자 이상 입력하세요.');
				}else {
					$('#idHelper').text('');
				}
			});
			$('#pw').blur(()=>{
				if($('#pw').val().length < 4){
					$('#pwHelper').text('비밀번호를 4자 이상 입력하세요.');
				}else {
					$('#pwHelper').text('');
				}
			});
			$('#submitBtn').click(()=>{
				if($('#id').val().length > 3 && $('#pw').val().length > 3){
					$('#addSampleForm').submit();
				}
			});
		});
	</script>
	<title>AddSample</title>
</head>
<body>
	<div style="display:table; margin:0 auto;">
		<h1>AddSample</h1>
		<form id="addSampleForm" action="/sample/addSample" method="post" enctype="multipart/form-data">
			<table class="table table-responsive table-hover">
				<tr>
					<td><label for="id">Sample ID : </label></td>
					<td><input class="form-control" id="id" type="text" name="sampleId" autofocus required>
						<span id="idHelper"></span>
					</td>
				</tr>
				<tr>
					<td><label for="pw">Sample PW : </label></td>
					<td><input class="form-control" id="pw" type="password" name="samplePw" required>
						<span id="pwHelper"></span>
					</td>
				</tr>
				<tr>
					<td><label for="multipartFile">Sample File : </label></td>
					<td><input class="form-control" id="multipartFile" type="file" name="multipartFile">
						<span id="fileHelper"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><button id="submitBtn" class="btn btn-primary" type="button">입력</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>