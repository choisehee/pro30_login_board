<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<table border=0 width="100%">
		<tr>
			<td width="15%"><a href="${contextPath}/main.do">
					<h1>회원가입과/게시판</h1>
			</a></td>
			 <td width="75%">
				<!-- <h1>
					<font color="#999999">스프링실습 홈페이지 입니다</font>
				</h1>
 -->
			</td>
 
			<td>
				<!-- <a href="#"><h3>로그인</h3></a> --> <c:choose>
					<c:when test="${isLogOn == true  && member!= null}">
						<h3>환영합니다. ${member.name }님!</h3>
						<a href="${contextPath}/member/logout.do"><h3>로그아웃</h3></a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do"><h3>로그인</h3></a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>


</body>
</html>