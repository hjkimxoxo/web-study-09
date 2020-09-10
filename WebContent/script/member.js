function loginCheck() {
	if (document.frm.userId.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userId.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.userId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.userId.focus();
		return;
	}
	var url = "idCheck.do?userId=" + document.frm.userId.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok() {
	opener.frm.userId.value = document.frm.userId.value;
	opener.frm.reid.value = document.frm.userId.value;
	self.close();
}

function joinCheck() {
    
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userId.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userId.focus();
		return false;
	}
	if (document.frm.userId.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userId.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reId.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userId.focus();
		return false;
	}
	return true;
}