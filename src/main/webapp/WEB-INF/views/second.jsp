<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First JSP</title>
</head>
<body>
<h1>
	Hello first JSP!  
</h1>
<div>My first jsp - ${firstJspValue}</div>

<form name="form1" method="post" action="second">
 Введите текст:<br />
 <textarea name="text" cols="80" rows="10"></textarea>
 <input name="" type="submit" value="Отправить"/>
 </form>


</body>
</html>