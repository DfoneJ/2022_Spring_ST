package AccountFeature;

import Util.AbstractTest;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteAccount extends FunctionalAbstractTest {
    // Data Member //
    private MobileElement AccountHeaderBtn;
    private MobileElement NewAccountBtn;
    private MobileElement NameField;
    private MobileElement CurrencySelector;
    private MobileElement Note;
    // Private Method //
    private void selectCurrency(String Currency) throws Exception {
        List<MobileElement> CurrencyList = driver.findElementsById("com.oriondev.moneywallet:id/name_text_view");
        int ItemAmounts = CurrencyList.size();
        String FirstItem = "";
        while(!(CurrencyList.get(0).getText().equals(FirstItem))) {
            FirstItem = CurrencyList.get(0).getText();
            for(int i=0; i<ItemAmounts; i++) {
                String Item = CurrencyList.get(i).getText();
                if(Item.equals(Currency)) {
                    CurrencyList.get(i).click();
                    Thread.sleep(sleeptime);
                    return;
                }
            }
            swipe.Up();
            Thread.sleep(50);
            CurrencyList = driver.findElementsById("com.oriondev.moneywallet:id/name_text_view");
            ItemAmounts = CurrencyList.size();
        }
        CurrencyList.get(ItemAmounts-1).click(); // If Not Found, Click Last One
        Thread.sleep(sleeptime);
    }
    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Click_Hamburger_Button();
        Click_Account_Header_Button();
        Click_New_Account_Button();
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Delete_Account_HappyPath() throws Exception {
        String accountName = "Little Hua";
        Add_Accounnt(accountName);
        Delete_Account(accountName);
    }

    private void Delete_Account(String accountName) throws Exception {
        Click_Hamburger_Button();
        Click_Account_Header_Button();
        Click_Manager_Wallets_Button();
        Click_Account_In_Manager_Wallets_View(accountName);
        Click_Delete_Account_Button();
        Click_Return_Button_In_Manager_Wallets_View();
        Click_Hamburger_Button();
        Click_Account_Header_Button();
        Verify_account_delete(accountName);
    }

    private void Verify_account_delete(String accountName) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout//*[@text=\"%s\"]", accountName);
        try {
            MobileElement account = driver.findElementByXPath(locator);
            Assert.assertTrue(false);
        }
        catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    private void Add_Accounnt(String accountName) throws Exception {
        NameField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text");
        NameField.sendKeys(accountName);
//        CurrencySelector = driver.findElementById("com.oriondev.moneywallet:id/currency_edit_text");
//        CurrencySelector.click();
//        Thread.sleep(sleeptime);
//        selectCurrency("New Taiwan Dollar");
        driver.findElementById("com.oriondev.moneywallet:id/start_money_edit_text").click();
        Thread.sleep(sleeptime);
        calculator.enterNumbers("50000");
        Note = driver.findElementById("com.oriondev.moneywallet:id/note_edit_text");
        Note.sendKeys("左邊口袋");
        driver.findElementById("com.oriondev.moneywallet:id/action_save_changes").click();
        Thread.sleep(sleeptime);

//        driver.findElementByAccessibilityId("Open").click();
//        Thread.sleep(sleeptime);
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[2]").click();
//        Thread.sleep(sleeptime);
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]").click();

    }
}
