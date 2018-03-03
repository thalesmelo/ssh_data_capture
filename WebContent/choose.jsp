<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/input.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var mod = null;
	function changeAction(index) {
		switch (index) {
		case 1:
			mod = "News";
			break;
		case 2:
			mod = "Training";
			break;
		case 3:
			mod = "Disscussion";
			break;
		case 4:
			mod = "Activity";
			break;
		case 5:
			mod = "Photo";
			break;
		case 6:
			mod = "User";
			break;
		case 7:
			mod ="Feed";
			break;
		case 8:
			mod ="ActivityCount";
			break;
		}
		$("#moduleAction").attr("action", mod);
		$("#showModule").text(mod);
		$("#moduleIndex").val(index);

	}

	function copyData() {
		$.ajax({
			url : "CopyDB",
			type : "post",
			data : "",
			datatype : "json",
			success : function(e) {
				alert("数据转移完毕!");
			}
		})
	}

	window.onload = function() {
		//alert($("#moduleIndex").val());
		var index = $("#moduleIndex").val();
		if (index != null) {
			changeAction(parseInt($("#moduleIndex").val()));
		}
	}

	function progress() {
		var obj = {
			url : "Progress",
			type : "post",
			datatype : "json",
			success : function(res) {
				if (res.total > 0) {
					$("#Index").html(
							" 已加载第  <span> " + res.index + " / " + res.total
									+ " </span>条数据 !!!");
				} else {
					$("#Index").html(
							" 已加载第  <span> " + res.index + " </span>条数据 !!!");
				}
				$("#Common").html(
						" 已加载第   <span>" + res.common + " </span>条common !!!");
				$("#Tag")
						.html(" 已加载第   <span> " + res.tag + " </span>条tag !!!");
				$("#Img")
						.html(" 正在下载第   <span> " + res.img + " </span>张图片 !!!");
				$("#photo").html(
						" 已加载第  <span> " + res.photo + " </span>张photo !!!");
				if (res.error) {
					$("#error").html(" 网络连接超时 !!!!!!");
				}

			}
		}

		$.ajax(obj);
	}

	var start = self.setInterval("progress()", 500);
