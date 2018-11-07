<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>AddSample</title>
</head>
<body>
	<div style="display:table; margin:0 auto;">
		<h1>AddSample</h1>
		<form action="/sample/addSample" method="post">
			<table class="table table-responsive table-hover">
				<tr>
					<td>Sample ID : </td><td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Sample PW : </td><td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">입력</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>