
/*
 * Copyright (c) 2018. toxic
 */

function toUserEdit(url){
    //执行user-form表达提交
    $.ajax({
        url:$("#user_edit_form").attr("action"),
        type:"POST",
        data:$("#user_edit_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function userEditReset() {
    $("#user_edit_form").reset();
}