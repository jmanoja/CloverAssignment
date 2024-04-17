package org.search.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties configFile;
    static String propertyFile;

    public static Properties init_prop(){
        try {
            String activeProp = isNullEmpty(System.getProperty("env")) ? "local" : System.getProperty("env");
            System.out.println(activeProp);
            switch (activeProp) {
                case "local":
                default:
                    propertyFile = "/src/main/java/org/search/automation/Config/env.properties";
                    break;
                case"dev":
                    propertyFile = "";
                    break;
            }
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + propertyFile);
            //Create object of properties class
            configFile = new Properties();
            //load properties file into properties object
            configFile.load(input);
            input.close();
        }
        catch (Exception e){
            System.out.println("not able to read config file");
            e.printStackTrace();
        }
        return configFile;
    }

    public static  boolean isNullEmpty(String str){
        return str==null || str.isEmpty();
    }

    public static String getProperty(String keyName){
        if(configFile == null){
            configFile = init_prop();
        }
        if(configFile == null){
            System.out.println("config file is null");
        }
        return configFile.getProperty(keyName);
    }

    public static void setProperty(String propertyName,String propertyValue) throws IOException {
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+propertyFile);
        configFile.setProperty(propertyName,propertyValue);
        configFile.store(fos,"saving the property" + propertyName);
        fos.close();

    }

}
