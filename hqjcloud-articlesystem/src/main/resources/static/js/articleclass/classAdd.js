layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','layedit','laydate','layRequest'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        req=layui.layRequest,
        $ = layui.jquery;

    form.verify({
        className : function(val){
            if(val == ''){
                return "分类名称不能为空";
            }
        }
    })
    form.on("submit(addClass)",function(data){

        var arr = new Array();
        $("input:checkbox[name='artclass']:checked").each(function(i){
            arr[i] = $(this).val();
        });
        data.field.artclass = arr.join(",");

        console.log($("#artistop").val());

        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#myid").val(),
                arttitle : $("#arttitle").val(),  //文章标题
                artabstract : $("#artabstract").val(),  //文章摘要
                artimage : $("#artimage").attr("src")==undefined?'':$("#artimage").attr("src"),  //缩略图
                artcontent : layedit.getContent(editIndex).split('<audio controls="controls" style="display: none;"></audio>')[0],  //文章内容
                artclass : data.field.artclass,    //文章分类
                artstatus : $('#artstatus input[name="release"]:checked').val(),    //发布状态
                pubTimes : $("#pubtimes").val(),    //发布时间
                istop : $("#artistop").val(),    //是否置顶
            };

        req.post("/article/manage",postdata,function (res) {
            setTimeout(function(){
                top.layer.close(index);
                top.layer.msg(postdata.longid>0?"文章修改成功！":"文章添加成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },500);
        });

        return false;
    })

})