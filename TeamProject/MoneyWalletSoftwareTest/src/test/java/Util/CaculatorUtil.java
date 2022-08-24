package Util;

import io.appium.java_client.android.AndroidDriver;

public class CaculatorUtil {
    // Data Member //
    private AndroidDriver driver;
    // Private Method //
    private void enter_0() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_0_button").click();}
    private void enter_1() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_1_button").click();}
    private void enter_2() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_2_button").click();}
    private void enter_3() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_3_button").click();}
    private void enter_4() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_4_button").click();}
    private void enter_5() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_5_button").click();}
    private void enter_6() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_6_button").click();}
    private void enter_7() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_7_button").click();}
    private void enter_8() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_8_button").click();}
    private void enter_9() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_9_button").click();}
    private void enter_point() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_point_button").click();}
    private void enter_sub() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_subtraction_button").click();}

    public void enter_clear() {driver.findElementById("com.oriondev.moneywallet:id/keyboard_clear_button").click(); }
    //Public Method //
    public CaculatorUtil(AndroidDriver driver) {this.driver = driver;}

    public void enterNumbers(String numbers) throws InterruptedException {
        boolean isDoubleClick = false;
        for(char digit: numbers.toCharArray()) {
            switch (digit) {
                case '0':
                    enter_0();
                    break;
                case '1':
                    enter_1();
                    break;
                case '2':
                    enter_2();
                    break;
                case '3':
                    enter_3();
                    break;
                case '4':
                    enter_4();
                    break;
                case '5':
                    enter_5();
                    break;
                case '6':
                    enter_6();
                    break;
                case '7':
                    enter_7();
                    break;
                case '8':
                    enter_8();
                    break;
                case '9':
                    enter_9();
                    break;
                case '.':
                    enter_point();
                    break;
                case '-':
                    enter_sub();
                    isDoubleClick = true;
                default:
                    break;
            }
        }
        if (isDoubleClick){
            driver.findElementById("com.oriondev.moneywallet:id/keyboard_action_button").click();
            Thread.sleep(100);
        }
        driver.findElementById("com.oriondev.moneywallet:id/keyboard_action_button").click();
        Thread.sleep(100);
    }
}
