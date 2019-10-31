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
        elem: '#List',
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
            {field: 'id', title: 'ID', width:60, align:"center"},
            {field: 'platformname', title: '平台名称', width:250},
            {field: 'levelname', title: '栏目名称', width:250},
            {field: 'parentLevelName', title: '上级栏目', width:250},
            {field: 'levelstatus', title: '是否启用', align:'center', templet:function(d){

                    return '<input type="checkbox" name="levelStatus" value='+d.longid+' lay-filter="checkStatus"  '+(d.levelStatus==1?'checked':'')+'    lay-skin="switch" lay-text="是|否" '+d.levelStatus+'>'
                }},
            {field: 'addtime', title: '添加时间', align:'center'},
            {field: 'modifytime', title: '修改时间',  align:'center'},

            {title: '操作', width:170, templet:'#ListBar',fixed:"right",align:"center"}
        ]]
    });

    // //是否置顶
    // form.on('switch(checkStatus)', function(data){
    //     var chk=data.elem.checked;
    //     var data={longid:data.value,status:chk?1:0};
    //     req.post("/articlelevel/doStatus",data,function (res) {
    //         console.log("执行成功！");
    //         layer.msg("操作成功!");
    //     });
    // })


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


    //添加文章栏目
    function add(edit){
        var title=edit==null?"添加栏目":"修改栏目";
        var index = layui.layer.open({
            title : title,
            type : 2,
            area: ['400px', '380px'],
            content : "add.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    req.get("/articlelevel/info",{longid:edit.longid},function (res) {
                        console.log(res.data);
                        body.find("#longid").val(edit.longid);
                        body.find("#levelName").val(res.data.levelname);
                        body.find("#hid_platform_Id").val(res.data.platformId);
                        body.find("#hid_levelparent_Id").val(res.data.levelParentid);
                        body.find("#status").val(res.data.levelStatus);
                        body.find("#open").prop("checked",res.data.levelStatus==1?true:false);
                        if (res.data.levelStatus == 1){
                            body.find("#")
                        }
                        form.render();
                    });
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回平台列表', '.layui-layer-setwin .layui-layer-close', {
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
    table.on('tool(List)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            add(data);
        }
        else if(layEvent=='del'){
            layer.confirm('确定删除吗？',{btn: ['确定', '取消'], title:'提示'},function(index){
                req.del("/articlelevel/del",{longid:data.longid,_method:'DELETE'},function (res) {
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