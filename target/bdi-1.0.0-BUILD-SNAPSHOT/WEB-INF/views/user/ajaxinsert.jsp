<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>회원가입</h3>
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName" placeholder="이름을 적어주세요."></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId" placeholder="아이디를 적어주세요."></td>
			</tr>
			<tr>
				<th>페스워드</th>
				<td><input type="text" id="uiPwd" placeholder="페스워드를 적어주세요.."></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="save()">저장</button></th>
			</tr>
		</table>
	</div>
	<script>
		function save() {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/user/ajaxinsert');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var res = JSON.parse(xhr.responseText);
						alert(res.msg);
					}
				}
			}
			var param = {
					uiName : document.getElementById('uiName').value,
					uiId : document.getElementById('uiId').value,
					uiPwd : document.getElementById('uiPwd').value
			}
			console.log(param);
			//param을 객체에서 구조체로 바꾸는중.
			param = JSON.stringify(param);
			xhr.send(param);
		}
	</script>
</body>
</html>