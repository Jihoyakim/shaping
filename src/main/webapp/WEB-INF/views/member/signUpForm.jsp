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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery 라이브러리 로드 -->
<link rel="stylesheet" href="/resources/static/css/signupform.css">

<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="wrapper">
    <div class="container">
        <h1>회원가입</h1>
        <div class="signup-form">
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" autocomplete="email" required/>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" autocomplete="password" required/>
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" autocomplete="name" required/>
            </div>
            <div class="form-group">
                <label for="tel">전화번호</label>
                <input type="tel" id="tel" name="tel" autocomplete="tel" required/>
            </div>
            <div class="form-group">
                <label for="sex">성별</label>
                <select id="sex" name="sex" required>
                    <option value="MALE">남성</option>
                    <option value="FEMALE">여성</option>
                </select>
            </div>
            <div class="form-group">
                <label for="address">주소</label>
                <span id="guide" style="color:#999;display:flex"></span>
                <div id="address" style="display: inline-block">
                    <input type="text" id="sample4_postcode" name="postcode" placeholder="우편번호"/>
                    <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"/><br>
                    <input type="text" id="sample4_roadAddress" name="roadAddress" placeholder="도로명주소"/>
                    <input type="text" id="sample4_jibunAddress" name="jibunAddress" placeholder="지번주소"/>
                    <input type="text" id="sample4_detailAdd" name="detailAdd" placeholder="상세 주소"/>
                </div>
            </div>
            <button id="signupButton">회원 가입</button>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>

<script>

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {

                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
               /* if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }*/

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

               /* // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }*/

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
    $(document).ready(function() {
        $('#signupButton').click(function(event) {
            event.preventDefault();

            var memberDto = {
                email: $('#email').val(),
                password: $('#password').val(),
                name: $('#name').val(),
                tel: $('#tel').val(),
                sex: $('#sex').val(),
                postcode: $('#sample4_postcode').val(),
                roadAddress: $('#sample4_roadAddress').val(),
                jibunAddress: $('#sample4_jibunAddress').val(),
                detailA: $('#sample4_detailAdd').val(),
            };

            $.ajax({
                type: 'POST',
                url: '/member/signup',
                contentType: 'application/json',
                data: JSON.stringify(memberDto),
                success: function(response) {
                    if (response.redirectUrl) {
                        alert(response.message); // 성공 메시지 표시
                        window.location.href = response.redirectUrl; // 서버에서 받은 리다이렉트 URL로 이동
                    } else {
                        console.error('리다이렉트 URL이 응답에 포함되어 있지 않습니다.');
                    }
                },
                error: function(xhr, status, error) {
                    console.error('AJAX 요청 실패:', error);
                }
            });
        });
    });
</script>
</html>
