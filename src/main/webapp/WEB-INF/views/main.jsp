<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shaping</title>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/main.css"> <!-- CSS 파일 링크 -->
</head>
<%@ include file="header.jsp"%>
<body>

<main>
    <section class="content1">
        <div class="image-gallery">
            <label>
                <img src="/resources/static/images/blueTshirts.jpg" alt="Pants 1">
                <span>sample</span>
            </label>
            <label>
                <img src="/resources/static/images/pants.jpg" alt="Pants 2">
                <span>Pants 2</span>
            </label>
            <label>
                <img src="/resources/static/images/Shoes.jpg" alt="Pants 3">
                <span>Shoes</span>
            </label>
            <label>
                <img src="/resources/static/images/iphone 14PRO.jpg" alt="Pants 4">
                <span>iPhone 14 PRO</span>
            </label>
            <!-- 추가 이미지들 -->
        </div>
    </section>

    <div class="space"></div>

    <section>
        <div>filter</div>
    </section>
    <div class="space"></div>

    <section class="content2">
        <div class="image-gallery">
            <label>
                <img src="/resources/static/images/blueTshirts.jpg" alt="Pants 1">
                <span>sample</span>
            </label>
            <label>
                <img src="/resources/static/images/pants.jpg" alt="Pants 2">
                <span>Pants 2</span>
            </label>
            <label>
                <img src="/resources/static/images/Shoes.jpg" alt="Pants 3">
                <span>Shoes</span>
            </label>
            <label>
                <img src="/resources/static/images/iphone 14PRO.jpg" alt="Pants 4">
                <span>iPhone 14 PRO</span>
            </label>
            <!-- 추가 이미지들 -->
        </div>
    </section>
</main>
</body>
<%@ include file="footer.jsp"%>
</html>