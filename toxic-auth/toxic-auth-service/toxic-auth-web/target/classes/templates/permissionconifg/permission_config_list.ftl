﻿<#assign ctx = request.contextPath/>
<#--<link rel="stylesheet" href="${request.contextPath}/js/ztree/css/demo.css" type="text/css">-->
	<link rel="stylesheet" href="${request.contextPath}/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${request.contextPath}/js/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/ztree/js/jquery.ztree.core.js"></script>
  <SCRIPT LANGUAGE="JavaScript">
      var zTreeObj;
      // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
      var setting = {};
      // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
      var zNodes = [
          {name:"test1", open:true, children:[
                  {name:"test1_1"}, {name:"test1_2"}]},
          {name:"test2", open:true, children:[
                  {name:"test2_1"}, {name:"test2_2"}]}
      ];
      $(document).ready(function(){
          zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, ${data});
      });
  </SCRIPT>
 </HEAD>
<BODY>
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</BODY>