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
            {field: 'addtime', title: '添加时间', align:'center', minWidth:110},
            {title: '操作', width:170, templet:'#classListBar',fixed:"right",align:"center"}
        ]]
    });
    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
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

    //添加文章
    function addNews(edit){
        var title=edit==null?"添加文章":"修改文章";
        var index = layui.layer.open({
            title : title,
            type : 2,
            content : "newsAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    req.get("/article/info",{longid:edit.longid},function (res) {
                        console.log(res.data);
                        body.find("#myid").val(edit.longid);
                        body.find("#arttitle").val(res.data.arttitle);
                        body.find("#artabstract").val(res.data.artabstract);
                        body.find("#artimage").attr("src",res.data.artimage);
                        body.find("#artcontent").val(res.data.artcontent);
                        body.find("#release"+res.data.artstatus+"").prop("checked","checked");
                        body.find("#artistop").val(res.data.istop);
                        body.find(".newsTop input[name='istop']").prop("checked",res.data.istop);
                        if(res.artstatus==6) //定时发布
                        {
                            body.find("#pubtimes").val(res.data.pubtimes);
                        }
                        form.render();
                        console.log("form.render()");
                    });

                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            //layui.layer.full(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            newsId = [];
        console.log(data);
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].longid);
            }
            console.log(newsId);
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                for (var i in data) {
                    req.del("/article/del",{longid:data[i].longid,_method:'DELETE'},function (res) {
                        console.log("执行成功！");
                        tableIns.reload();
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

        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            console.log(data);
            layer.confirm('确定删除此文章？',{icon:3, title:'提示信息'},function(index){
                req.del("/article/del",{longid:data.longid,_method:'DELETE'},function (res) {
                    console.log("执行成功！");
                    tableIns.reload();
                });
            });
        }
    });

})