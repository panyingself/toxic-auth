/*
 * Copyright (c) 2018. toxic
 */

function toroleView(url){
    console.log(url);
    $("#api-main").load(url);
}

function jobListQuery() {
    alert("roleListQuery start");
}

function deleterole(url,returnUrl) {
    $.ajax({
        url:url,
        type:"POST",
        success:function (result) {
            $("#api-main").load(returnUrl);
        }
    })
}

