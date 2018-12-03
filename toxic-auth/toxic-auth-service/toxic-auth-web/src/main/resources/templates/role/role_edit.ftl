
<div>

    <form class="layui-form" action="${request.contextPath}/role/edit" id="role_edit_form">

        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">用户id</label>
            <div class="layui-input-block">
                <input type="text" name="roleId" required  lay-verify="required" placeholder="请输入用户id" autocomplete="off" class="layui-input" value="${role.roleId}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-block">
                <input type="text" name="roleName" required  lay-verify="required" placeholder="请输入用户名称" autocomplete="off" class="layui-input" value="${role.roleName}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-inline">
                <input  name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="${role.password}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="text" name="sex" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input" value="${role.sex}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input name="age" required lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input" value="${role.age}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="toroleEdit('${request.contextPath}/role/queryList')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="roleEditReset()">重置</button>
            </div>
        </div>

    </form>

    <#--<a onclick="toroleEdit('${request.contextPath}/role/queryList')">test-->
    <#--</a>-->
</div>
<script src="${request.contextPath}/js/role/role_edit.js"></script>
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