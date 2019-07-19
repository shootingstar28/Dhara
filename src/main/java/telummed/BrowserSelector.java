package telummed;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSelector extends BasePage {

    LoadProp loadProp = new LoadProp();

    public void setUpBrowser() {
        String browser = loadProp.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else {
            System.out.println("Browser name is empty or typed wrong" + browser);

        }


    }
}
