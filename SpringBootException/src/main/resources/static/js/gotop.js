var obj = document.getElementById('top');
    var scrollTop = null;

    // 置顶对象点击事件
    obj.onclick = function() {
        var timer = setInterval(function() {
            window.scrollBy(0, -100);
            if (scrollTop == 0)
                clearInterval(timer);
        }, 2);
    }

    // 窗口滚动检测
    window.onscroll = function() {
        scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
        obj.style.display = (scrollTop >= 300) ? "block" : "none";
}

// 加入收藏 < a onclick="AddFavorite(window.location,document.title)" >加入收藏< /a>
function AddFavorite(sURL, sTitle){
    try{
        if(document.all){
            window.external.addFavorite(sURL, sTitle);
        }else if(window.sidebar){
            window.sidebar.addPanel(sTitle, sURL, "");
        }else{
            alert("亲，您的浏览器不支持此操作\n请直接使用Ctrl+D收藏本站~")
        }
    }catch (e){
        alert("加入收藏失败，请使用Ctrl+D进行添加");
    }
}

//设为首页 < a onclick="SetHome(this,window.location)" > 设为首页 < /a>
function SetHome(obj,vrl){
        try{
                obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
        }
        catch(e){
                if(window.netscape) {
                        try {
                                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                        }
                        catch (e) {
                                alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
                        }
                        var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                        prefs.setCharPref('browser.startup.homepage',vrl);
                 }
        }
}
