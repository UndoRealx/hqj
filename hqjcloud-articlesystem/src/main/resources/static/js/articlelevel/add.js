layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','layRequest'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        req=layui.layRequest,
        $ = layui.jquery;

    req.get("/platform/list",{},function (res) {
        var _platformid=$("#hid_platform_Id").val();
        console.log(_platformid);
        $("#platform_id").append("<option value='-1'>请选择平台</option>");
        res.data.forEach(function (e) {
            if(_platformid!=undefined&&_platformid!=null&&e.longid==_platformid)
            {
                $("#platform_id").append("<option selected value='"+e.longid+"' >"+e.platformName+"</option>");
            }
            else
            {
                $("#platform_id").append("<option value='"+e.longid+"'>"+e.platformName+"</option>");
            }
        });
        form.render();
        if(_platformid!=undefined&&_platformid!=null) {
            loadLevel(_platformid);
        }
    });


    function loadLevel(platid)
    {
        var _levelparent_Id=$("#hid_levelparent_Id").val();

        req.get("/articlelevel/list",{platformId:platid,parentId:0},function (res) {
            console.log(res.data);
            $("#top_level_id").empty();
            $("#top_level_id").append("<option value='0' '+(_levelparent_Id==0?'selected':'')+'>顶级栏目</option>");
            res.data.forEach(function (e) {
                if(_levelparent_Id!=undefined&&_levelparent_Id!=null&&e.longid==_levelparent_Id) {
                    $("#top_level_id").append("<option selected value='" + e.longid + "'>" + e.levelName + "</option>");
                }
                else
                {
                    $("#top_level_id").append("<option value='" + e.longid + "'>" + e.levelName + "</option>");
                }
            });
            form.render();
        });
    }

    layui.use(['form'], function() {
        form=layui.form;
        form.on('select(platformType)', function(data){
            var val=data.value;
            console.info(val);
            if(val!=-1)
            {
                loadLevel(val);
            }
        });
    });


    form.on("submit(add)",function(data){

        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#longid").val(),
                levelName : $("#levelName").val(),
                platformId:$("#platform_id").val(),
                levelParentid:$("#top_level_id").val(),
                levelStatus : $("#status").val()
            };

        console.log(postdata);

        req.post("/articlelevel/manage",postdata,function (res) {
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