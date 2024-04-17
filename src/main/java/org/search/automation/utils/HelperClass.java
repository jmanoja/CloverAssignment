package org.search.automation.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HelperClass {
    private static WebDriver driver;
    public static WebDriver init_driver(String browser){
        System.out.println("browser value is:" +browser);

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            driver = new EdgeDriver(edgeOptions);
        }
        else {
            System.out.println("Please pass the correct browser value:" +browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
        return driver;
    }

    public static void openPage(String engine) {
        if(engine.equalsIgnoreCase("google"))
            driver.get(ConfigReader.getProperty("googleUrl"));
        else if(engine.equalsIgnoreCase("bing"))
            driver.get(ConfigReader.getProperty("bingUrl"));
        else
            driver.get(ConfigReader.getProperty("url"));
    }

    public static void bingpage(){
        driver.get(ConfigReader.getProperty("bingcom"));
    }
    public static WebDriver getDriver() {
      if(driver==null){
          driver=init_driver(ConfigReader.getProperty("browser"));
      }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
        driver.close();
        driver.quit();
      }
      driver = null;
    }

  }


