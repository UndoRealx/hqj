layui.config({
    base : '../../static/js/'
});
layui.use(['form','layer','laydate','upload','layRequest'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        laydate = layui.laydate,
        req=layui.layRequest,
        $ = layui.jquery;


    function loadData()
    {
        var mycontent =$("#content").val();
        UE.getEditor('artcontent').setContent(mycontent);
    }
    loadData();

    req.get("/articleclass/list",{},function (res) {

        res.data.forEach(function (e) {
           /* var  chks=$.inArray(e.longid,arrayObj)==-1?"":"checked=\"checked\"";
            console.log(e.longid+chks) “+chks+”*/
            $("#articleclass").append("<p><input type='checkbox' name='artclass' id='artclass"+e.longid+"' value='"+e.longid+"' title='"+e.classname+"' lay-skin='primary'  /></p>");
        });

        form.render();
    });



    if($("#myid").val()!=undefined && $("#myid").val()!=''&& $("#myid").val()!='0')
    {
        req.get("/article/getArticleClassById",{longid:$("#myid").val()},function (res) {
            res.data.forEach(function (e) {
                console.log("#artclass"+e.articleclassid+"");
                $("#artclass"+e.articleclassid+"").prop("checked",true);
            });
        });
        form.render();
    }


    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '../../json/userface.json',
        method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            $('.thumbImg').attr('src',res.data[num].src);
            $('.thumbBox').css("background","#fff");
        }
    });

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());
    laydate.render({
        elem: '#pubtimes',
        type: 'datetime',
        trigger : "click",
        done : function(value, date, endDate){
            submitTime = value;
        }
    });
    form.on("radio(release)",function(data){
        if(data.elem.title == "定时发布"){
            $(".releaseDate").removeClass("layui-hide");
            $(".releaseDate #pubtimes").attr("lay-verify","required");
        }else{
            $(".releaseDate").addClass("layui-hide");
            $(".releaseDate #pubtimes").removeAttr("lay-verify");
            submitTime = time.getFullYear()+'-'+(time.getMonth()+1)+'-'+time.getDate()+' '+time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
        }
    });


    //是否置顶
    form.on('switch(istop)', function(data){
        var chk=data.elem.checked;
        $("#artistop").val(chk?1:0);
        console.log($("#artistop").val());
    })

    form.verify({
        newsName : function(val){
            if(val == ''){
                return "文章标题不能为空";
            }
        },
        content : function(val){
            if(val == ''){
                return "文章内容不能为空";
            }
        }
    })
    form.on("submit(addNews)",function(data){

        var arr = new Array();
        $("input:checkbox[name='artclass']:checked").each(function(i){
            arr[i] = $(this).val();
        });

        data.field.artclass = arr.join(",");
        var tagstr = '';
        var myTags= $("#myTags span");
        myTags.each(function(item,i){
            if (item==myTags.length-1){
                tagstr+=$(this).text();
            } else {
                tagstr+=$(this).text()+','
            }
        });


        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#id").val(),
                arttitle : $("#arttitle").val(),  //文章标题
                artabstract : $("#artabstract").val(),  //文章摘要
                articletag :  tagstr,      //文章标签
                artimage : $("#artimage").attr("src")==undefined?'':$("#artimage").attr("src"),  //缩略图
                artcontent : UE.getEditor('artcontent').getContent(),  //文章内容
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

    //预览
    form.on("submit(look)",function(){
        layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问");
        return false;
    })


    //标签


})