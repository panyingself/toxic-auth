<#assign ctx = request.contextPath/>

<span class="layui-breadcrumb">
  <a href="">功能</a>
  <a><cite>任务列表</cite></a>
</span>

<br><br>

<div>
    <label>任务名</label><input>
    <label>任务分组</label><input>
    <label>执行状态</label><input>
    <button class="layui-btn" onclick="userListQuery()">搜索</button>
    <button class="layui-btn" onclick="toJobView('${ctx}/user/add')" >新增</button>
</div>

<#--<form class="layui-form" action="">-->
    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
    <#--</div>-->
<#--</form>-->


<table class="layui-table">
    <colgroup>
        <col width="50">
        <col width="150">
        <col>
    </colgroup>
    <thead>

    <tr  style="text-align: center;">
        <th>序号</th>
        <th>操作</th>
        <th>用户id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>创建时间</th>
    </tr>
    </thead>
    <tbody>
        <#if (userList)?? >
            <#list userList as user >
            <tr>
                <td></td>
                <td>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="toUserView('${ctx}/user/edit?id=${user.userId}')">编辑</a>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="deleteUser('${ctx}/user/delete?id=${user.userId}','${ctx}/user/queryList')">删除</a>
                </td>
                <td><#if (user.userId)??>${user.userId}</#if></td>
                <td><a href="#"><#if (user.userName)??>${user.userName}</#if></a></td>
                <td><#if (user.password)??>${user.password}</#if></td>
                <td><#if (user.sex)??>${user.sex}</#if></td>
                <td><#if (user.age)??>${user.age}</#if></td>
                <td><#if (user.createDateTime)??>${(user.createDateTime?string("yyyy-MM-dd HH:mm:ss"))}</#if></td>

            </tr>
            </#list>
        </#if>
    </tbody>
</table>
<script src="${request.contextPath}/js/user/user_list.js"></script>
