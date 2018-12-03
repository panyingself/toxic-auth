
/*
 * Copyright (c) 2018. toxic
 */

function topermissionEdit(url){
    //执行permission-form表达提交
    $.ajax({
        url:$("#permission_edit_form").attr("action"),
        type:"POST",
        data:$("#permission_edit_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function permissionEditReset() {
    $("#permission_edit_form").reset();
}