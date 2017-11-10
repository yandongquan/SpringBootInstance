
$(function () {
  $('[data-toggle="popover"]').popover({
    html:true,//开启html 为true的话，data-content里就能放html代码了
  })
}) ;
/*动态内容是在 popover 弹出(shown)后加载的, 也就是 popover div 的位置已经固定了,渲染内容后整体的位置可能不是你所期望的!*/
$(function () { $('[data-toggle="popover"]').popover('show');});
$(function () { $('[data-toggle="popover"]').popover('hide');});
$("#juan").popover({
    trigger : "hover click",
    html:true,
    content:juanMethod(),
   // title:"捐助",
    placement:"left",
});
function juanMethod() {
    return '<table class=""><tr><td><img style="padding: 2px;width:120px;background-color: #fff;border: 1px solid #ddd;" src="static/images/alipay.png"/></td><td><img style="padding: 2px;width:120px;background-color: #fff;border: 1px solid #ddd;" src="static/images/weixin.png"/></td></tr><tr align="center"><td><font color="#F0AD4E">支付宝二维码</font></td><td><font color="#F0AD4E" >微信二维码</font></td></tr></table>' ;
}
