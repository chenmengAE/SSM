<%--
  Created by IntelliJ IDEA.
  User: Q源
  Date: 2023/2/15
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>商品后台管理员登录页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 在web项目中 css的路径要替换为 css文件的uri
    也就是 /项目名/css/style.css
    -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">

            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">商品管理</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                管理员注册
            </h1>
            <form action="${pageContext.request.contextPath}/user/register.do" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            管理员账户:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            确认密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password1" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="code" />
                            <img src="${pageContext.request.contextPath}/validateCode" height="40px"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            <a href="${pageContext.request.contextPath}/login.jsp">管理员账户登录</a>
                        </td>
                        <td valign="middle" align="left">
                            <input type="submit" class="button" value="注册 &raquo;" />&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" class="button" value="重置 &raquo;" />
                        </td>
                    </tr>
                </table>
                <p>

                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            www.haust.com.cn
        </div>
    </div>
</div>
</body>
</html>

