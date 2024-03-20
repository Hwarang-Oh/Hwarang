<%@ page language="java" 
	info="이 JSP 파일은 정말 중요한 XXX 정보"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 주석으로 넣어두면 -> 커서를 두면 확인이 되버림 => info 정도로 처리 가능! -->
<%
String name = request.getParameter("username");
String pwd = request.getParameter("userpwd");
String[] fruit = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= name %>(<%= pwd %>)님이 좋아하는 과일은
<%
if (fruit != null) {
	for (int i = 0 ; i < fruit.length ; i++) {
%>
<%= fruit[i] %>,
<%	
	}
} else {
%>
업습니다.
<%
}
%>
</body>
</html>