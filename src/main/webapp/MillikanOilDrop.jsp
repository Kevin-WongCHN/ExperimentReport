<%--
  Created by IntelliJ IDEA.
  User: 黄钇茗
  Date: 2021-10-11
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>MillikanOilDrop</title>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="bootstrap-3.4.1-dist/js/jquery.js"></script>
    <script src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<a class="btn btn-info" href="index.jsp" role="button">返回首页</a>
<h3><span class="label label-default">请使用浏览器，输入数据后将提供一份数据报告</span></h3>
<form method="post" action="pdf">
    <div class="form-group">
        <label for="exampleInput">范例（请使用英文半角逗号）</label>
        <input type="email" class="form-control" id="exampleInput" placeholder="10,20,30,40,50">
    </div>
    <div class="form-group">
        <label for="oil1U">油滴1的5个电压值</label>
        <input type="text" class="form-control"  id="oil1U" name="oil1U">
    </div>
    <div class="form-group">
        <label for="oil2U">油滴2的5个电压值</label>
        <input type="text" class="form-control" id="oil2U" name="oil2U">
    </div>
    <div class="form-group">
        <label for="oil3U">油滴3的5个电压值</label>
        <input type="text" class="form-control" id="oil3U" name="oil3U">
    </div>
    <div class="form-group">
        <label for="oil4U">油滴4的5个电压值</label>
        <input type="text" class="form-control" id="oil4U" name="oil4U">
    </div>
    <div class="form-group">
        <label for="oil5U">油滴5的5个电压值</label>
        <input type="text" class="form-control" id="oil5U" name="oil5U">
    </div>
    <div class="form-group">
        <label for="oil1t">油滴1的5个时间值</label>
        <input type="text" class="form-control" id="oil1t" name="oil1t">
    </div>
    <div class="form-group">
        <label for="oil2t">油滴2的5个时间值</label>
        <input type="text" class="form-control" id="oil2t" name="oil2t">
    </div>
    <div class="form-group">
        <label for="oil3t">油滴3的5个时间值</label>
        <input type="text" class="form-control" id="oil3t" name="oil3t">
    </div>
    <div class="form-group">
        <label for="oil4t">油滴4的5个时间值</label>
        <input type="text" class="form-control" id="oil4t" name="oil4t">
    </div>
    <div class="form-group">
        <label for="oil5t">油滴5的5个时间值</label>
        <input type="text" class="form-control" id="oil5t" name="oil5t">
    </div>

    <button type="submit" class="btn btn-success btn-block">提交</button>
</form>
</body>
</html>
