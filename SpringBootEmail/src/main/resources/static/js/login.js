/**
 * Created by yando on 2017/11/22.
 */
$('.select__label').click(function() {
    $('.select__label').removeClass('select__label--active');
    $(this).addClass('select__label--active');
});

$('#js-usr-rtn').click(function() {
    $('#js-btn, .pointer, #js-field__pass').removeClass('--usr-new --usr-rst ui-field--hidden');
    $('#js-btn, .pointer').addClass('--usr-rtn');
    $('#js-field__r-pass').addClass('ui-field--hidden');
});
$('#js-usr-new').click(function() {
    $('#js-btn, .pointer, #js-field__r-pass, #js-field__pass').removeClass('--usr-rtn --usr-rst ui-field--hidden');
    $('#js-btn').addClass('--usr-new');
});
$('#js-usr-rst').click(function() {
    $('#js-btn, .pointer').removeClass('--usr-rtn --usr-new');
    $('#js-btn, .pointer').addClass('--usr-rst');
    $('#js-field__r-pass, #js-field__pass').addClass('ui-field--hidden');
});

$("#js-btn").click(function() {
    var data = {} ;
    var name = $("#js-btn").attr('class') ;
    var url = "" ;
    if(name.indexOf("rtn")>0) {
        data.userEmail = $("#js-field__email").val() ;
        data.userPass = $("#js-field__pass").val() ;
        url = "/user/login" ;
    } else if(name.indexOf("new")>0) {
        data.userEmail = $("#js-field__email").val() ;
        data.userPass = $("#js-field__pass").val() ;
        data.userRepass = $("#js-field__r-pass").val() ;
        url = "/user/register" ;
    } else if(name.indexOf("rst")>0) {
        data.userEmail = $("#js-field__email").val() ;
        url = "/user/forget" ;
    }
    submit(data, url) ;
});

function submit(data,url) {
    $.ajax({
        cache: !1,
        type: "POST",
        url: url,
        data: data,
        async: !0,
        beforeSend: function () {
            $("#js-btn").html("提交中..."), $("#js-btn").attr("disabled", "disabled")
        },
        success: function (data) {
            var result  = jQuery.parseJSON(data);
            layer.alert(result.message);
        },
        complete: function () {
            $("#js-btn").html("success"), $("#js-btn").removeAttr("disabled")
        }
    })
}
