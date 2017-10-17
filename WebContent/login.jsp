<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/input.css" rel="stylesheet">
</head>
<body>
	<form action="dataCapture_saveData" method="post">
		<div class="space">
			<h1>Data Capture!</h1>
		</div>
		<div class="form height1">
			<p class="head">帐号信息</p>
			<div>
				<div>
					<p class="text">
						<span>*</span> 用户名:
					</p>
					<input class="input1" name="" type="text" />

				</div>
				<div>
					<p class="text">
						<span>*</span> 请设置密码:
					</p>
					<input class="input2" name="" type="text" />
				</div>

			</div>
		</div>

		<div class="form height">
			<p class="head">Cookie设置</p>
			<div>
				<div>
					<p class="text">
						<span>*</span> 网站URL:
					</p>
					<input name="" type="text" />
				</div>
				<div>
					<p class="text">
						<span>*</span> Cookie信息:
					</p>
					<input name="myCookie" type="text" />

				</div>
				<div>
					<input class="loginBtn" type="submit" value="开始抓取">
				</div>

			</div>
		</div>




	</form>
</body>
</html>