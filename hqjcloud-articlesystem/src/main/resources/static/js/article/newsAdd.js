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

    window.refreshTags=function()
    {
        $("#keyList").html('')
        req.get("/tag/getByRand",{page:1,size:10},function (res) {
            console.log(res.data);
            res.data.list.forEach(function (e) {
                $("#keyList").append("<a title='"+e.tagName+"' href='javascript:void(0);'  onclick=tagSelect('"+e.tagName+"')><span>"+e.tagName+"</span></a>&nbsp;&nbsp;");
            });
            form.render();
        });
    };

    window.tagSelect = function(key){
         var  tagsval=$("#arttags").val().split(",");

         var isExist=false;
        $.each(tagsval, function(i,val){

            if(val.trim()==key.trim())
            {
                isExist=true;
            }
        });
        if(isExist==false) {
            tagsval = tagsval + key + ',';
            $("#arttags").val(tagsval);
        }
    };
/*
    req.get("/articleclass/list",{},function (res) {
        console.log(res.data);
        res.data.forEach(function (e) {
           /!* var  chks=$.inArray(e.longid,arrayObj)==-1?"":"checked=\"checked\"";
            console.log(e.longid+chks) “+chks+”*!/

            $("#articleclass").append("<p><input type='checkbox' name='artclass' id='artclass"+e.longid+"' value='"+e.longid+"' title='"+e.className+"' lay-skin='primary'  /></p>");
        });

        form.render();
    });
*/


    req.get("/platform/list",{},function (res) {


        $("#platform_id").append("<option value='0'>请选择平台</option>");
        res.data.forEach(function (e) {
            $("#platform_id").append("<option value='"+e.longid+"'>"+e.platformName+"</option>");
        });

        form.render();
    });



   /* if($("#myid").val()!=undefined && $("#myid").val()!=''&& $("#myid").val()!='0')
    {
        req.get("/article/getArticleClassById",{longid:$("#myid").val()},function (res) {
            res.data.forEach(function (e) {

                $("#artclass"+e.articleclassid+"").prop("checked",true);
            });
        });
        form.render();
    }*/


    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '/ueditor/multiUpload',
        acceptMime: 'image/*',

        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res,index, upload){

            var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息

            if(res.state=="SUCCESS")
            {
                $('.thumbImg').attr('src','/Path/'+res.url);
                $('.thumbBox').css("background","#fff");
                form.render();
            }
            else
            {
                layui.alert(res.title);
            }
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
        console.log(data);
        if(data.elem.title == "定时发布"){
            $(".releaseDate").removeClass("layui-hide");
            $(".releaseDate #pubtimes").attr("lay-verify","required");
        }else{
            $(".releaseDate").addClass("layui-hide");
            $(".releaseDate #pubtimes").removeAttr("lay-verify");
            submitTime = time.getFullYear()+'-'+(time.getMonth()+1)+'-'+time.getDate()+' '+time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
        }
    });

    function loadTopLevel(val)
    {
        req.get("/articlelevel/list",{platformId:val,parentId:0},function (res) {

            $("#top_level_id").empty();
            $("#sec_level_id").empty();
            $("#top_level_id").append("<option value='-1'>请选择一级栏目</option>");
            res.data.forEach(function (e) {
                $("#top_level_id").append("<option value='"+e.longid+"'>"+e.levelName+"</option>");
            });
        });
    }

    function loadSecLevel(val)
    {
        req.get("/articlelevel/list",{platformId:0,parentId:val},function (res) {

            $("#sec_level_id").empty();
            $("#sec_level_id").append("<option value='-1'>请选择二级栏目</option>");
            res.data.forEach(function (e) {
                $("#sec_level_id").append("<option value='"+e.longid+"'>"+e.levelName+"</option>");
            });
        });
    }

    layui.use(['form'], function() {
        form=layui.form;
        form.on('select(platformType)', function(data){
            var val=data.value;
            console.info(val);
            if(val!=-1)
            {
                loadTopLevel(val);
                form.render();
            }
        });
        form.on('select(topLevelType)', function(data){
            var val=data.value;
            console.info(val);
            if(val!=-1)
            {
                loadSecLevel(val);
                form.render();
            }
        });
    });

    function loadData()
    {
        var mycontent =$("#hid_content").val();
        UE.getEditor('artcontent').setContent(mycontent);

        $("#platform_id").val($("#hid_platform_id").val());
        loadTopLevel($("#hid_platform_id").val());
        $("#top_level_id").val($("#hid_top_level_id").val());
        loadSecLevel($("#hid_top_level_id").val());
        $("#sec_level_id").val($("#hid_sec_level_id").val());
        form.render();
    }
    loadData();

    //是否置顶
    form.on('switch(istop)', function(data){
        var chk=data.elem.checked;
        $("#artistop").val(chk?1:0);

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

    //添加文章
    form.on("submit(addNews)",function(data){

        var arr = new Array();
        $("input:checkbox[name='artclass']:checked").each(function(i){
            arr[i] = $(this).val();
        });

        data.field.artclass = arr.join(",");


        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        var postdata=
            {
                longid : $("#myid").val(),
                artTitle : $("#arttitle").val(),  //文章标题
                artAbstract : $("#artabstract").val(),  //文章摘要
                artTags :  $("#arttags").val(),     //文章标签
                artImage : $("#artimage").attr("src")==undefined?'':$("#artimage").attr("src"),  //缩略图
                artContent : UE.getEditor('artcontent').getContent(),  //文章内容
                artClass : data.field.artclass,    //文章分类
                artStatus : $('#artstatus input[name="release"]:checked').val(),    //发布状态
                pubTimes : $("#pubtimes").val(),    //发布时间
                isTop : $("#artistop").val(),    //是否置顶
                platformId : $("#platform_id").val(),
                topLevelId  : $("#top_level_id").val(),
                secLevelId  : $("#sec_level_id").val(),
                artFrom  : $("#artfrom").val(),
                artAuthor  : $("#artauthor").val()
            };
        console.log(postdata);

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