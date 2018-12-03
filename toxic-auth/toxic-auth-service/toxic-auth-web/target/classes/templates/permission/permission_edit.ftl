
<div>

    <form class="layui-form" action="${request.contextPath}/permission/edit" id="permission_edit_form">

        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">权限id</label>
            <div class="layui-input-block">
                <input type="text" name="resourceId" required  lay-verify="required" placeholder="请输入权限id" autocomplete="off" class="layui-input" value="${permission.resourceId}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">权限类型</label>
            <div class="layui-input-block">
                <input type="text" name="resourceType" required  lay-verify="required" placeholder="请输入权限类型" autocomplete="off" class="layui-input" value="${permission.resourceType}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">权限名称</label>
            <div class="layui-input-inline">
                <input  name="name" required lay-verify="required" placeholder="请输入权限名称" autocomplete="off" class="layui-input" value="${permission.name}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">权限地址</label>
            <div class="layui-input-block">
                <input type="text" name="url" required  lay-verify="required" placeholder="请输入权限地址" autocomplete="off" class="layui-input" value="${permission.url}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">权限类容</label>
            <div class="layui-input-inline">
                <input name="permission" required lay-verify="required" placeholder="请输入权限类容" autocomplete="off" class="layui-input" value="${permission.permission}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">父id</label>
            <div class="layui-input-inline">
                <input name="parentId" required lay-verify="required" placeholder="请输入父id" autocomplete="off" class="layui-input" value="${permission.parentId}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">父id组</label>
            <div class="layui-input-inline">
                <input name="parentIds" required lay-verify="required" placeholder="请输入父id组" autocomplete="off" class="layui-input" value="${permission.parentIds}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="topermissionEdit('${request.contextPath}/permission/queryList')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="permissionEditReset()">重置</button>
            </div>
        </div>

    </form>

    <#--<a onclick="topermissionEdit('${request.contextPath}/permission/queryList')">test-->
    <#--</a>-->
</div>
<script src="${request.contextPath}/js/permission/permission_edit.js"></script>
<script>
    //Demo
    // layui.use('form', function(){
    //     var form = layui.form;

        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    // });
</script>