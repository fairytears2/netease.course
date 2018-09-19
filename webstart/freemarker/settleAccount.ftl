<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
        <h2>已添加到购物车的内容</h2>
    </div>
<form class="m-form m-form-ht" id="form" method="post" action="/spring-webapp/api/buy"  autocomplete="on">     
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
            <tr><th><input type="checkbox" value = "全选"></th><th>内容图片</th><th>内容名称</th><th>数量</th><th>购买价格</th><th>操作</th></tr>
        </thead>
        <#list settleList as x> 
        <tbody>       	
               	<td><input type="checkbox"></td>
                <td><a href="/spring-webapp/api/show?id=${x.id}"><img src="${x.image}" alt=""></a></td>
                <td><h4><a href="/spring-webapp/api/show?id=${x.id}">${x.title}</a></h4></td>
                <td>
                <button type="button">-</button>
                <input class="v-num"  value=1 style="width:30px;text-align: center;">
                <button type="button">+</button>
               	</td>
                <td><span class="v-unit">¥</span><span class="value">${x.price}</span></td>
                <td><button >删除</button></td>
            </tr>
        </tbody>
        </#list> 
    </table>
 	<div class="panel-footer" style="text-align: left">总额：</div>	
 	<div id="act-btn"><button class="u-btn u-btn-primary" id="back">退出</button>
 	<button type="submit" class="u-btn u-btn-primary" id="Account">购买</button></div>
	</div>
	</form>
<#include "/include/footer.ftl">
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/settleAccount.js"></script>
</body>
</html>