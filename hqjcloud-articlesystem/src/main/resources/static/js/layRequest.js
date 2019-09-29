layui.define(['element','jquery'],function(exports) {
    var el = layui.element;
    var $ = layui.$;

//封装AJAX请求
    function ajax(type, url, data, successCallBack) {
       // var index = layer.msg('正在处理中，请稍候', {icon: 16, time: false, shade: 0.8});
        //var index = layer.load(0,  { shade: [0.5, '#393D49'] });
        $.ajax({
            //添加请求头
   /*           headers: {
                 /!* 'Token': $.cookie("token"),*!/
                  "Content-Type": "application/json;charset=UTF-8"
              },*/
            url: url,
            dataType: "json", //数据格式
            data: data,//JSON.stringify(data),
            type: type, //请求方式
            async: false, //是否异步请求
            timeout: 30000, //超时时间：30秒
            //cache: false,// 配置为false时，表示不从浏览器缓存中获取数据，调试时可以看到，发Get请求时，会自动加上时间戳
            crossDomain: true == !(document.all),
            beforeSend: function () {

                /*  var token = $.cookie("token");
                  //发送请求，如果token为空，跳转到登录页面
                  if (token === undefined || token === "") {
                      var url = window.document.location.href;
                      if (url.indexOf('login.html') > -1) {} else {
                          window.location.href = "../../login.html"
                      }
                  }*/
            },
            success: function (res) {
                if (res.code == "0") {
                    if (null == successCallBack || successCallBack == undefined) {
                        layer.alert(res.msg);
                    } else {
                        return successCallBack(res);
                    }
                } else {
                    layer.alert(res.msg, {
                        icon: 5,
                        title: "提示"
                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
               /* setTimeout(function () {
                    layer.close(index);
                }, 500);*/
            },
            error: function (XMLHttpRequest, textStatus) {
                /*         console.log(XMLHttpRequest.status);
                         console.log(XMLHttpRequest.readyState);
                         console.log(textStatus);*/
                //请求出错处理
                layer.alert('系统繁忙，请稍后', {
                    icon: 5,
                    title: "提示"
                });
            }
        });
    }

    /**
     * 发送post请求
     * @param {发送请求路径} url
     * @param {JSON数据} data
     * @param {发送成功回调函数} success
     */
    function post(url, data, successCallBack) {
        ajax('post', url, data, function (res) {
            return successCallBack(res);
        });
    }

    /**
     * 发送GET请求
     * @param {发送请求路径} url
     * @param {JSON数据} data
     * @param {发送成功回调函数} success
     */
    function get(url, data, successCallBack) {
        ajax('get', url, data, function (res) {
            return successCallBack(res);
        });
    }
    /**
    *@Description 发送PUT请求
     * @param {发送请求路径} url
     * @param {JSON数据} data
     * @param {发送成功回调函数} success
    *@Author lic
    *@Date 2019/9/25
    *@Time 15:54
    */
    function put(url, data, successCallBack) {
        ajax('put', url, data, function (res) {
            return successCallBack(res);
        });
    }

    /**
     * 发送Delete请求
     * @param {发送请求路径} url
     * @param {JSON数据} data
     * @param {发送成功回调函数} success
     */
    function del(url, data, successCallBack) {

        ajax('post', url, data, function (res) {
            return successCallBack(res);
        });
    }

    var obj={ajax,post,get,del,put};
    exports('layRequest',obj);
/*    export('layRequest',apiGet);
    export('layRequest',apiDelete);*/
})