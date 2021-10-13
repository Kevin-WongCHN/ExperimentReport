<%@ page import="java.io.InputStream" %>
<%@ page import="com.yiming.experimentreport.Generate" %>
<%@ page import="java.util.Properties" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String experimentName="MeasurementOfSound";
    session.setAttribute("experimentName",experimentName);
    InputStream propertiesStream = Generate.class.getClassLoader().getResourceAsStream(experimentName+".properties");
    Properties properties = new Properties();
    properties.load(propertiesStream);
    String inputNum = properties.getProperty("inputNum");
    int inputNumint = Integer.parseInt(inputNum);
%>
<html>
<head>
    <title><%=experimentName%></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="bootstrap-3.4.1-dist/js/jquery.js"></script>
    <script src="bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<a class="btn btn-info" href="index.jsp" role="button">返回首页</a>
<h3><span class="label label-default">请使用浏览器，输入数据后将提供一份pdf数据报告</span></h3>
<form method="post" action="pdf">
    <div class="form-group">
        <label for="exampleInput">范例（请使用英文半角逗号）</label>
        <input type="email" class="form-control" id="exampleInput" placeholder="10,20,30,40,50">
    </div>
    <% for (int i = 1; i <=inputNumint; i++) { %>

    <div class="form-group">
        <label for="<%=i%>"><%=new String(properties.getProperty("prompt"+i).getBytes("iso8859-1"),"UTF-8")%></label>
        <input type="text" class="form-control"  id="<%=i%>" name="<%=i%>">
    </div>

    <% } %>


    <button type="submit" class="btn btn-success btn-block">提交</button>
</form>
<% for (int i = 1; i <=inputNumint; i++) { %>

<% } %>
</body>
</html>
