<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<title>Document</title>
		<script src="https://kit.fontawesome.com/0eb5e3b5fa.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
		<script>
			function check() {
				if (document.joinForm.email.value == '') {
					alert('이메일을 입력하세요');
					document.joinForm.email.focus();
					return false;
				}
				if (document.joinForm.psw.value == '') {
					alert('PASSWORD를 입력하세요');
					document.joinForm.psw.focus();
					return false;
				}
				if (document.joinForm.pswchk.value == '') {
					
					alert('PASSWORD 확인을 입력하세요');
					document.joinForm.pswchk.focus();
					return false;
				}
				else if(document.joinForm.pswchk.value != document.joinForm.psw.value) {
					alert('PASSWORD가 서로 다릅니다');
					document.joinForm.pswchk.focus();
					return false;
				}
				if (document.joinForm.usrnm.value == '') {
					alert('이름을 입력하세요');
					document.joinForm.usrnm.focus();
					return false;
				}
				if (document.joinForm.phone.value == '') {
					alert('휴대폰번호를 입력하세요');
					document.joinForm.phone.focus();
					return false;
				}
				document.joinForm.submit();
			}
		</script>
		<script>
			$(document).ready(function() {

				//email Check
				$('#email').blur(function() {
					var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
					var email = $('#email').val();
					if ($('#email').val().length==0) {
						$('#emailcheck').html('이메일주소를 입력 해 주세요');
						return false;
					} 
					else if(!regExp.test(email)){
						$('#emailcheck').html('이메일유형이 올바르지 않습니다.');
						return false;
					}
					else {
						$('#emailcheck').html('');
					}
				});

				// pwd Check
				$('#pwd').blur(function() {
					var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/i;
					var pwd = $('#pwd').val();
					if ($('#pwd').val().length<8) {
						$('#pwdcheck').html('8자리이상 입력해주세요');
						return false;
					} 
					else if(!regex.test(pwd)){
						$('#pwdcheck').html('비밀번호는 특수문자 / 문자 / 숫자 포함 형태의 8~15자리');
						return false;
					}
					else {
						$('#pwdcheck').html('');
						return true;
					}
				});
				$('#pwdre').blur(function(){
					var pwd = $('#pwd').val();
					var pwdre = $('#pwdre').val();
					if($('#pwd').val()==$('#pwdre').val()){
						$('#pwdrecheck').html('');
						return true;
					}
					else{
						$('#pwdrecheck').html('비밀번호가 다릅니다');
					}
				});
				$('#name').blur(function(){
					if($('#name').val().length==0){
						$('#namecheck').html('이름을 입력하세요');
						return false;
					}else{
						$('#namecheck').html('');
						return true;
					}
				});

				$('#phone').blur(function(){
					var phoneExp = /^\d{3}-\d{3,4}-\d{4}$/;
					var phone = $('#phone').val();
					if ($('#phone').val().length==0) {
						$('#phonecheck').html('휴대폰번호를 입력해주세요');
						return false;
					} 
					else if(!phoneExp.test(phone)){
						$('#phonecheck').html('잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.');
						return false;
					}
					else {
						$('#phonecheck').html('');
						return true;
					}
				});
			});
		</script>

		<style>
			* {
				box-sizing: border-box;
			}
			form img {
				width: 200px;
				height: 60px;
				display: block;
				margin: 10px auto;
				margin-top: 50px;
			}
			.input-container {
				display: -ms-flexbox; /* IE10 */
				display: flex;
				width: 100%;
				margin-bottom: 15px;
			}

			.icon {
				padding: 10px;
				background:rgba(169, 169, 169, 0.1);
				color: #ccc;
				border: 1px solid #ccc;
				border-right: none;
				min-width: 50px;
				text-align: center;
			}

			.input-field {
				width: 100%;
				padding: 10px;
				outline: none;
			}

			.input-field:focus {
				border: 2px solid dodgerblue;
			}

			.btn {
				background-color: dodgerblue;
				color: white;
				padding: 15px 20px;
				border: none;
				cursor: pointer;
				width: 100%;
				opacity: 0.9;
			}
			.footer {
				text-align: center;
			}

			.btn:hover {
				opacity: 1;
			}
		</style>
	</head>
	<body>
		<form name="joinForm" action="Practice01" method="POST" onsubmit="return check()" style="max-width:500px;margin:auto;">
			<img src="coupang_logo.PNG" alt="coupang" class="coupanglogo" />

			<div class="input-container">
				<i class="far fa-envelope icon"></i>
				<input id="email" class="input-field" type="text" placeholder="아이디(이메일)" name="email" />
			</div>
			<div id="emailcheck"></div>

			<div class="input-container">
				<i class="fas fa-key icon"></i>
				<input id="pwd" class="input-field" type="password" placeholder="비밀번호(영문 숫자 특수문자 2가지 이상 8~16자 이내)" name="psw" />
			</div>
			<div id="pwdcheck"></div>

			<div class="input-container">
				<i class="fas fa-key icon"></i>
				<input id="pwdre" class="input-field" type="password" placeholder="비밀번호 확인" name="pswchk" />
			</div>
			<div id="pwdrecheck"></div>

			<div class="input-container">
				<i class="far fa-user icon"></i>
				<input id="name" class="input-field" type="text" placeholder="이름" name="usrnm" />
			</div>
			<div id="namecheck"></div>

			<div class="input-container">
				<i class="fas fa-mobile-alt icon"></i>
				<input id="phone" class="input-field" type="text" placeholder="휴대폰 번호" name="phone" />
			</div>
			<div id="phonecheck"></div>

			<button type="submit" class="btn">동의하고 가입하기</button>
			<div><p>본인은 만 14세 이상이며, 쿠팡 이용약관, 전자금융거래이용약관, 개인정보 수집 및 이용, 개인정보 제공 내용을 확인 하였으며, 동의합니다.</p></div>
		</form>

		<div class="footer">&copy;Coupang Corp. All rights reserved.</div>
	</body>
</html>
