<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- header.jsp -->
<header>
    <h1 class="mainH1">
        <a href="/">Shaping</a>
    </h1>
   <nav class="header-nav">
    <c:choose>
        <c:when test="${username != 'Guest' && not empty username}">
            <c:choose>
                  <c:when test="${userRole == 'ADMIN'}">
                    <p>관리자님, 로그인해주셔서 감사합니다!</p>
                    <a href="/admin/dashboard">대시보드</a>
                    <a href="/admin/manageUsers">사용자 관리</a>
                </c:when>
                <c:otherwise>
                    <p>${username}님, 로그인해주셔서 감사합니다!</p>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <p>Guest님 안녕하세요</p>
            <a href="/member/signUpForm">회원 가입</a>
            <a href="/member/loginPage">로그인</a>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty username && username != 'Guest'}">
        <a href="/member/logout">로그아웃</a>
    </c:if>
</nav>
</header>

<style>
    .mainH1 {
        font-size: 50px; /* 제목 글씨 크기 조정 */
        font-weight: bold;
        color: #2E3A4E; /* 제목 색상 설정 */
        margin: 0; /* 제목의 기본 여백 제거 */
        padding: 20px 0; /* 제목의 위아래 여백 추가 */
    }
    .mainH1 a {
        text-decoration: none; /* 링크의 밑줄 제거 */
        color: inherit; /* 링크 색상을 부모 요소와 동일하게 설정 */
    }
    /* 헤더 스타일 */
    header {
        background: #F0F9FC;
        height: 120px;
        color: #003366;
        padding: 20px;
        text-align: center;
        position: fixed; /* 헤더를 고정 */
        top: 0;
        left: 0;
        width: 100%;
        z-index: 500; /* 헤더가 다른 요소들 위에 표시되도록 설정 */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 헤더에 약간의 그림자 추가 */
    }

    /* 헤더 네비게이션 스타일 */
    .header-nav {
        display: flex;
        justify-content: flex-end; /* 네비게이션을 오른쪽으로 정렬 */
        align-items: center;
        gap: 15px; /* 링크들 사이의 간격 */
        margin-top: 0px;
        margin-right: 50px;
        padding: 0 20px; /* 좌우 여백 추가 */
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
    }

    .header-nav a:hover {
        text-decoration: underline;
    }
</style>