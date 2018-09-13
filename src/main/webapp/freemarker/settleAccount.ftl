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
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>数量</th><th>购买价格</th></tr>
        </thead>
        <#list settleList as x> 
        <tbody>
            <tr>
                <td><a href="./show.html"><img src="${x.image}" alt=""></a></td>
                <td><h4><a href="./show.html">${x.title}</a></h4></td>
                <td><span class="v-time">2016-03-12 12:12</span></td>
                <td><input class="v-num"  value=1/>
                <td><span class="v-unit">¥</span><span class="value">${x.price}</span></td>
            </tr>
        </tbody>
        </#list> 
    </table>
 		
 	<div id="act-btn"><button class="u-btn u-btn-primary" id="back">退出</button>
 	<button type="submit" class="u-btn u-btn-primary" id="Account">购买</button></div>
	</div>
	</form>
<#include "/include/footer.ftl">
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/settleAccount.js"></script>
</body>
</html>