<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="/css/admin-dashboard.css"> <!-- 스타일 시트 링크 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery 추가 -->
    <style>
        /* 기본 스타일 설정 */
        body {
            font-family: 'Montserrat', sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            min-height: 100vh; /* 최소 높이 설정 */
        }

        /* 헤더 스타일 */
        .header {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
            position: fixed;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1000;
        }

        .header a {
            color: #fff;
            text-decoration: none;
            margin-left: 15px;
        }

        .header a:hover {
            text-decoration: underline;
        }

        /* 메인 영역 스타일 */
        main {
            display: flex;
            flex: 1;
            margin-top: 80px; /* 헤더 높이만큼 위 여백 추가 */
        }

        /* 사이드바 스타일 */
        .sidebar {
            width: 120px; /* 고정된 너비 설정 */
            height: 180px;
            background-color: #fff;
            padding: 15px;
            margin-top: 100px;
            margin-left: 20px;
            box-shadow: 2px 0 5px rgba(0,0,0,0.1);
            text-align: center;
            position: fixed; /* 화면 왼쪽에 고정 */
            overflow-y: auto; /* 스크롤 가능하도록 설정 */
        }

        .menu-item {
            margin: 10px 0;
            font-size: 18px;
        }

        .menu-item a {
            text-decoration: none;
            color: #333;
        }

        .menu-item a:hover {
            text-decoration: underline;
        }

        /* 컨텐츠 영역 스타일 */
        .content {
            flex: 1; /* 나머지 공간을 차지 */
            padding: 20px;
            margin-left: 180px; /* 사이드바의 너비만큼 여백 추가 */
            margin-top: 80px;
            background-color: #f4f4f4;
            overflow-y: auto; /* 컨텐츠도 스크롤 가능하도록 설정 */
            height: calc(100vh - 80px); /* 헤더를 제외한 전체 화면을 차지 */
        }

        .section {
            margin-bottom: 20px;
        }

        .section h4 {
            margin-bottom: 10px;
            border-bottom: 2px solid #333;
            padding-bottom: 5px;
        }

        .section-content {
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .table {
            width: 100%;
            border-collapse: collapse;
        }

        .table th, .table td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        .table th {
            background-color: #f4f4f4;
            text-align: left;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>

<main>
    <!-- 사이드바 -->
    <div class="sidebar">
        <div class="menu-item"><a href="/admin/users" class="ajax-link">어드민 관리</a></div>
        <div class="menu-item"><a href="/admin/products" class="ajax-link">상품 관리</a></div>
        <div class="menu-item"><a href="/admin/coupons" class="ajax-link">쿠폰 관리</a></div>
        <div class="menu-item"><a href="/admin/orders" class="ajax-link">주문 관리</a></div>
        <div class="menu-item"><a href="/admin/reports" class="ajax-link">Reports</a></div>
    </div>

    <!-- 컨텐츠 영역 -->
    <div class="content">
        <!-- 기본적으로 표시할 콘텐츠 -->
        <div class="section">
            <h4>Welcome to the Admin Dashboard</h4>
            <div class="section-content">
                <p>Select an option from the sidebar to manage different sections of the website.</p>
            </div>
        </div>
    </div>
</main>

<script>
    $(document).ready(function() {
        $('.ajax-link').on('click', function(e) {
            e.preventDefault();
            var url = $(this).attr('href');

            $.ajax({
                url: url,
                method: 'GET',
                success: function(response) {
                    $('.content').html(response);
                },
                error: function() {
                    alert('Content loading failed!');
                }
            });
        });
    });
</script>

</body>
</html>