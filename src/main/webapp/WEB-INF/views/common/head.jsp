<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	function goPage(url) {
		location.href = '/views' + url;
	}
</script>

<c:set var="ver" value="0.0.0" />
<script type="text/javascript" src="${codePath}/suite.js?v=${ver}"></script>
<link rel="stylesheet" href="${codePath}/suite.css?v=${ver}">
<link rel="stylesheet" href="${codePath}/index.css?v=${ver}">
