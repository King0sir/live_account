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
    <div id="showGroup" align="center">您的小组为:${group.name}<br/><input type="button" value="查看成员" onclick="queryGroup()"/></div>
    <div id="newGroup" align="center">您当前暂无小组<br/><input type="button" value="创建小组" onclick="createGroup()"/>&nbsp;&nbsp;<input type="button" value="寻找小组" onclick="searchGroup()"/></div>
    <br/>
    <div id="detail" align="center">
        <div align="center">至今为止您共消费过：<div style="color: red; display: inline"><h1 style="display:inline">12</h1></div> 元</div>
        <div align="center">记录下一笔消费：</div>
        <form action="/login" method="post">
            <table>
                <tr>
                    <td>时间</td>
                    <td><input type="date" id="payTime" name="payTime"/></td>
                </tr>
                <tr>
                    <td>金额(元)</td>
                    <td><input type="text" id="transAmt" name="transAmt"></td>
                </tr>
                <tr>
                    <td>付款人</td>
                    <td>
                        <select name="payer" id="payer">
                            TODO:数据库赋值
                            <option value="14739999925004842">kin</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>分摊人</td>
                    <td>
                        <input type="checkbox" name="share" value="14739999925004842">kin
                        <input type="checkbox" name="share" value="14739999925004842">kin
                        <input type="checkbox" name="share" value="14739999925004842">kin
                        <input type="checkbox" name="share" value="14739999925004842">kin
                    </td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td><input type="text" id="memo" name="memo"></td>
                </tr>
                <tr>
                    <td>图片(如有)</td>
                    <td><input type="file" id="image" name="image" /></td>
                </tr>
            </table>
            <br style="line-height: 8px"/>
            <div align="center"><input type="submit" value="确 认 提 交"/></div>
            <%--<form:select path="name" items="${simpleUserList}"--%>
                         <%--itemLabel="nickName" itemValue="userId">--%>
            <%--</form:select>--%>
        </form>


    </div>
</body>
</html>
<script type="application/javascript">
    $(document).ready(function(){
        init();
    });

    function init(){
        //Init Hide
        var groupId = '${group.id}';
        if(groupId == ''){
            $('#showGroup').hide();
            $('#detail').hide();
        }else{
            $('#newGroup').hide();
        }
        $('#payTime').val('2016-07-17');

        //Add Select
        var selectItemList = '${simpleUserList}';
        var json = JSON.parse(selectItemList);
        for(var i=0;i< json.length;i++){
            var option = new Option(json[i].nickName,json[i].userId);
            $('#payer').append(option);
        }
    }

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

    function queryGroup(){
        alert("查看成员：筹备中");
    }
</script>
