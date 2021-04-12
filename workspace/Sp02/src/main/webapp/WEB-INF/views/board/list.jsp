<%@page import="min.md.domain.Board"%>
<%@ page contentType="text/html;charset=utf-8"
	import="java.util.*, min.md.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>Spring Board</title>
<meta charset="UTF-8">
<style>
a {
	text-decoration: none
}
</style>

<title>Insert title here</title>
</head>
<body>
	<center>
		<font color='gray' size='4' face='휴먼편지체'>
			<hr width='600' size='2' color='gray' noshade>
			<h3>Spring Board</h3> <font color='gray' size='4' face='휴먼편지체'>
				<a href='../'>인덱스</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href='write.do'>글쓰기</a><br />
		</font>
			<hr width='600' size='2' color='gray' noshade>

			<table border='2' width='600' align='center' noshade>
				<tr size='2' align='center' noshade bgcolor='AliceBlue'>
					<th bgcolor='AliceBlue'>no</th>
					<th color='gray'>writer</th>
					<th color='gray'>e-mail</th>
					<th color='gray'>subject</th>
					<th color='gray'>content</th>
					<th color='gray'>date</th>
					<th color='gray'>read</th>
				</tr>

				<c:if test="${empty list}">
					<tr>
						<td align='center' colspan="7">데이터가 하나도 없음</td>
					</tr>
				</c:if>

				<c:forEach items="${list}" var="board">
					<tr>
						<td align='center'>${board.seq}</td>
						<td>${board.writer}</td>
						<td>${board.email}</td>
						<td>${board.subject}</td>
						<td>${board.content}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.rdate}" /></td>
						<td align='center'><a href="content.do?seq=${board.seq}">자세히읽기</a>
					</tr>
				</c:forEach>


			</table>&nbsp;&nbsp;&nbsp;
			<div class='pull-right'>
				<hr width='600' size='2' color='gray' noshade>
				<font color='gray' size='3' face='휴먼편지체'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<a href="list.do?pageNum=${pageMaker.startPage-1}">이전</a>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="num">
							<c:out value="${pageMaker.cri.pageNum == num ? '' : ''}" />
							<a href="list.do?pageNum=${num}">${num}</a>
						</c:forEach>
						<c:if test="${pageMaker.next &&pageMaker.endPage>0}">
							<a href="${path}list.do?pageNum=${pageMaker.endPage +1}">다음</a>
						</c:if>
					</ul>
			</div> 3 </a>&nbsp; ( TOTAL : 9 ) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 페이지 싸이즈
			: <select id="psId" name="ps" onchange="f(this)">


				<option value="3" selected>3</option>
				<option value="5">5</option>
				<option value="10">10</option>




		</select> <script language="javascript">
			function f(select) {
				//var el = document.getElementById("psId");
				var ps = select.value;
				//alert("ps : " + ps);
				location.href = "list.do?ps=" + ps;
			}
		</script>

		</font>
		<hr width='600' size='2' color='gray' noshade>
	</center>
</body>
</html>