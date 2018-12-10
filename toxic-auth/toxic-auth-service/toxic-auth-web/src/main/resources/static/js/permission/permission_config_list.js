

function py() {
    console.log("test")
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo"),
        nodes = treeObj.getCheckedNodes(true),
        v = "";
    for (var i = 0; i < nodes.length; i++) {
        v += nodes[i].name + ",";
        console.log("节点id:" + nodes[i].id + "节点名称" + v); //获取选中节点的值
    }
}
//
function selectRole(roleId) {
    alert(roleId)
    //step1 获取选中id的权限信息
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