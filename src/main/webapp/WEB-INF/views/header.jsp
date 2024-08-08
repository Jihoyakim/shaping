<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- header.jsp -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap">
<header>
    <div class="header-content">
        <h1 class="mainH1">
            <a href="/">SHAPING</a>
        </h1>
        <nav class="header-nav">
            <c:choose>
                <c:when test="${username != 'Guest' && not empty username}">
                    <c:choose>
                        <c:when test="${userRole == 'ROLE_ADMIN'}">
                            <p>관리자님, 로그인해주셔서 감사합니다!</p>
                            <a href="/admin/dashboard">대시보드</a>
                            <a href="/member/logout">로그아웃</a>
                        </c:when>
                        <c:otherwise>
                            <p>${username}님, 로그인해주셔서 감사합니다!</p>
                            <a href="/member/logout">로그아웃</a>
                            <a href="/checkRole" class="header-link"><i class="ghicon_member"></i> 마이페이지</a>
                            <a href="/session-info" class="header-link"><i class="ghicon_global1"></i> 고객센터</a>
                            <a href="/order/basket.html" class="header-link"><i class="ghicon_basket"></i> 장바구니</a>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <p>Guest님 안녕하세요</p>
                    <a href="/member/signUpForm">회원 가입</a>
                    <a href="/member/loginPage">로그인</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</header>

<style>
    header {
        background: #F0F9FC;
        color: #003366;
        padding: 20px;
        text-align: center;
        position: fixed; /* 헤더를 고정 */
        top: 0;
        left: 0;
        width: 100%;
        z-index: 500; /* 헤더가 다른 요소들 위에 표시되도록 설정 */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 헤더에 약간의 그림자 추가 */
        display: flex;
        justify-content: center; /* 전체 헤더를 중앙 정렬 */
    }

    .header-content {
        display: flex;
        align-items: flex-start; /* 수직으로 중앙 정렬 */
        justify-content: space-between; /* 제목과 네비게이션을 양 끝으로 배치 */
        width: 100%; /* 전체 너비를 차지하도록 설정 */
        max-width: 100%; /* 최대 너비 설정 (필요에 따라 조정) */
        padding: 5px; /* 좌우 여백 추가 */
    }

    .mainH1 {
        font-size: 70px; /* 제목 글씨 크기 조정 */
        font-weight: bold;
        color: #2E3A4E; /* 제목 색상 설정 */
        margin: 0; /* 제목의 기본 여백 제거 */
        padding: 20px 0; /* 제목의 위아래 여백 추가 */
        font-family: 'Dancing Script', cursive;
        display: inline-block;
    }

    .mainH1 a {
        text-decoration: none; /* 링크의 밑줄 제거 */
        color: inherit; /* 링크 색상을 부모 요소와 동일하게 설정 */
    }

    /* 헤더 네비게이션 스타일 */
    .header-nav {
        display: flex;
        align-items: center;
        gap: 5px; /* 링크들 사이의 간격 */
        margin-right: 30px;
    }

    .header-nav p {
        color: #2E3A4E;
        font-weight: bold;
        margin: 0; /* 사용자 인사말의 기본 여백 제거 */
    }

    .header-nav a {
        color: #2E3A4E;
        text-decoration: none;
        font-weight: bold;
        padding: 5px 10px;
    }

    .header-nav a:hover {
        text-decoration: underline;
    }

    .header-link {
        display: flex;
        align-items: center;
    }

    .header-link i {
        margin-right: 5px;
    }
</style>