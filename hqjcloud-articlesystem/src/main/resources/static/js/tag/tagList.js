layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','laydate','table','laytpl','layRequest'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        req=layui.layRequest,
        table = layui.table;

    //标签列表
    var tableIns = table.render({
        elem: '#tagList',
        url : 'getByPage',
        loading :true,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "ListTable",
        parseData:function(res)
        {
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.list //解析数据列表
            };
        },
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'longid', title: 'ID', width:60, align:"center"},
            {field: 'tagname', title: '名称', width:250},
            {field: 'addtime', title: '添加时间', align:'center'},
            // {field: 'tagstatus', title: '状态',  align:'center'},
            {field: 'tagstatus', title: '是否启用', align:'center', templet:function(d){

                    return '<input type="checkbox" name="tagStatus" value='+d.longid+' lay-filter="checkStatus"  '+(d.tagStatus==1?'checked':'')+'    lay-skin="switch" lay-text="是|否" '+d.tagStatus+'>'
                }},
            {title: '操作', width:170, templet:'#tagListBar',fixed:"right",align:"center"}
        ]]
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("ListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });



    function add(edit){
        var title=edit==null?"添加标签":"修改标签";
        var index = layui.layer.open({
            title : title,
            type : 2,
            area: ['400px', '180px'],
            content : "tagAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    req.get("/tag/info",{longid:edit.longid},function (res) {
                        console.log(res.data);
                        body.find("#longid").val(edit.longid);
                        body.find("#tagName").val(res.data.tagName);
                        body.find("#addTime").val(res.data.addTime);
                        body.find("#status").val(res.data.tagStatus);
                        body.find("#open").prop("checked",res.data.tagStatus==1?true:false);
                        form.render();
                    });
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回标签列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })

    }
    $(".add_btn").click(function(){
        add();
    })



    //列表操作
    table.on('tool(tagList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            add(data);
        }

        else if (layEvent == 'del'){
            layer.confirm('确定删除吗？',{btn: ['确定', '取消'], title:'提示'},function(index){
                req.del("/tag/del",{longid:data.longid,_method:'DELETE'},function (res) {
                    console.log("执行成功！");
                    layer.msg('删除成功', {icon: 1});
                    tableIns.reload();
                },function (res) {
                    layer.close(index);
                    layer.msg(res.msg, {icon: 5,time:1000,shade:0.5});
                });
            });
        }
    });

})