

function py() {
    var roleId = $("[btnactive|='true']").attr("id");
    console.log("test"+":id为...."+roleId)
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
        nodes = treeObj.getCheckedNodes(true),
        v = "";
    var arr = new Array();
    for (var i = 0; i < nodes.length; i++) {
        v += nodes[i].name + ",";
        console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
        arr[i] = nodes[i].id;
    }
    console.log(arr+"....TESTSETST");
    var arrIds = "{"+arr+"}";
    console.log(arrIds+"....TESTSETST");

    var testIDS = ["0001","0002"];
    $.ajax({
        type: "POST",
        url: "/permissionconfig/updatePermissionListByRoleId",
        data: {permissionIds:arr,roleId:roleId},
        dataType: "json",
        traditional: true,//这里设置为true
        success: function(result){
            console.log(result)
            var setting = {
                check: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                }
            };
            $.fn.zTree.init($("#treeDemo"), setting, result);
        }
    });
}
//
function selectRole(roleId) {
    alert(roleId)
    //step1 获取选中id的权限信息
    $(".layui-btn").attr("btnActive","false");
    $("#"+roleId).attr("btnActive","true");
    $.ajax({
        type: "POST",
        url: "/permissionconfig/queryPermissionListByRoleId",
        data: {roleId:roleId},
        dataType: "json",
        success: function(result){
            console.log(result)
            var setting = {
                check: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                }
            };
            $.fn.zTree.init($("#treeDemo"), setting, result);
        }
    });

}