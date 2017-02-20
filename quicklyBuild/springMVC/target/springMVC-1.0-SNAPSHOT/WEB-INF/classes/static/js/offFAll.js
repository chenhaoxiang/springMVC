var jq$ = jQuery.noConflict(); //防止$符号与其他的冲突
jq$(document).ready(function () {   //防止在DOM元素加载完成就执行jQuery代码，从而避免产生不必要的错误
    jq$("*").keydown(function (e) {//判断按键
        e = window.event || e || e.which;
        if (e.keyCode == 112 || e.keyCode == 113
            || e.keyCode == 114 || e.keyCode == 115
            || e.keyCode == 116 || e.keyCode == 117
            || e.keyCode == 118 || e.keyCode == 119
            || e.keyCode == 120 || e.keyCode == 121
            || e.keyCode == 122 || e.keyCode == 123) {
            //最好给上返回首页的地址
            if(e.keyCode == 123){
                alert('物有所值。尊重原创者的版权！请见谅。');
                window.location="about:blank"; //将当前窗口跳转置空白页
            }
            e.keyCode = 0;
            return false;
        }
    });
    //document.onhelp = function () { return false };//
    window.onhelp = function () { return false };//ie下面不能屏蔽f1键的补充方法,和上面的一行的效果是一样的，选其一
});