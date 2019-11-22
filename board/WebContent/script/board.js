var check = new Array('/시발/','/시팔/','씨발','시발');
function boardCheck(){
	var checkValue = 0;
	if(document.frm.name.value.length == 0){
		alert("작성자를 써주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 써주세요");
		frm.pass.focus();
		return false;
	}
	if(document.frm.title.value.length==0){
		alert("제목을 써주세요");
		frm.title.focus();
		return false;
	}else{
		for(var i=0;i<check.length;i++){
			if(document.frm.title.value.match(check[i])){
				alert("dd");
				return false;
			}
		}
	}

	

	if(document.frm.content.value.length==0){
		alert("내용 입력하세요");
		frm.content.focus();
		return false;
	}else{
		for(var i=0;i<check.length;i++){
			if(document.frm.content.value.match(check[i])){
				alert("dd");
				return false;
			}
		}
	}
}

function open_win(url,name){
	window.open(url,name, "width=500,height=230");
}
function passCheck(){
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		return false;
	}
}
function deleteCheck(code){
	if(confirm("삭제 하시겠습니까?")==true){
		//opener.location="productDelete.do?code="+code;
		var url = "productDelete.do?code="+code;
		location = url;
	}
	else{
		return false;
	}
}
