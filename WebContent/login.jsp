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
	<form action="Login" method="post">
		<div class="space">
			<h1>Data Capture!</h1>
		</div>

		<div class="form height">
			<p class="head">Choose WebSite</p>
			<div>
				<div>
					<p class="text">
						<span>*</span> WebSite:
					</p>
					<select name=websitename>
						<option value="1">TEAM</option>
						<option value="2">ELEVATE</option>
						<option value="3">CHAMPIONS</option>
					</select>
				</div>

				<div>
					<p class="text">
						<span>*</span> uploadImg:
					</p>

					<input type="radio" value="no" name="isUplodaImg" checked="checked"> NO
					<input type="radio" value="yes" name="isUplodaImg"> YES
				</div>

				<div>
					<input class="loginBtn" type="submit" value="网站登入">
				</div>

			</div>
		</div>




	</form>
</body>
</html>