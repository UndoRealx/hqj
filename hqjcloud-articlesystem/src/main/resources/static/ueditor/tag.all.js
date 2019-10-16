//  标签
var selectedText = [];

$(function () {
    var initMarkVal = "1";
    initMarkValue(initMarkVal);

    var initTagVal = "初始值1,初始值2";
    initTagValue(initTagVal);

    $(".label-item").on("click", "li", function () {
        var id = $(this).attr("value");
        var text = $(this).children("span:nth-child(2)").html();
        if ($(this).hasClass("selected")) {
            return false;
        }
        if (addMark(id, text)) {
            $(this).addClass("selected");
        }
    });

    $(".mark-selected").on("click", "li .delete", function () {
        var id = $(this).parent().attr("value");
        $(this).parent().remove();
        resetMarkValue();
        $(".label-item").find("li[value='" + id + "']").removeClass("selected");
    });

    $("#add-tag").on("click", function () {
        var tagName = $("#tagName").val();
        if (tagName != null && tagName != "") {
            var index = selectedText.indexOf(tagName);
            if (index !== -1)     //已经存在于已选择，不添加
            {
                alert("合作单位已存在！");
                return;
            } else {
                addTag(0, tagName);
                $("#tagName").val('');
            }
        } else {
            alert("请填写合作单位！");
        }
    });

    $(".tag-selected").on("click", "li .delete", function () {
        $(this).parent().remove();
        resetTagText();
    });
});

function initMarkValue(val) {
    $("input[name='mark_label']").val(val);
    if (val) {
        var valArr = val.split(',');
        var len = $(".label-item").children("li").length;
        for (var i = 0; i < len; i++) {
            $this = $(".label-item").children("li").eq(i);
            var id = $this.attr("value");
            var text = $this.children("span:nth-child(2)").html();

            if ($.inArray(id, valArr) >= 0) {
                var labelHTML = getAppendHTML(id, text);
                $(".mark-selected").append(labelHTML);
                $this.addClass("selected");
            }
        }
    }
}

function initTagValue(val) {
    $("input[name='tag_label']").val(val);
    if (val) {
        var valArr = val.split(',');
        var len = valArr.length;
        for (var i = 0; i < len; i++) {
            var labelHTML = getAppendHTML(i, valArr[i]);
            $(".tag-selected").append(labelHTML);
        }
    }
}

function resetMarkValue() {
    var val = '';
    var len = $(".mark-selected").children("li").length;
    for (var i = 0; i < len; i++) {
        var value = $(".mark-selected").children("li").eq(i).attr("value");
        val += value + ',';
    }
    $("input[name='mark_label']").val(val);
}

function addMark(id, text) {
    var labelHTML = getAppendHTML(id, text);
    $(".mark-selected").append(labelHTML);
    resetMarkValue();
    return true;
}

function addTag(id, text) {
    var labelHTML = getAppendHTML(id, text);
    $(".tag-selected").append(labelHTML);
    resetTagText();
    return true;
}

function resetTagText() {
    selectedText = [];
    var valtext = '';
    var text;
    var len = $(".tag-selected").children("li").length;
    for (var i = 0; i < len; i++) {
        text = $(".tag-selected").children("li").eq(i).text();
        selectedText[i] = text;
        valtext += selectedText[i] + ',';
    }
    $("input[name='tag_label']").val(valtext);
}

//提交按钮
function submit() {
    var markVal = $("input[name='mark_label']").val();
    var tagVal = $("input[name='tag_label']").val();
    alert(markVal);
    alert(tagVal);
}

//获取添加文本
function getAppendHTML(id, text) {
    return "<li value='" + id + "''>" + $.trim(text) + "<div class='delete'></div></li>";
}
