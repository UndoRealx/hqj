// 更新选中标签标签
$(function(){
    setSelectTips();
    $('.plus-tag').append($('.plus-tag a'));
});
var searchAjax = function(name, id, isAdd){
    setSelectTips();
};
// 搜索
(function(){
    var $b = $('.plus-tag-add button'),$i = $('.plus-tag-add input');
    $i.keyup(function(e){
        if(e.keyCode == 13){
            $b.click();
        }
    });
    $b.click(function(){
        var name = $i.val().toLowerCase();
        if(name != '') setTips(name,-1);
        $i.val('');
        $i.select();
    });
})();
// 推荐标签
(function(){
    var str = ['展开推荐标签', '收起推荐标签']
    $('.plus-tag-add a').click(function(){
        var $this = $(this),
            $con = $('#mycard-plus');

        if($this.hasClass('plus')){
            $this.removeClass('plus').text(str[0]);
            $con.hide();
        }else{
            $this.addClass('plus').text(str[1]);
            $con.show();
        }
    });
    $('.default-tag a').live('click', function(){
        var $this = $(this),
            name = $this.attr('title'),
            id = $this.attr('value');
        setTips(name, id);
    });
    // 更新高亮显示
    setSelectTips = function(){
        var arrName = getTips();
        if(arrName.length){
            $('#myTags').show();
        }else{
            $('#myTags').hide();
        }
        $('.default-tag a').removeClass('selected');
        $.each(arrName, function(index,name){
            $('.default-tag a').each(function(){
                var $this = $(this);
                if($this.attr('title') == name){
                    $this.addClass('selected');
                    return false;
                }
            })
        });
    }

})();
// 更换链接
(function(){
    var $b = $('#change-tips'),
        $d = $('.default-tag div'),
        len = $d.length,
        t = 'nowtips';
    $b.click(function(){
        var i = $d.index($('.default-tag .nowtips'));
        i = (i+1 < len) ? (i+1) : 0;
        $d.hide().removeClass(t);
        $d.eq(i).show().addClass(t);
    });
    $d.eq(0).addClass(t);
})();

//添加标签
layui.use(['from','layedit','element','jquery'],function () {
    var form = layui.form,
        layer = layui.layer,
            element = layui.element,
            $ = layui.jquery;
    $(document).on('click','#btn',function () {
        layer.alert('添加成功')
    })
})
