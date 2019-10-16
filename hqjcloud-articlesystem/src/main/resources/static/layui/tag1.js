var FancyForm=function(){
    return{
        inputs:".FancyForm input, .FancyForm textarea",
        setup:function(){
            var a=this;
            this.inputs=$(this.inputs);
            a.inputs.each(function(){
                var c=$(this);
                a.checkVal(c)
            });
            a.inputs.live("keyup blur",function(){
                var c=$(this);
                a.checkVal(c);
            });
        },checkVal:function(a){
            a.val().length>0?a.parent("li").addClass("val"):a.parent("li").removeClass("val")
        }
    }
}();