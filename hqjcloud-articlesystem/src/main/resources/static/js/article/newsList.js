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
        elem: '#newsList',
        url : 'getByPage',
        loading :true,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "newsListTable",
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
            {field: 'arttitle', title: '文章标题', width:250},
            {field: 'artclass', title: '文章分类', width:150},
            {field: 'addauthor', title: '发布者', align:'center'},
            {field: 'artStatusName', title: '发布状态',  align:'center',templet:"#artstatus"},
            {field: 'visitcnt', title: '阅读次数', align:'center'},
            {field: 'istop', title: '是否置顶', align:'center', templet:function(d){
                return '<input type="checkbox" name="istop" value='+d.longid+' lay-filter="istop" lay-skin="switch" lay-text="是|否" '+d.istop+'>'
            }},
            {field: 'pubTimes', title: '发布时间', align:'center', minWidth:110, templet:function(d){
                    return d.pubTimes;
                }},
            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //是否置顶
    form.on('switch(istop)', function(data){
        var chk=data.elem.checked;
        var data={longid:data.value,isTop:chk?1:0};
        req.post("/article/top",data,function (res) {
             console.log("执行成功！");
            layer.msg("操作成功!");
        });
    })

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
                        body.find("#id").val(edit.longid);
                        body.find("#arttitle").val(res.data.arttitle);
                        body.find("#artabstract").val(res.data.artabstract);
                        body.find("#artimage").attr("src",res.data.artimage);
                        body.find("#content").val(res.data.artcontent);
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
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){

                // })
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
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            console.log(data);
            layer.confirm('确定删除此文章？',{icon:3, title:'提示信息'},function(index){
                req.del("/article/del",{longid:data.longid,_method:'DELETE'},function (res) {
                    console.log("执行成功！");
                    layer.msg('删除成功', {icon: 1});
                    tableIns.reload();
                },function (res) {
                    layer.close(index);
                    layer.msg(res.msg, {icon: 5,time:1000,shade:0.5});
                });
            });
        } else if(layEvent === 'look'){ //预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        }
    });

})