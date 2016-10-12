<%--
  Created by IntelliJ IDEA.
  User: kingsir
  Date: 16-10-10
  Time: 上午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport"
      content="width=device-width,
minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>Group</title>
    <%@include file="../include/common.jsp" %>
</head>
<body>
    <br/>
    <div id="showGroup" align="center">名称：<input type="text" id="searchName" name="searchName"/>&nbsp;<br/><input type="button" value="搜 索" onclick="searchName($('#searchName').val())"/> </div></div>
    <br/>
    <div align="center">
        <table id="groups" cellspacing="5">
            <tr>
                <td colspan="3">名称</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input type="button" value="上一页" onclick="newPage(${pageTool.page}-1)"/> </td>
                <td colspan="2"><div align="center">第 ${pageTool.page} / ${pageTool.totalPage} 页</div></td>
                <td><input type="button" value="下一页" onclick="newPage(${pageTool.page}+1)"/> </td>
            </tr>
        </table>
    </div>
    <div align="center"><input type="button" onclick="history.go(-1)" value=" 返 回 "> </div>
</body>
<script type="application/javascript">
    $(document).ready(function(){
        $('#searchName').val('${name}');

        var groupsList = '${groupsList}';
        var json = JSON.parse(groupsList);
        for(var i = 0;i<json.length;i++){
            var name = json[i].name;
            var userId = '${userId}';
            var row = '<tr><td colspan="3">'+name+'</td><td><a href="join?userId='+userId+'&groupName='+name+'">加入</a> </td></tr>';
            addTr("groups",-2,row);
        }
        console.log(groupsList);
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

    function newPage(page){
        var totalPage = ${pageTool.totalPage};
        if( page >= 1 && page <= totalPage){
            var userId = '${userId}';
            var name = $('#searchName').val();
            location.href="search?userId="+userId+"&name="+name+"&page="+page;
        }
    }

    function searchName(name){
        var userId = '${userId}';
        location.href="search?userId="+userId+"&name="+name+"&page=1";
    }

    function join(groupName){
        var userId = '${userId}';
        location.href="join?userId="+userId+"&groupName="+groupName;
    }
</script>
</html>
