/*
 * Copyright (c) 2018. toxic
 */

function topermissionView(url){
    console.log(url);
    $("#api-main").load(url);
}

function jobListQuery() {
    alert("permissionListQuery start");
}

function deletepermission(url,returnUrl) {
    $.ajax({
        url:url,
        type:"POST",
        success:function (result) {
            $("#api-main").load(returnUrl);
        }
    })
}

