package com.yiming.experimentreport;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {

        filename = URLEncoder.encode(filename, "utf-8");

        return filename;
    }

}
