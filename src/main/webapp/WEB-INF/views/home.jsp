<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!--
이미지나 파일은 여기에 넣고 읽어오는 경로는 src/main/resources에 넣어준다.
경로는 . /storeOpen/resources/이미지이름 로 하면된다. 
경로는 servlet-context.xml 에 resources 에 지정되어 있다. 
경로 추가는 servlet-context.xml 에 resource 경로를 추가해주면 된다. 

 -->
 
 <!-- 한글 추가
	web.xml에 한글 필터 추가하면 됨.
  -->
</body>
</html>
