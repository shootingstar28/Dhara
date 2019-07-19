package telummed;

import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class Hooks extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();
    static String timeStamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());

    @Before
    public void setUpBrowser()
    {browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://www.telummedia.com/");
    }
    @After
    public void closeBrowser(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            String sceenshotName = scenario.getName().replaceAll("[.,;:?!]", "") + timeStamp + ".png";
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/extent-reports/screenshot/" + sceenshotName);
                copyFile(sourcePath, destinationPath);
                scenario.write("!!!...Scenario Failed...!!!!!Please see attached screenshot for the error/issue");
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (IOException e) {
            }
        } driver.close();
    }
}
