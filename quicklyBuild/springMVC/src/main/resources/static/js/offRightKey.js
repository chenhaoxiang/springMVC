/**
 * Created by 陈浩翔 on 2016/12/22.
 */

//下面这句是禁止复制 也禁止了快捷键复制 还禁止了鼠标右键
document.body.onselectstart=document.body.oncontextmenu=function(){return false;}
