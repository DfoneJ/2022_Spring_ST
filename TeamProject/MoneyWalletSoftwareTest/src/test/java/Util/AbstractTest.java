package Util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import static java.lang.String.valueOf;

public class AbstractTest {
    // Data Member //
    public int sleeptime = 200;
    public AndroidDriver<MobileElement> driver;
    public SwipeUtil swipe;
    public CaculatorUtil calculator;
    private int width;
    private int heigth;
    // Private Method //
    private void AddFirstAccount() throws Exception {
        MobileElement StartBtm = driver.findElementById("com.oriondev.moneywallet:id/first_start_button");
        StartBtm.click();
        Thread.sleep(sleeptime);
        for (int i=1; i<=4; i++) {
            driver.findElementById("com.oriondev.moneywallet:id/next").click();
            Thread.sleep(sleeptime);
        }
        driver.findElementById("com.oriondev.moneywallet:id/done").click();
        Thread.sleep(sleeptime);
        driver.findElementById("com.oriondev.moneywallet:id/name_edit_text").sendKeys("First Account");
        Thread.sleep(sleeptime);
        driver.findElementById("com.oriondev.moneywallet:id/action_save_changes").click();
        Thread.sleep(sleeptime);
    }
    //Public Method //
    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "MoneyWallet");
        capabilities.setCapability("udid", "emulator-5554"); // DeviceId from "adb devices" command. //
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("app", "C:\\Users\\JB\\Desktop\\NTUT\\110_second_semester\\Software Testing\\Project\\GitLab\\110-team6\\MoneyWalletSoftwareTest\\MoneyWallet.apk");
        // ^ 改成自己放APK的路徑位置 ^
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("noReset","false"); // 討論
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("unicodeKeyboard","true");// Add this so we can input Chinese. //
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("–session-override","true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        width = driver.manage().window().getSize().getWidth();
        heigth = driver.manage().window().getSize().getHeight();
        System.out.print("Width:"+valueOf(width)+" X Height:"+valueOf(heigth)+"\n");
        swipe = new SwipeUtil(driver, width, heigth);
        calculator = new CaculatorUtil(driver);
        Thread.sleep(1000); // Wait for elements initialized. //
        AddFirstAccount();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(1500);
        driver.closeApp();
        driver.quit();// Quit Session
    }
}
