package com.yiming.experimentreport;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Utils {
    public static void mergeList(ArrayList<String> master,String[]branch){
        for (String s : branch) {
            master.add(s);
        }
    }
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {

        filename = URLEncoder.encode(filename, "utf-8");

        return filename;
    }
}
