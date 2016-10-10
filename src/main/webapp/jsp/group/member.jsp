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
    <div id="showGroup" align="center">小组名:<div style="color: red; display: inline"><h2 style="display:inline">${groupName}</h2></div></div>
    <br/>
    <div align="center">
        <table id="userInGroup" cellspacing="10">
            <tr>
                <td>昵称</td>
                <td>邮箱</td>
                <td>电话</td>
            </tr>
        </table>
    </div>
    <div align="center"><input type="button" onclick="history.go(-1)" value=" 返 回 "> </div>
</body>
<script type="application/javascript">
    $(document).ready(function(){
        var userList = '${userList}';
        var json = JSON.parse(userList);
        for(var i = 0;i<json.length;i++){
            var row = '<tr><td>'+json[i].nickName+'</td><td>'+json[i].email+'</td><td>'+json[i].phone+'</td></tr>';
            addTr("userInGroup",-1,row);
        }
        console.log(userList);
    });

    function addTr(tab, row, trHtml){
        //获取table最后一行 $("#tab tr:last")
        //获取table第一行 $("#tab tr").eq(0)
        //获取table倒数第二行 $("#tab tr").eq(-2)
        var $tr=$("#"+tab+" tr").eq(row);
        if($tr.size()==0){
            alert("指定的table id或行数不存在！");
            return;
        }
        $tr.after(trHtml);
    }
</script>