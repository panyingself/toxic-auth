<#assign ctx = request.contextPath/>
<#--<link rel="stylesheet" href="${request.contextPath}/js/ztree/css/demo.css" type="text/css">-->
	<link rel="stylesheet" href="${request.contextPath}/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${request.contextPath}/js/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/ztree/js/jquery.ztree.excheck.js"></script>
  <SCRIPT type="text/javascript">
      <#--var setting = {-->
          <#--check: {-->
              <#--enable: true-->
          <#--},-->
          <#--data: {-->
              <#--simpleData: {-->
                  <#--enable: true-->
              <#--}-->
          <#--}-->
      <#--};-->
      <#--$(document).ready(function(){-->
          <#--$.fn.zTree.init($("#treeDemo"), setting, ${znodes});-->
      <#--});-->
  </SCRIPT>
</HEAD>

<BODY>
<h1>权限勾选操作</h1>
<br>

<hr class="layui-bg-green">
<div class="layui-row layui-col-space1">
    <#if roles?? && (roles?size > 0 ) >
        <#list roles as role>
            <div class="layui-col-md2">
                <div class="grid-demo grid-demo-bg1">
                    <button class="layui-btn layui-btn-radius" id="${role.roleId}" onclick="selectRole('${role.roleId}')" btnactive="false" value="'${role.roleId}'">${role.roleName}</button>
                </div>
            </div>
        </#list>
    </#if>
</div>

<br>
<hr class="layui-bg-green">

<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>

<br>
<hr class="layui-bg-green">
<br>
<button class="layui-btn layui-btn-radius" onclick="py()">修改</button>

</BODY>
<script type="text/javascript" src="${request.contextPath}/js/permission/permission_config_list.js"></script>