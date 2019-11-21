<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입2</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <script>
        $(document).ready(function(){
            $("#introduce").on("keyup",function(){
                if($("#introduce").val().length>=150){
                    $("#introduce").val($("#introduce").val().substring(0,150));
                    alert("150글자를 넘길수 없습니다.");
                }
            });

            function check(){
            if(document.joinForm.id.value==""){
                alert("ID를 입력하세요");
                document.joinForm.id.focus();
                return;
            }

            if(document.joinForm.password.value==""){
                alert("PASSWORD를 입력하세요");
                document.joinForm.password.focus();
                return;
            }
            if(document.joinForm.name.value==""){
                alert("이름을 입력하세요");
                document.joinForm.name.focus();
                return;
            }
            if(document.joinForm.name.value==""){
                alert("이메일을 입력하세요");
                document.joinForm.email.focus();
                return;
            }
            var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
            if(!emailRule.test(document.joinForm.email.value)) {            
                alert("이메일 형식이 잘못되었습니다.");
                document.joinForm.email.select();
                return;
            }
            document.joinForm.submit();
        }
    })
    </script>
</head>
<body>
    <h1>회원가입</h1>
    <form name="joinForm" action="practice04_info.jsp" method="post">
        id <input type="text" name="id"><br>
        pw <input type="password" name="password"><br>
        name <input type="text" name="name"><br>
        email <input type="text" name="email"><br>
        address <input type="text" name="address"><br>
        성별 <input type="radio" name="gender" value="m">남
            <input type="radio" name="gender" value="f">여<br>
        email수신 <input type="radio" name="emailReceive" value="y">예
            <input type="radio" name="emailReceive" value="n">아니오
            <br>
        취미 <input type="checkbox" name="hobby" value="독서">독서
            <input type="checkbox" name="hobby" value="영화">영화감상
            <input type="checkbox" name="hobby" value="운동">운동
            <input type="checkbox" name="hobby" value="코딩">코딩
            <br>
        <label for="job">직업 </label>
        <select name="job" id="job">
                <option value="학생">학생</option>
                <option value="군인">군인</option>
                <option value="공무원">공무원</option>
                <option value="기타">기타</option>
         </select>
            <br>
        자기소개<br>
        <textarea name="introduce" rows="10" cols="50"></textarea>    
        <br>
    <input type="submit" value="등록" onclick="check()"><br>
        <!-- <input type="image" src="img/submit.png"><br>
        <button>등록</button>
        <button type="button">등록</button> -->
    </form>
</body>
</html>