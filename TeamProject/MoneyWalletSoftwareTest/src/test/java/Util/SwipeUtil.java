package Util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

public class SwipeUtil {
    // Data Member //
    private AndroidDriver driver;
    private int Width;
    private int Height;
    private Duration swipeduration = Duration.ofMillis(900);
    //Public Method //
    public SwipeUtil(AndroidDriver driver, int Width, int Height) {
        this.driver = driver;
        this.Width = Width;
        this.Height = Height;
    }

    public void Up() {
        int satrt_x = Width/2;
        int start_y = (int) (Height * 0.8);
        int end_y = (int) (Height * 0.2);
        TouchAction action = new TouchAction(driver).press(PointOption.point(satrt_x, start_y)).waitAction(WaitOptions.waitOptions(swipeduration)).moveTo(PointOption.point(satrt_x, end_y)).release();
        action.perform();
    }

    public void Down() {
        int satrt_x = Width/2;
        int start_y = (int) (Height * 0.4);
        int end_y = (int) (Height * 0.6);
        TouchAction action = new TouchAction(driver).press(PointOption.point(satrt_x, start_y)).waitAction(WaitOptions.waitOptions(swipeduration)).moveTo(PointOption.point(satrt_x, end_y)).release();
        action.perform();
    }
}
