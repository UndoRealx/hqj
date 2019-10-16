var searchAjax=function(){};
var G_tocard_maxTips=30;

$(function(){(
    function(){

        var a=$(".plus-tag");

        $("a em",a).live("click",function(){
            var c=$(this).parents("a"),b=c.attr("title"),d=c.attr("value");
            delTips(b,d)
        });

        hasTips=function(b){
            var d=$("a",a),c=false;
            d.each(function(){
                if($(this).attr("title")==b){
                    c=true;
                    return false
                }
            });
            return c
        };

        isMaxTips=function(){
            return
            $("a",a).length>=G_tocard_maxTips
        };

        setTips=function(c,d){
            if(hasTips(c)){
                return false
            }if(isMaxTips()){
                alert("最多添加"+G_tocard_maxTips+"个标签！");
                return false
            }
            var b=d?'value="'+d+'"':"";
            a.append($("<a "+b+' title="'+c+'" href="javascript:void(0);" ><span>'+c+"</span><em></em></a>"));
            searchAjax(c,d,true);
            return true
        };

        delTips=function(b,c){
            if(!hasTips(b)){
                return false
            }
            $("a",a).each(function(){
                var d=$(this);
                if(d.attr("title")==b){
                    d.remove();
                    return false
                }
            });
            searchAjax(b,c,false);
            return true
        };

        getTips=function(){
            var b=[];
            $("a",a).each(function(){
                b.push($(this).attr("title"))
            });
            return b
        };

        getTipsId=function(){
            var b=[];
            $("a",a).each(function(){
                b.push($(this).attr("value"))
            });
            return b
        };

        getTipsIdAndTag=function(){
            var b=[];
            $("a",a).each(function(){
                b.push($(this).attr("value")+"##"+$(this).attr("title"))
            });
            return b
        }
    }

)()});