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

    //新闻列表
    var tableIns = table.render({
        elem: '#classList',
        url : 'getByPage',
        loading :true,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "classListTable",
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
            {field: 'classname', title: '', width:350},
            {field: 'statusName', title: '状态', align:'center', templet:function(d){
                if(d.status==1)
                    return '<input type="checkbox" name="isenable"   value='+d.longid+' lay-filter="isenable"  checked="checked"  lay-skin="switch"  lay-text="启用|禁用" '+d.status+'>'
                else
                    return '<input type="checkbox" name="isenable"   value='+d.longid+' lay-filter="isenable"   lay-skin="switch"  lay-text="启用|禁用" '+d.status+'>'
                }},
            {field: 'addTimes', title: '添加时间', align:'center', minWidth:110},
            {title: '操作', width:170, templet:'#classListBar',fixed:"right",align:"center"}
        ]]
    });

    //是否启用
    form.on('switch(isenable)', function(data){
        var chk=data.elem.checked;
        var data={longid:data.value,status:chk?1:0};
        req.post("/articleclass/doStatus",data,function (res) {
            console.log("执行成功！");
            layer.msg("操作成功!");
        });
    })

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        /*if($(".searchVal").val() != ''){*/
            table.reload("classListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
       /* }else{
            layer.msg("请输入搜索的内容");
        }*/
    });

    //添加文章
    function addclass(edit){
        var title=edit==null?"添加分类":"修改分类";
        var index = layui.layer.open({
            title : title,
            type : 2,
            area: ['360px', '250px'],
            content : "articleClassAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    req.get("/articleclass/info",{longid:edit.longid},function (res) {
                        console.log(res.data);
                        body.find("#longid").val(edit.longid);
                        body.find("#className").val(res.data.classname);
                        body.find("#status").val(res.data.status);
                        body.find("#open").prop("checked",res.data.status==1?true:false);
                        form.render();
                    });
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章分类列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        //layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
      /*  $(window).on("resize",function(){
            //layui.layer.full(index);
        })*/
    }
    $(".add_btn").click(function(){
        addclass();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('classListTable'),
            data = checkStatus.data,
            newsId = [];
        console.log(data);
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].longid);
            }
            console.log(newsId);
            layer.confirm('确定删除选中的分类吗？', {icon: 3, title: '提示信息'}, function (index) {
                for (var i in data) {
                    req.del("/articleclass/del",{longid:data[i].longid,_method:'DELETE'},function (res) {
                        console.log("执行成功！");
                    });
                }
                tableIns.reload();
                layer.close(index);
            })
        }else {
            layer.msg("请选择需要删除的文章");
        }
    })

    //列表操作
    table.on('tool(classList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        var id=data.longid;
        if(layEvent === 'edit'){ //编辑
            addclass(data);
        }
        else if(layEvent=='del'){
            layer.confirm('确定删除吗？',{btn: ['确定', '取消'], title:'提示'},function(index){
                req.del("/articleclass/del",{longid:id,_method:'DELETE'},function (res) {
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