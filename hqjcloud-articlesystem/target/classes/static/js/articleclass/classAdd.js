layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','layRequest'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        req=layui.layRequest,
        $ = layui.jquery;


    /*function loadData()
    {
        var id=$("#longid").val();
        console.log(id);
        if(id>0)
        {
            req.get("/articleclass/info",{longid:id},function (res) {
                console.log(res);
                form.val('artClassExample', {
                    "className": res.data.className
                    ,"open": res.data.status==1?true:false //开关状态
                    ,"status": res.data.status==1
                    ,"longid": res.data.longid
                });
            });
            form.render();
        }
    }

    loadData();*/

    form.on("submit(addClass)",function(data){

      /*  layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;*/

        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#longid").val(),
                classname : $("#className").val(),
                status : $("#status").val()
            };

        req.post("/articleclass/manage",postdata,function (res) {
            setTimeout(function(){
                top.layer.close(index);
                top.layer.msg(postdata.longid>0?"修改成功！":"添加成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },500);
        });

        return false;
    });

    //是否置顶
    form.on('switch(switchEnable)', function(data){
/*        console.log(this.checked ? 'true' : 'false');*/
        var chk=data.elem.checked;
        $("#status").val(chk?1:0);
        console.log($("#status").val());
    })
})