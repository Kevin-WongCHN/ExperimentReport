package com.yiming.experimentreport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
@WebServlet("/pd")
public class GeneratePDF extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String oil1U = req.getParameter("oil1U").trim();
        String[] u1 = oil1U.split(",");

        String oil2U = req.getParameter("oil2U").trim();
        String[] u2 = oil2U.split(",");

        String oil3U = req.getParameter("oil3U").trim();
        String[] u3 = oil3U.split(",");

        String oil4U = req.getParameter("oil4U").trim();
        String[] u4 = oil4U.split(",");

        String oil5U = req.getParameter("oil5U").trim();
        String[] u5 = oil5U.split(",");

        String oil1t = req.getParameter("oil1t").trim();
        String[] t1 = oil1t.split(",");

        String oil2t = req.getParameter("oil2t").trim();
        String[] t2 = oil2t.split(",");

        String oil3t = req.getParameter("oil3t").trim();
        String[] t3 = oil3t.split(",");

        String oil4t = req.getParameter("oil4t").trim();
        String[] t4 = oil4t.split(",");

        String oil5t = req.getParameter("oil5t").trim();
        String[] t5 = oil5t.split(",");

        String[] cmdPython={"/usr/local/Python3/bin/python3","/usr/local/tomcat9/webapps/ExperimentReport/scripts/GenerateExcel.py"
                ,u1[0],u1[1],u1[2],u1[3],u1[4]
                ,u2[0],u2[1],u2[2],u2[3],u2[4]
                ,u3[0],u3[1],u3[2],u3[3],u3[4]
                ,u4[0],u4[1],u4[2],u4[3],u4[4]
                ,u5[0],u5[1],u5[2],u5[3],u5[4]
                ,t1[0],t1[1],t1[2],t1[3],t1[4]
                ,t2[0],t2[1],t2[2],t2[3],t2[4]
                ,t3[0],t3[1],t3[2],t3[3],t3[4]
                ,t4[0],t4[1],t4[2],t4[3],t4[4]
                ,t5[0],t5[1],t5[2],t5[3],t5[4]};
        try {
            Process process = Runtime.getRuntime().exec(cmdPython);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String timestamp="";
            String line = "";
            while ((line = in.readLine()) != null) {
                timestamp+=line;
            }
            String[] split = timestamp.split(",,");
            timestamp=split[1];
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
//            int re = process.waitFor();
//            System.out.println(re);
            HttpSession session = req.getSession();
            session.setAttribute("timestamp",timestamp);
            String[]cmd2PDF={"/usr/bin/soffice","--headless","--convert-to","pdf",
                    "/usr/local/tomcat9/webapps/ExperimentReport/downloads/MillikanOilDrop"+timestamp+".xlsx","--outdir",
            "/usr/local/tomcat9/webapps/ExperimentReport/downloads/MillikanOilDrop"+timestamp+".pdf"};
            Runtime.getRuntime().exec(cmd2PDF);
            resp.sendRedirect("download.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
