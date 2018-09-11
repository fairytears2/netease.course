<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user>
            <#if user.userType==1>卖家<#else>买家</#if>你好，<span class="name">${user.username}</span> <a href="/spring-webapp/api/logout">[退出]</a>
        <#else>
            请<a href="/spring-webapp/api/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/spring-webapp/api/index">首页</a></li>
            <#if user && user.userType==0>
            <li><a href="/spring-webapp/api/account">账务</a></li>
            <li><a href="/spring-webapp/api/settleAccount">购物车</a></li>
            </#if>
            <#if user && user.userType==1>
            <li><a href="/spring-webapp/api/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>