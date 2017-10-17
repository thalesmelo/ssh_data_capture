<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/detail.css" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td><div>
					<img class=".ftl" alt="" src="${info.author_url }" height="150px"
						width="150px;">
					<p class="name">${info.author_name }</p>
					<ul>
						<c:forEach items="${info.tags }" var="tag">
							<li>${tag.userTag }</li>
						</c:forEach>
					</ul>
				</div></td>

		</tr>
		<tr>
			<td class="title">${info.title }</td>
		</tr>
		<tr>
			<td class="content"><img class="contenImage" alt=""
				src="${info.imageUrl }">
				<ul class="label">
					<c:forEach items="${info.labels }" var="label">
						<li>${label.labelName }</li>
					</c:forEach>
				</ul> ${info.content }</td>

		</tr>

		<tr>
			<td class="observer">
				<ul>
					<c:forEach items="${observer_info}" var="ob">
						<li class="obser">
							<div class="ftl">
								<img class="obicon" alt="" src="${ob.iconUrl }">
								<p class="obname">${ob.author_name }</p>
							</div>
							<div class="ftl comment">
								<p>${ob.comment }</p>
							</div>
						</li>

					</c:forEach>
				</ul>
			</td>
		</tr>


	</table>
</body>
</html>