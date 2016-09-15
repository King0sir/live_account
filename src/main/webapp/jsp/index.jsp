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
    <div align="center">请输入您的帐户</div>
    <form action="/live_account/login" method="post">
        <div align="center"><input type="text" id="user" name="user" value="请输入手机/邮箱" onfocus="this.value=''"/> </div>
        <div align="center"><input type="password" id="password" name="password" /> </div>
        <div align="center"><input type="submit" value="登陆"/>&nbsp;<input type="button" value="注册"></div>
    </form>


</body>
<script type="application/javascript">

    function onInput(){
        alert(this);
    }
</script>
</html>
