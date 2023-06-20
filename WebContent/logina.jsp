<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Untitled Document</title>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<link rel="stylesheet" href="css/dangnhap.css">
</head>

<body>
    <div class="login-box">
        <h2>Login</h2>
        <form action="loginservlet" method="post">
          <div class="user-box">
            <input type="text" name="username">
            <label>Username</label>
          </div>
          <div class="user-box">
            <input type="password" name="password">
            <label>Password</label>
          </div>
          <button href="home.jsp" type="submit" value="login">
            <span>	</span>
            <span>	</span>
            <span>	</span>
            <span>	</span>
            Submit
          </button>
        </form>
      </div>
</body>
</html>