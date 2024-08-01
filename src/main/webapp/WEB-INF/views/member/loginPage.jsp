<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="/resources/static/css/loginform.css">
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<div class="wrapper">
    <div class="container">
        <h1>로그인</h1>
        <form class="login-form" action="/member/auth" method="post">
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" required autocomplete="email">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" required autocomplete="password">
            </div>
            <button type="submit" id="loginButton">로그인</button>
        </form>
    </div>
</div>
</body>
<script>
    $(document).ready(function() {
        $('.login-form').on('submit', function(event) {
            event.preventDefault(); // 기본 폼 제출 동작 방지

            $.ajax({
                url: $(this).attr('action'),
                type: $(this).attr('method'),
                data: $(this).serialize(),
                success: function(response) {
                    // 로그인 성공 시 리다이렉션
                    window.location.href = '/';
                },
                error: function(jqXHR) {
                    // 서버에서 전송한 오류 메시지를 alert로 표시
                    var responseJson = JSON.parse(jqXHR.responseText);
                    alert(responseJson.error); // 서버의 응답 본문을 alert로 표시
                }
            });
        });
    });
</script>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>