package com.yiming.experimentreport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        HttpSession session = req.getSession();
        String experimentName = (String)session.getAttribute("experimentName");
        String timestamp=req.getParameter("timestamp");
        String filename="downloads/"+experimentName+timestamp+".pdf/"+experimentName+timestamp+".pdf";
        //2.使用字节输入流加载文件到内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(filename);
        //2.1用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //解决中文名乱码问题
        //获取浏览器请求头
        String userAgent = resp.getHeader("user-agent");
        //使用DownLoadUtils工具类方法，处理编码格式
        filename =Utils.getFileName(userAgent, filename);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式：content-disposition
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len=fis.read(bytes))!=-1){
            sos.write(bytes,0,len);
        }
    }

}