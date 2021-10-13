package com.yiming.experimentreport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

@WebServlet("/pdf")
public class Generate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String experimentName=(String) session.getAttribute("experimentName");
        InputStream propertiesStream = Generate.class.getClassLoader().getResourceAsStream(experimentName+".properties");
        Properties properties = new Properties();
        properties.load(propertiesStream);
        String pythonCmdDir = properties.getProperty("pythonCmdDir");
        String tomcatDir = properties.getProperty("tomcatDir");
        String inputNum = properties.getProperty("inputNum");
        String dataNum = properties.getProperty("dataNum");
        String libreCmdDir = properties.getProperty("libreCmdDir");
        String pythonfiledir=tomcatDir+"/webapps/ExperimentReport/scripts/"+experimentName+".py";
        ArrayList<String> pythonCmd = new ArrayList<>();
        pythonCmd.add(pythonCmdDir);
        pythonCmd.add(pythonfiledir);
        int inputNumInt = Integer.parseInt(inputNum);
        for (int i = 1; i <=inputNumInt; i++) {
           Utils.mergeList(pythonCmd,req.getParameter(String.valueOf(i)).trim().split(","));
        }
        String[] pythonCmdArray=pythonCmd.toArray(new String[Integer.parseInt(dataNum)+2]);
        try{
            Process process = Runtime.getRuntime().exec(pythonCmdArray);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String timestamp="";
            String line = "";
            while ((line = in.readLine()) != null) {
                timestamp+=line;
            }
            String[] split = timestamp.split(",,");
            timestamp=split[1];
            in.close();
            session.setAttribute("timestamp",timestamp);
            String excelDir=tomcatDir+"/webapps/ExperimentReport/downloads/"+experimentName+timestamp+".xlsx";
            String pdfDir=tomcatDir+"/webapps/ExperimentReport/downloads/"+experimentName+timestamp+".pdf";
            String[]cmd2PDF={libreCmdDir,"--headless","--convert-to","pdf",excelDir,"--outdir",pdfDir};
            Runtime.getRuntime().exec(cmd2PDF);
            resp.sendRedirect("download.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
