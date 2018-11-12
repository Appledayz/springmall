<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>SampleList</title>
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
			<tfoot>
				<tr>
					<td colspan="5">
						<div style="display:table; margin:0 auto;">
						<ul class="pagination">
							<c:if test="${lastPageButton>10 }">
								<li class="page-item"><a class="page-link" href="/sample/sampleList?page=1"><<</a></li>
							</c:if>
							<c:if test="${lastPageButton>10 }">
								<li class="page-item"><a class="page-link" href="/sample/sampleList?page=${firstPageButton-1 }"><</a></li>
							</c:if>
							<c:forEach var="i" begin="${firstPageButton }" end="${lastPageButton }" step="1">
								<c:if test="${i!=currentPage }">
									<li class="page-item"><a class="page-link" href="/sample/sampleList?page=${i}">${i}</a></li>
								</c:if>
								<c:if test="${i==currentPage }">
									<li class="page-item active"><a class="page-link">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${lastPageButton<lastPage }">
								<li class="page-item"><a class="page-link" href="/sample/sampleList?page=${lastPageButton+1 }">></a></li>
							</c:if>
							<c:if test="${lastPageButton<lastPage }">
								<li class="page-item"><a class="page-link" href="/sample/sampleList?page=${lastPage }">>></a></li>
							</c:if>
						</ul>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>	
	</div>
</body>
</html>