</script>
</head>
<body>

	<form action="NEWS" method="post" id="moduleAction">
		<div class="space">
			<h1>Data Capture!</h1>
		</div>
		<div class="form height1">
			<p class="head">模块选择</p>
			<div>
				<h2 style="text-align: center;">
					<c:if test="${websitename==1}">
						<span>TEAM</span>
					</c:if>
					<c:if test="${websitename==2}">
						<span>ELEVATE</span>
					</c:if>
					<c:if test="${websitename==3}">
						<span>CHAMPIONS</span>
					</c:if>
				</h2>
				<p class="text">
					<span>*</span> 已选中模块:
				</p>
				<b id="showModule" style="font-size: 24px"></b>

				<div>

					<input type="hidden" value="${pageIndex}"> <input
						type="hidden" value="${websitename}" name="websitename"> <input
						type="hidden" value="${moduleIndex }" name="moduleIndex"
						id="moduleIndex">
					<p class="text">
						<span>*</span> 模块名:
					</p>

					<input type="button" value="NEWS" onclick="changeAction(1);">
					<input type="button" value="TRAINING" onclick="changeAction(2);">
					<input type="button" value="DISCUSSION" onclick="changeAction(3);">
					<p class="text">&nbsp;&nbsp;&nbsp;</p>
					<input type="button" value="ACTIVTY" onclick="changeAction(4);">
					<input type="button" value="PHOTO" onclick="changeAction(5);">
					<input type="button" value="USERS" onclick="changeAction(6);">
					<p class="text">&nbsp;&nbsp;&nbsp;</p>
					<input type="button" value="FEED" onclick="changeAction(7);">
					<input type="button" value="ActivityCount" onclick="changeAction(8);">

				</div>



			</div>
		</div>

		<div class="form height">
			<p class="head">choose index</p>
			<div>
				<div>
					<p class="text">
						<span>*</span> Page Index:
					</p>

				</div>
				<div>

					<input type="radio" value="1" name="pageIndex"
						<c:if test="${pageIndex== 1}">checked="checked"</c:if>>01
					<input type="radio" value="2" name="pageIndex"
						<c:if test="${pageIndex==2 }">checked="checked"</c:if>>02
					<input type="radio" value="3" name="pageIndex"
						<c:if test="${pageIndex==3 }">checked="checked"</c:if>>03
					<input type="radio" value="4" name="pageIndex"
						<c:if test="${pageIndex== 4}">checked="checked"</c:if>>04
					<input type="radio" value="5" name="pageIndex"
						<c:if test="${pageIndex== 5}">checked="checked"</c:if>>05
					<input type="radio" value="6" name="pageIndex"
						<c:if test="${pageIndex==6 }">checked="checked"</c:if>>06
					<input type="radio" value="7" name="pageIndex"
						<c:if test="${pageIndex== 7}">checked="checked"</c:if>>07
					<input type="radio" value="8" name="pageIndex"
						<c:if test="${pageIndex== 8}">checked="checked"</c:if>>08
					<input type="radio" value="9" name="pageIndex"
						<c:if test="${pageIndex== 9}">checked="checked"</c:if>>09
					<input type="radio" value="10" name="pageIndex"
						<c:if test="${pageIndex== 10}">checked="checked"</c:if>>10
					<input type="radio" value="11" name="pageIndex"
						<c:if test="${pageIndex== 11}">checked="checked"</c:if>>11
					<input type="radio" value="12" name="pageIndex"
						<c:if test="${pageIndex== 12}">checked="checked"</c:if>>12
					<input type="radio" value="13" name="pageIndex"
						<c:if test="${pageIndex== 13}">checked="checked"</c:if>>13
					<input type="radio" value="14" name="pageIndex"
						<c:if test="${pageIndex==14 }">checked="checked"</c:if>>14
					<input type="radio" value="15" name="pageIndex"
						<c:if test="${pageIndex== 15}">checked="checked"</c:if>>15
					<input type="radio" value="16" name="pageIndex"
						<c:if test="${pageIndex==16 }">checked="checked"</c:if>>16
					<input type="radio" value="17" name="pageIndex"
						<c:if test="${pageIndex==17}">checked="checked"</c:if>>17
					<input type="radio" value="18" name="pageIndex"
						<c:if test="${pageIndex== 18}">checked="checked"</c:if>>18
					<input type="radio" value="19" name="pageIndex"
						<c:if test="${pageIndex== 19}">checked="checked"</c:if>>19
					<input type="radio" value="20" name="pageIndex"
						<c:if test="${pageIndex== 20}">checked="checked"</c:if>>20

				</div>
				<div>
					<input class="loginBtn" type="submit" value="开始抓取"> <input
						class="loginBtn" type="button" value="数据转移" onclick="copyData()">
				</div>

			</div>
		</div>


		<div class="form height3">
			<p class="head">Progressing</p>
			<div>
				<h1 id="error" style="font-size: 28px; color: red;"></h1>
				<div>
					<p class="text">
						<span>*</span> Index:
					</p>
					<b id="Index"></b>
				</div>

				<div>
					<p class="text">
						<span>*</span> Common:
					</p>
					<b id="Common"></b>
				</div>
				<div>
					<p class="text">
						<span>*</span> Tag:
					</p>
					<b id="Tag"></b>
				</div>
				<div>
					<p class="text">
						<span>*</span> Photo:
					</p>
					<b id="photo"></b>
				</div>
				<div>
					<p class="text">
						<span>*</span> Img:
					</p>
					<b id="Img"></b>
				</div>


			</div>

		</div>

		<div class="form height3">
			<p class="head">数据摘要</p>
			<table width="100%" border="1" cellspacing="0" style="text-align: center; ">
				<tr>
					<td>webSite</td>
					<td>NEWS</td>
					<td>TRAINING</td>
					<td>ACTIVITY</td>
					<td>DISCUSSION</td>
					<td>PHOTO</td>
					<td>USERS</td>

				</tr>
				<tr>
					<td>TEAM</td>
					<td>1</td>
					<td>0</td>
					<td>1</td>
					<td>7</td>
					<td>0</td>
					<td>4000+</td>

				</tr>
				<tr>
					<td>ELEVATE</td>
					<td>4</td>
					<td>0</td>
					<td>3</td>
					<td>16</td>
					<td>96</td>
					<td>944+</td>
				</tr>

				<tr>
					<td>CHAMPIONS</td>
					<td>3</td>
					<td>1</td>
					<td>2</td>
					<td>8</td>
					<td>16</td>
					<td>1760+</td>
				</tr>


			</table>
		</div>
	</form>

</body>
</html>