<%--
  Created by IntelliJ IDEA.
  User: 15964
  Date: 2023/3/26
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AutoLogin</title>

</head>
<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">
<%
    Cookie[] cookies = request.getCookies();
    String UserName = null;
    String Pwd = null;
    if(cookies.length>0){
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("cookieUName")&&cookie.getValue()!=null){
                UserName=cookie.getValue();
            }
            if(cookie.getName().equals("cookieUPwd")&&cookie.getValue()!=null) {
                Pwd = cookie.getValue();
            }
        }
    }
    if(UserName == null || Pwd==null){
        response.setHeader("refresh","0;URL=login.html");
    }
%>
<form class="form col-md-12 center-block" action="doLogin.do"  method="post">
    <div class="form-group">
        <input type="text" name="userName" value="<%=UserName%>" class="form-control input-lg" placeholder="用户名">
    </div>
    <div class="form-group">
        <input type="password" name="pwd"  value="<%=Pwd%>" class="form-control input-lg" placeholder="密码">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="autoLogin"> 下一次自动登录
        </label>
    </div>
    <div class="btn-group pull-right">
        <button class="reset btn btn-default">重置</button>
        <button class="submit btn btn-primary">登录</button>
    </div>
</form>
</body>
</html>
