<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SampleList</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<div style="display:table; margin:0 auto;">
		<h1>sampleList</h1>
		<table class="table table-responsive table-hover">
			<thead>
				<tr>
					<td>SAMPLE NO</td>
					<td>SAMPLE ID</td>
					<td>SAMPLE PW</td>
					<td>DELETE</td>
					<td>UPDATE</td>
				</tr>
			</thead>
			<tbody>
				<!-- model안의 sampleList 가져와서 사용 -->
				<c:forEach var="sample" items="${sampleList}">
					<tr>
						<td>${sample.sampleNo }</td>
						<td>${sample.sampleId }</td>
						<td>${sample.samplePw }</td>
						<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo }">DELETE</a></td>
						<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo }">UPDATE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>