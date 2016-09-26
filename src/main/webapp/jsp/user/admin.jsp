<%--
  Created by IntelliJ IDEA.
  User: kingsir
  Date: 16-9-16
  Time: 下午12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport"
      content="width=device-width,
minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>Live Account</title>
    <%@include file="../include/common.jsp" %>
</head>
<body>
    <br/>
    <div align="center">欢迎,${user.nickName}先生/女士</div>
    <div align="center">您的id为：${user.id}</div>
    <br/>
    <div id="showGroup" align="center">您的小组为:${group.name}</div>
    <div id="newGroup" align="center">您当前暂无小组<br/><input type="button" value="创建小组" onclick="createGroup()"/>&nbsp;&nbsp;<input type="button" value="寻找小组" onclick="searchGroup()"/></div>
</body>
</html>
<script type="application/javascript">
    $(document).ready(function(){
        var groupId = '${group.id}';
        if(groupId == ''){
            $('#showGroup').hide();
        }else{
            $('#newGroup').hide();
        }
    });

    function createGroup(){
        var user = ${user.id};
        var groupName = prompt("创建小组","请输入你的小组名");
        var result;
        jQuery.ajax({
            url:"group/create?userId="+user+"&groupName="+groupName+"",
            data:"",
            type:"GET",
            error: function(data) {
                alert(data);
                console.log(data);
            },
            success: function(data) {
                alert(data);
                console.log(data);
                location.reload(true);
            }
        });
    }
</script>
