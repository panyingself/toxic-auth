
/*
 * Copyright (c) 2018. toxic
 */

function toroleEdit(url){
    //执行role-form表达提交
    $.ajax({
        url:$("#role_edit_form").attr("action"),
        type:"POST",
        data:$("#role_edit_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function roleEditReset() {
    $("#role_edit_form").reset();
}