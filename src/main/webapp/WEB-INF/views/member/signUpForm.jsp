<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="kr">
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<form action="/member/signup" method="post">

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="tel">전화번호:</label>
    <input type="text" id="tel" name="tel" required>
    <br>
    <label for="sex">성별:</label>
    <select id="sex" name="sex" required>
        <option value="true">남성</option>
        <option value="false">여성</option>
    </select>
    <br>
    <button type="submit">Sign Up</button>
</form>
</body>
</html>