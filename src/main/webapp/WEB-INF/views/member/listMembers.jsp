<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    



<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
<style type="text/css">
#h1 {
	font-size: 18px;
	background-color: #CCFFFF;
}

#show {
	padding-bottom: 20px;
}

.tdtable {
	font-size: 13px;
}
</style>
</head>
<body>
	<table id="show" align="center" width="90%">
		<tr align="center" bgcolor="#FFFF99">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입일</b></td>
			<td><b>삭제</b></td>
			<td><b>수정</b></td>
		</tr>

		<c:forEach var="member" items="${membersList}">
			<tr align="center">
				<td class="tdtable">${member.id}</td>
				<td class="tdtable">${member.pwd}</td>
				<td class="tdtable">${member.name}</td>
				<td class="tdtable">${member.email}</td>
				<td class="tdtable">${member.joinDate}</td>
				<td class="tdtable"><a
					href="${contextPath}/member/removeMember.do?id=${member.id}">삭제하기</a></td>
				<td class="tdtable"><a
					href="${contextPath}/member/modMember.do?id=${member.id }">수정하기</a></td>

			</tr>
		</c:forEach>
	</table>


	<a id="h1" href="${contextPath}/member/memberForm.do">회원가입</a>

	<!-- <h1 class="h1" style="text-align:center">회원가입</h1> -->

</body>
</html>
