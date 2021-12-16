package constants;

import enums.ConfigProperties;
import utils.ReadPropertyFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    private static final int WAITTIMEINSECONDS = 10;
    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath="";

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static int getWaitTimeInSeconds() {
        return WAITTIMEINSECONDS;
    }

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath=EXTENTREPORTFOLDERPATH+"index.html";
        }
        return extentReportFilePath;
    }
}