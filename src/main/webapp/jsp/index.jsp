<%--
  Created by IntelliJ IDEA.
  User: kingsir
  Date: 16-9-8
  Time: 下午3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<meta name="viewport"
      content="width=device-width,
minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>Welcome To Live Account</title>
</head>
<body>
    <h2 align="center">Welcome To Live Account</h2>
    <h3 align="center">我会尽力为您算清难题</h3>
    <br/><br/><br/><br/><br/><br/><br/>
    <div align="center" style="height: 50px;">请输入您的帐户</div>
    <div id="login" style="display: block;">
        <form action="/live_account/login" method="post">
            <div align="center"><input type="text" id="user" name="user" value="请输入手机/邮箱" onfocus="this.value=''"/> </div>
            <div align="center"><input type="password" id="password" name="password" /> </div><br/>
            <div align="center"><input type="submit" value="登   陆" style="width: 170px;"/></div>
        </form>
    </div>
    <div id="register" style="display: none;">
        <form action="/live_account/register" method="post">
            <div align="center"><input type="text" id="phone" name="phone" value="请输入手机号" onfocus="this.value=''" /> </div>
            <div align="center"><input type="text" id="email" name="email" value="请输入邮箱" onfocus="this.value=''" /> </div>
            <div align="center"><input type="text" id="nickName" name="nickName" value="请输入昵称" onfocus="this.value=''" /> </div>
            <div align="center"><input type="password" id="rPassword" name="rPassword" value="请输入密码" onfocus="this.value=''" /> </div>
            <div align="center"><input type="password" id="rCheckPassword" name="rCheckPassword" value="请输入密码" onfocus="this.value=''" /> </div>
            <div align="center"><input type="submit" value="确   认" style="width: 170px;"/></div>
        </form>
    </div>
    <div align="center" style="color: red;">${error}</div>
    <div align="center"><input id="button" type="button" value="注   册" onclick="register()" style="width: 170px;"></div>

</body>
<script type="application/javascript">

    function register(){
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="";
        document.getElementById("button").value="返   回";
        document.getElementById("button").onclick=function(){back()};
    }

    function back(){
        document.getElementById("login").style.display="";
        document.getElementById("register").style.display="none";
        document.getElementById("button").value="注   册";
        document.getElementById("button").onclick=function(){register()};
    }

</script>
</html>
