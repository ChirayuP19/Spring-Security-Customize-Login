<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Access Denied | 403</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(135deg, #141e30, #243b55);
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
        }

        .container {
            background: #1f2a44;
            padding: 40px;
            border-radius: 14px;
            width: 100%;
            max-width: 480px;
            text-align: center;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.6);
        }

        .error-code {
            font-size: 90px;
            font-weight: 800;
            color: #ff4c4c;
            margin-bottom: 10px;
        }

        .title {
            font-size: 26px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .message {
            font-size: 15px;
            color: #cfd8dc;
            line-height: 1.6;
            margin-bottom: 30px;
        }

        .btn-group {
            display: flex;
            justify-content: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .btn {
            padding: 12px 24px;
            border-radius: 30px;
            text-decoration: none;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.3s ease;
        }

        .btn-home {
            background: #4cafef;
            color: #fff;
        }

        .btn-home:hover {
            background: #2196f3;
        }

        .btn-login {
            background: transparent;
            color: #4cafef;
            border: 2px solid #4cafef;
        }

        .btn-login:hover {
            background: #4cafef;
            color: #fff;
        }

        footer {
            margin-top: 25px;
            font-size: 12px;
            color: #9fa8b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="error-code">403</div>
    <div class="title">Access Denied</div>

    <div class="message">
        Sorry, you don’t have permission to access this page.<br>
        Please log in with the correct account or contact the administrator.
    </div>

    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/test/index" class="btn btn-home">Go Home</a>
        <a href="${pageContext.request.contextPath}/test/mylogin" class="btn btn-login">Login</a>
    </div>

    <footer>
        © 2025 Your Application • Security Protected
    </footer>
</div>

</body>
</html>
