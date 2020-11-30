<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	pwChkBool = false;
	function daumPost() {
	new daum.Postcode({
		oncomplete: function(data) {
				var addr = ""
				if (data.userSelectType === 'R') {
					addr = data.roadAddress
				} else {
					addr = data.jibunAddress
				}
				document.getElementById('addr1').value = addr
				document.getElementById('postNum').value = data.zonecode
			}
		}).open();
	}
	
	function passCheck() {
		var pw1 = document.getElementById('pw1').value
		var pw2 = document.getElementById('pw2').value
		var fontPwc = document.getElementById('PwCheckfont')
		if (pw1 === pw2) {
			fontPwc.style.color = 'blue'
			document.getElementById('PwCheckfont').innerHTML = "비밀번호가 일치합니다"
			pwChkBool = true
		} else {
			fontPwc.style.color = 'red'
			document.getElementById('PwCheckfont').innerHTML = "비밀번호가 일치하지 않습니다"
		}
	}
	
	function submitF() {
		//id, pw1, pw2, addr1, addr2가 하나라도 입력되지 않는다면 경고창으로 알림
		var id = document.getElementById('id').value
		var pw1 = document.getElementById('pw1').value
		var pw2 = document.getElementById('pw2').value
		var addr1 = document.getElementById('addr1').value
		var addr2 = document.getElementById('addr2').value
		if ( id === '') {
			alert("id항목은 반드시 입력하셔야 합니다.")
			return
		} else if (pw1 === '' || pw2 === '') {
			alert("비밀번호 항목은 반드시 입력하셔야 합니다.")
			return
		} else if (addr1 === '' || addr2 === '') {
			alert("주소 항목은 반드시 입력하셔야 합니다.")
			return
		} 
		var addrSum = document.getElementById('addr3').value
		addrSum = addr1 + " " +addr2
		console.log('주소확인' + addrSum)
		document.getElementById('addr3').value = addrSum
		//pw1,pw2 가 일치하지 않는다면 경고창 알림
		if (pwChkBool == true) {
			fo.submit()
		} else {
			alert("비밀번호 일치 확인을 해주세요")
			return
		}
	}
</script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	
		<div style="width: 300px; margin: 0 auto;">
		<div style="text-align: center; padding-top: 10px;">
			<font style="font-size: 25px; font-weight: bold;"> 회원가입 </font>
		</div>
		<hr>
		<form id="fo" action="registerChk" method="post">
			아이디<br> 
			<input type="text" id = "id" name="id" placeholder="아이디 입력" style="width: 98%"><br>
			비밀번호<br> 
			<input type="password" id = "pw1" name="pw" placeholder="비밀번호 입력" style="width: 98%"><br>
			비밀번호 확인<br>
			<input type="password" id = "pw2" placeholder="비밀번호 확인" onchange="passCheck()" style="width: 98%">
			<br><font id ="PwCheckfont"> </font><br>
			<input type="text" id ="postNum"  placeholder="우편번호" readonly style="width: 90px;">
			<input type="button" value="주소 입력" onclick="daumPost()">
			<input type="text" id = "addr1"  placeholder="주  소" readonly style="width: 98%"><br>
			<input type="text" id = "addr2"  placeholder="상세주소" style="width: 98%">
			<input type="text" id = "addr3" name="addr" hidden="hidden">
			<hr>
			<div style="text-align: center;">
			<input type="button" value="회원가입" onclick="submitF()" style="width: 100%; background-color: #80dfff; color:white; border-color: white; font-size: 20px;">
			</div>
			
		</form>
		</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>