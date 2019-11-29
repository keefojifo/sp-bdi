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
		<h4>난 유저 리스트</h4>
		<div class="search">
			<label for="uiName"> 이름</label> <input type="checkbox" id="uiName" value="ui_name" name="search">
			<label for="uiId"> ID</label> <input type="checkbox" id="uiId" value="ui_id" name="search">
			<label for="uiNum"> 번호</label> <input type="checkbox" id="uiNum" value="ui_num" name="search">
			<input type="text" id="searchStr"><button>검색</button>
			
		</div>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">이름</th>
				<th scope="col">아이디</th>
				<th scope="col">페스워드</th>
				<th scope="col">작성날짜</th>
				<th scope="col">작성시간</th>
				<th scope="col">수정날짜</th>
				<th scope="col">수정시간</th>
				<th scope="col">엑티브</th>

			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
		
	</table>
	<a href ="/views/user/ajaxinsert"><button >회원가입</button></a>
	
	
	<script>
	function getUserList(param){
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/list/ajax?'+param);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var tBody = document.getElementById('tBody');
						var html = '';
						for (var i = 0; i < list.length; i++) {
							html += '<tr>';
							html += '<td><a href="/views/user/ajaxview?uiNum='+list[i].uiNum+'">' + list[i].uiNum + '</a></td>';
							html += '<td>' + list[i].uiName + '</td>';
							html += '<td>' + list[i].uiId + '</td>';
							html += '<td>' + list[i].uiPwd + '</td>';
							html += '<td>' + list[i].credat + '</td>';
							html += '<td>' + list[i].cretim + '</td>';
							html += '<td>' + list[i].moddat + '</td>';
							html += '<td>' + list[i].modtim + '</td>';
							html += '<td>' + list[i].active + '</td>';
							html += '</tr>';
						}
						tBody.innerHTML = html;
						//document.write(xhr.responseText);
					}
				}
			}
			xhr.send();
			}
			window.onload = function() {
			getUserList('');
			var btn =document.querySelector('button');
			btn.onclick=function(){
				
				var checks=document.querySelectorAll('[name=search]:checked');
				if(checks.length==0){
					alert('검색대상을 1개라도 선택해주세요!');
					return;
				}
				var searchStr =document.querySelector('#searchStr');
				if(searchStr.value.trim().length<1){
					alert('검색어를 입력해주세요');
					return;
				}
				var search='';
				for(var i=0;i<checks.length;i++){
					search +='search='+checks[i].value+'&';
				}
				search +='searchStr='+searchStr.value;
				getUserList(search);
			}
		}
	</script>
</body>
</html>