<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="/css/admin-dashboard.css"> <!-- 스타일 시트 링크 -->
    <style>
        /* 기본 스타일 설정 */
        body {
            font-family: 'Montserrat', sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 2000px; /* 최소 높이 설정 */
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
            margin: 80px 20px 80px 20px; /* 헤더와 푸터의 높이만큼 여백 추가 */
            flex-direction: column;
            position: relative;
        }

        /* 사이드바 스타일 */
        .sidebar {
            margin-top: 100px;
            width: 250px;
            background-color: #fff;
            padding: 15px;
            box-shadow: 2px 0 5px rgba(0,0,0,0.1);
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
            flex: 1;
            padding: 20px;
            margin-left: 270px; /* 사이드바의 너비만큼 여백 추가 */
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

        /* 이미지 갤러리 스타일 */
        .image-gallery {
            display: flex;
            gap: 20px;
            justify-content: center;
            margin: 0;
            padding: 0;
        }

        .image-gallery label {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
        }

        .image-gallery img {
            width: 200px;
            height: 200px;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .image-gallery span {
            margin-top: 8px;
            font-size: 16px;
            color: #333;
        }

        .space {
            position: relative;
            padding-bottom: 20px;
            margin-bottom: 20px;
            border-bottom: 1px solid #eaeaea;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>

<main>
    <!-- 사이드바 -->
    <div class="sidebar">
        <div class="menu-item"><a href="/admin/users">어드민 관리</a></div>
        <div class="menu-item"><a href="/admin/products">상품 관리</a></div>
        <div class="menu-item"><a href="/admin/coupons">쿠폰 관리</a></div>
        <div class="menu-item"><a href="/admin/orders">주문 관리</a></div>
        <div class="menu-item"><a href="/admin/reports">Reports</a></div>
    </div>

    <!-- 컨텐츠 영역 -->
    <div class="content">
        <!-- 사용자 관리 섹션 -->
        <div class="section">
            <h4>Manage Users</h4>
            <div class="section-content">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>john_doe</td>
                        <td>john@example.com</td>
                        <td>USER</td>
                        <td><a href="/admin/users/edit/1">Edit</a> | <a href="/admin/users/delete/1">Delete</a></td>
                    </tr>
                    <!-- Repeat rows as needed -->
                    </tbody>
                </table>
            </div>
        </div>

        <!-- 제품 관리 섹션 -->
        <div class="section">
            <h4>Manage Products</h4>
            <div class="section-content">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>101</td>
                        <td>Product A</td>
                        <td>Category 1</td>
                        <td>$25.00</td>
                        <td>100</td>
                        <td><a href="/admin/products/edit/101">Edit</a> | <a href="/admin/products/delete/101">Delete</a></td>
                    </tr>
                    <!-- Repeat rows as needed -->
                    </tbody>
                </table>
            </div>
        </div>

        <!-- 쿠폰 관리 섹션 -->
        <div class="section">
            <h4>Manage Coupons</h4>
            <div class="section-content">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Code</th>
                        <th>Description</th>
                        <th>Discount</th>
                        <th>Expiry Date</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>DISCOUNT10</td>
                        <td>10% Off</td>
                        <td>10%</td>
                        <td>2024-12-31</td>
                        <td><a href="/admin/coupons/edit/DISCOUNT10">Edit</a> | <a href="/admin/coupons/delete/DISCOUNT10">Delete</a></td>
                    </tr>
                    <!-- Repeat rows as needed -->
                    </tbody>
                </table>
            </div>
        </div>

        <!-- 추가 섹션들 -->
    </div>
</main>
</body>
</html>