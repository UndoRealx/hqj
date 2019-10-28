layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','layRequest'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        req=layui.layRequest,
        $ = layui.jquery;

    form.on("submit(add)",function(data){

        /*  layer.alert(JSON.stringify(data.field), {
              title: '最终的提交信息'
          })
          return false;*/

        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#longid").val(),
                tagName : $("#tagName").val(),
                addTime : $("#addTime").val(),
                tagStatus : $("#status").val()
                // tagstatus : $("#status").val()
                /*status : $("#status").val()*/
            };

        req.post("/tag/manage",postdata,function (res) {
            setTimeout(function(){

                console.log("dewda"+res);
                top.layer.close(index);
                top.layer.msg(data.longid>0?"修改成功！":"添加成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },500);
        });

        return false;
    });


    //添加标签
    function loadTag(tag_Id){
        var _tag_Id = $("#hid_tag_Id").val();

        req.get("/tag/list", {tagId:tag_Id, parentId:0},function (res) {
            console.log(res.dada);
            $("#top_tag_id").empty();
            $("#top_tag_id").append()
            res.data.forEach(function (e) {
                if(hid_tag_Id!=undefined&&hid_tag_Id!=null&&e.longid==hid_tag_Id){
                    $("#hid_tag_Id").append("<option value='" + e.longid + "'>" + e.tagName + "</option>")
                }
            });
            form.render();
        })
    }
    //是否置顶
    form.on('switch(switchEnable)', function(data){
        /*        console.log(this.checked ? 'true' : 'false');*/
        var chk=data.elem.checked;
        $("#status").val(chk?1:0);
        console.log($("#status").val());
    })
})