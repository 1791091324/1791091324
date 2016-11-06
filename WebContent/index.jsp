<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ taglib uri="/WEB-INF/MyTaglib.tld" prefix="mytag"%>  
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>  
  
<!-- 分页样式(附件中css.css文件) -->  
<link rel="stylesheet" type="text/css" href="${ctx }/res/styles/paginationStyle.css">  
  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
      
    <title>用户列表</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
      
  </head>  
    
  <body>  
    <form action="${ctx }/admin/user" method="post" name="userListForm">  
        <input type="hidden" name="operation" value="list"/>  
          
        <!-- 为了兼容ie -->  
        <input type="hidden" name="pageNo" value="${pagination.pageNo }">  
          
        <table border="1">  
            <caption>用户列表</caption>  
            <tr>  
                <td>用户标识</td>  
                <td>用户名</td>  
                <td>真实姓名</td>  
                <td>性别</td>  
                <td>注册日期</td>  
                <td>删除标志</td>  
                <td colspan="3">  
                    操作&nbsp;&nbsp;  
                    <a href="${ctx }/admin/user?operation=add">添加用户</a>  
                </td>  
            </tr>  
            <c:forEach var="user" items="${pagination.records}">  
                <tr>  
                    <td>${user.id }</td>  
                    <td>${user.userName }</td>  
                    <td>${user.realName }</td>  
                    <td>${user.gender }</td>  
                    <td>${user.registerDate }</td>  
                    <td>${user.deleteFlag }</td>  
                    <td>  
                        <c:choose>  
                            <c:when test="${user.deleteFlag==0}">  
                                <a href="${ctx }/admin/user?operation=delete&id=${user.id }&pageNo=${pagination.pageNo }">删除</a>  
                            </c:when>  
                            <c:otherwise>  
                                <a href="${ctx }/admin/user?operation=recover&id=${user.id }&pageNo=${pagination.pageNo }">恢复</a>  
                            </c:otherwise>  
                        </c:choose>  
                    </td>  
                    <td><a href="${ctx }/admin/user?operation=edit&id=${user.id }">编辑</a></td>  
                    <td><a href="${ctx }/admin/user?operation=info&id=${user.id }">查看</a></td>  
                </tr>  
            </c:forEach>  
        </table>  
        <mytag:Pagination pagination="${pagination}" queryForm="userListForm" divId="pagaId" />  
    </form>  
  </body>  
</html>