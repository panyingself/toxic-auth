/*
 * Copyright (c) 2018. toxic
 */

function toUserView(url){
    console.log(url);
    $("#api-main").load(url);
}

function jobListQuery() {
    alert("userListQuery start");
}

function deleteUser(url,returnUrl) {
    $.ajax({
        url:url,
        type:"POST",
        success:function (result) {
            $("#api-main").load(returnUrl);
        }
    })
}

