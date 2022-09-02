<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>text 입력</title>
</head>
<body>
		<!-- 프린트컨트롤러로에서 GET방식으로 form을 켜줍니다. -->
		<!-- 그리고 텍스트를 써서 post방식으로 print에 전달합니다. -->
	 <form method="post" >
		<input type="text" name="param"/>
		<input type="submit" />
	</form>
</body>
</html>