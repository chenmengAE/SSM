<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/2/14
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 在web项目中 css的路径要替换为 css文件的uri
    也就是 /项目名/css/style.css
    -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
                <div style="float:left">欢迎<%=session.getAttribute("username")%></div>
            </h1>
            <h5>&nbsp;</h5>
            <form action="${pageContext.request.contextPath}/product/selectProductByNameAndPrice.do">
                商品名:<input type="text" name="productName" />
                价格：<select name="operation">
                <option value="0">=</option>
                <option value="1">></option>
                <option value="2"><</option>
            </select>
                <input  type="number" name="price"/>
                <input type="submit" value="搜索"/>
            </form>
            <h5 style="height: 2px;">&nbsp;</h5>
           <form action="${pageContext.request.contextPath}/product/deleteProducts.do">
            <table class="table">
                <tr class="table_header">
                    <td>
                        <input type="submit" value="删除选中"  />
                    </td>
                    <td>
                        商品名
                    </td>
                    <td>
                        单价
                    </td>
                    <td>库存</td>

                    <td>
                        商品描述
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach var="p" items="${PageInfo.list}">
                    <tr>
                        <td>
                            <input type="checkbox" name="ids" value="${p.productId}"/>
                        </td>
                        <td>
                            ${p.productName}
                        </td>
                        <td>
                            ${p.price}
                        </td>
                        <td>
                            ${p.inventory}
                        </td>
                        <td>
                            ${p.description}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/deleteProductById.do?id=${p.productId}">删除</a>
                            <a href="${pageContext.request.contextPath}/product/selectProductById.do?id=${p.productId}">修改</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
           </form>

            <div>
                <p>
                        <a href="${pageContext.request.contextPath}/product/${methodName}.do?&productName=${param.productName}&price=${param.price}&operation=${param.operation}" class="button">首页</a>
                    <c:if test="${PageInfo.hasPreviousPage}">

                    <a href="${pageContext.request.contextPath}/product/${methodName}.do?currentPage=${PageInfo.prePage}&productName=${param.productName}&price=${param.price}&operation=${param.operation}" class="button">上一页</a>

                    </c:if>

                    <c:forEach var="array" items="${PageInfo.navigatepageNums}">
                        <c:choose>
                            <c:when test="${PageInfo.pageNum == array}">
                                <a href="#">${array}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/product/${methodName}.do?currentPage=${array}&productName=${param.productName}&price=${param.price}&operation=${param.operation}">${array}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${PageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/product/${methodName}.do?currentPage=${PageInfo.nextPage}&productName=${param.productName}&price=${param.price}&operation=${param.operation}" class="button">下一页</a>
                    </c:if>
                        <a href="${pageContext.request.contextPath}/product/${methodName}.do?currentPage=${PageInfo.pages}&productName=${param.productName}&price=${param.price}&operation=${param.operation}" class="button">尾页</a>
                </p>
            </div>
            <div>
                <span>当前第${PageInfo.pageNum}页</span>
                <span>共有${PageInfo.pages}页</span>
                <span>共有${PageInfo.total}条记录</span>
            </div>

            <p>
                <a href="${pageContext.request.contextPath}/product/addProduct.jsp" class="button">添加商品</a>
            </p>
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
