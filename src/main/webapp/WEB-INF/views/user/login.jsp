<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
 div.container{
     	height:400px;
     	whidth:700px;
     	border:1px solid #ab1100;
     }
</style>
</head>
<body>
<div class="container" id="loginform"></div>
<!-- 
<div class="container">
	<h4>회원로그인</h4>
	ID: <input type="text" id=uiId><br>
	PWD: <input type="password" id=uiPwd><br>
	<button onclick="dologin()">로그인</button>
</div>
-->
<script>
window.onload=function(){
	var dhWin = new dhx.Window({width:500,height:300,title:'login'});
	//dhWin.show();
		var form = new dhx.Form("loginform", {
			cellCss: "dhx_widget--bordered",
			rows: [
				{
					type: "input",
					label: "아이디",
					icon: "dxi dxi-magnify",
					placeholder: "아이디를 넣어주세요",
					id:"uiId"
				},
				{
					type: "input",
					inputType: "password",
					label: "비밀번호",
					placeholder: "비밀번호를 적어주세요",
					id:"uiPwd"
				},

				{
					type: "button",
					value: "Send",
					size: "medium",
					view: "flat",
					submit: true,
					color: "primary",
					id:"loginBtn"
				},
			]
		});
		
		form.events.on("ButtonClick",function(id,e){
			if(id==='loginBtn'){
				dologin();
			}
		})

	
}
function dologin(){
	var param = {
			uiId:document.querySelector('#uiId').value,
			uiPwd:document.querySelector('#uiPwd').value
			
	}
	param=JSON.stringify(param);
	var xhr=new XMLHttpRequest();
	xhr.open('POST','/user/login');
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				if(xhr.responseText){
					var user =JSON.parse(xhr.responseText);
					alert(user.uiName+'님 반갑습니다.');
					location.href='/views/userinfo/list';
				}
				
			}
		}
	}
	xhr.send(param)
}

</script>
</body>
</html>