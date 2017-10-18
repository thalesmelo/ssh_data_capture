<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/show.css" rel="stylesheet">
</head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>

<script type="text/javascript">
	function update() {

		var obj = {
			url : "update",
			type : "post",
			dataType : "json",
			success : function(data) {
				$("#showText").html("");
				$("#dataTable").html("");
				var $data = $(data.infos);
				if ($("#maxSize").val() != data.size) {
					$("#showText").append(
							"<tr><td colspan='5' class='progress'>正在加载第"
									+ (data.size + 1) + "条数据...</td></tr>")
				} else {
					$("#showText")
							.append(
									"<tr><td colspan='5' class='progress'>已全部加载完毕...</td></tr>")
				}
				$data
						.each(function() {

							$("#dataTable")
									.append(this
											
													+ "<tr><td>"
													+ this.detailId
													+ "</td>"
													+ "<td>"
													+ this.author_name
													+ "</td>"
													+ "<td>"
													+ this.title
													+ "</td>"
													+ "<td><a href='"
									+ this.imageUrl + "'>"
													+ this.imageUrl
													+ "</td>"
													+ "<td><a href='queryById?id="
													+ this.detailId
													+ "'>点击查看</a></td></tr>")

						});
			}
		}
		$.ajax(obj);
	}

	var start = self.setInterval("update()", 1000);
</script>
<body>


	<h1>获取进度</h1>
	<input type="hidden" value="${maxSize}" id="maxSize">

	<table cellspacing="1" cellpadding="0">

		<thead id="showText"></thead>
		<tr>
			<td class="tdwidth"><h3>编号</h3></td>
			<td class="tdwidth"><h3>作者</h3></td>
			<td><h3>标题</h3></td>
			<td><h3>图片url</h3></td>
			<td class="tdwidth"><h3>详情</h3></td>
		</tr>

		<tbody id="dataTable">

		</tbody>

	</table>



</body>
</html>