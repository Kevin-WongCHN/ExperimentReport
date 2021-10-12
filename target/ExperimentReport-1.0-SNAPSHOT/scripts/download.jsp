<%--
  Created by IntelliJ IDEA.
  User: 黄钇茗
  Date: 2021-10-11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>download</title>
    <link rel="stylesheet" href="../bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="../bootstrap-3.4.1-dist/js/jquery.js"></script>
    <script src="../bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <%HttpSession sesison=request.getSession();
    String timestamp= (String) sesison.getAttribute("timestamp");%>
</head>
<body>
<form action="download">
    <div class="form-group">
        <label for="exampleInputEmail1">请复制以下时间戳提交</label>
        <input type="text" class="form-control" id="exampleInputEmail1" value="<%=timestamp%>">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="filename">
    </div>

    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
