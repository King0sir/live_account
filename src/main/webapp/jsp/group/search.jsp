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
    <title>History</title>
    <%@include file="../include/common.jsp" %>
</head>
<body>
    <div id="showGroup" align="center">用户名:<div style="color: red; display: inline"><h2 style="display:inline">${user.nickName}</h2></div></div>
    <br/>
    <div align="center">
        <table id="hisTrans" cellspacing="5">
            <tr>
                <td>时间</td>
                <td>分摊金额</td>
                <td>付款人</td>
                <td>备注</td>
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
        var hisTransList = '${hisTransList}';
        var json = JSON.parse(hisTransList);
        for(var i = 0;i<json.length;i++){
            var row = '<tr><td>'+json[i].payTime+'</td><td>'+json[i].perAmt+'</td><td>'+json[i].payer+'</td><td>'+json[i].memo+'</td></tr>';
            addTr("hisTrans",-2,row);
        }
        console.log(hisTransList);
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
            var userId = '${user.id}';
            location.href="trans/history?userId="+userId+"&page="+page;
        }
    }
</script>
</html>
