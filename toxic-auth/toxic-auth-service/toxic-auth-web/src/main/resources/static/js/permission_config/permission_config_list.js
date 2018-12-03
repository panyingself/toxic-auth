//Demo
layui.use(['tree', 'layer'], function(){
    var layer = layui.layer
        ,$ = layui.jquery;

    layui.tree({
        elem: '#demo1' //指定元素
        ,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
        ,click: function(item){ //点击节点回调
            layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item));
            console.log(item);
        }
        ,nodes: [ //节点
            {
                name: '常用文件夹'
                ,id: 1
                ,alias: 'changyong'
                ,children: [
                    {
                        name: '所有未读（设置跳转）'
                        ,id: 11
                        ,href: 'http://www.layui.com/'
                        ,alias: 'weidu'
                    }, {
                        name: '置顶邮件'
                        ,id: 12
                    }, {
                        name: '标签邮件'
                        ,id: 13
                    }
                ]
            }, {
                name: '我的邮箱'
                ,id: 2
                ,spread: true
                ,children: [
                    {
                        name: 'QQ邮箱'
                        ,id: 21
                        ,spread: true
                        ,children: [
                            {
                                name: '收件箱'
                                ,id: 211
                                ,children: [
                                    {
                                        name: '所有未读'
                                        ,id: 2111
                                    }, {
                                        name: '置顶邮件'
                                        ,id: 2112
                                    }, {
                                        name: '标签邮件'
                                        ,id: 2113
                                    }
                                ]
                            }, {
                                name: '已发出的邮件'
                                ,id: 212
                            }, {
                                name: '垃圾邮件'
                                ,id: 213
                            }
                        ]
                    }, {
                        name: '阿里云邮'
                        ,id: 22
                        ,children: [
                            {
                                name: '收件箱'
                                ,id: 221
                            }, {
                                name: '已发出的邮件'
                                ,id: 222
                            }, {
                                name: '垃圾邮件'
                                ,id: 223
                            }
                        ]
                    }
                ]
            }
            ,{
                name: '收藏夹'
                ,id: 3
                ,alias: 'changyong'
                ,children: [
                    {
                        name: '爱情动作片'
                        ,id: 31
                        ,alias: 'love'
                    }, {
                        name: '技术栈'
                        ,id: 12
                        ,children: [
                            {
                                name: '前端'
                                ,id: 121
                            }
                            ,{
                                name: '全端'
                                ,id: 122
                            }
                        ]
                    }
                ]
            }
        ]
    });


    //生成一个模拟树
    var createTree = function(node, start){
        node = node || function(){
            var arr = [];
            for(var i = 1; i < 10; i++){
                arr.push({
                    name: i.toString().replace(/(\d)/, '$1$1$1$1$1$1$1$1$1')
                });
            }
            return arr;
        }();
        start = start || 1;
        layui.each(node, function(index, item){
            if(start < 10 && index < 9){
                var child = [
                    {
                        name: (1 + index + start).toString().replace(/(\d)/, '$1$1$1$1$1$1$1$1$1')
                    }
                ];
                node[index].children = child;
                createTree(child, index + start + 1);
            }
        });
        return node;
    };

    layui.tree({
        elem: '#demo2' //指定元素
        ,nodes: createTree()
    });

});