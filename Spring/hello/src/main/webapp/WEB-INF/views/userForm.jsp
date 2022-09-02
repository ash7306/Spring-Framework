<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- model에 애드어튜리뷰트로 "user"객체로 추가함 -->
	<!-- 반대로 컨트롤러에 유저 객체에 넣은 값이 여기 값에 기본값으로 출력됨 -->
	<f:form modelAttribute="user" method="POST">
		<f:errors path="name"/><!-- name에 관한 에러 메세지 -->
		<f:input type="text" path="name"/>
		<f:errors path="age"/><!-- age에 관한 에러 메세지 -->
		<f:input type="number" path="age"/>
		<input type="submit" />
 	</f:form>
</body>
</html>