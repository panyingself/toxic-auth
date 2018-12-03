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
    <button class="layui-btn" onclick="permissionListQuery()">搜索</button>
    <button class="layui-btn" onclick="toJobView('${ctx}/permission/add')" >新增</button>
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
        <th>权限id</th>
        <th>权限类型</th>
        <th>权限名称</th>
        <th>权限地址</th>
        <th>权限类容</th>
        <th>父id</th>
        <th>父id组</th>
    </tr>
    </thead>
    <tbody>
        <#if (permissionList)?? >
            <#list permissionList as permission >
            <tr>
                <td></td>
                <td>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="topermissionView('${ctx}/permission/edit?id=${permission.resourceId}')">编辑</a>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="deletepermission('${ctx}/permission/delete?id=${permission.resourceId}','${ctx}/permission/queryList')">删除</a>
                </td>
                <td><#if (permission.resourceId)??>${permission.resourceId}</#if></td>
                <td><a href="#"><#if (permission.resourceType)??>${permission.resourceType}</#if></a></td>
                <td><#if (permission.name)??>${permission.name}</#if></td>
                <td><#if (permission.url)??>${permission.url}</#if></td>
                <td><#if (permission.permission)??>${permission.permission}</#if></td>
                <td><#if (permission.parentId)??>${permission.parentId}</#if></td>
                <td><#if (permission.parentIds)??>${permission.parentIds}</#if></td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>
<script src="${request.contextPath}/js/permission/permission_list.js"></script>
