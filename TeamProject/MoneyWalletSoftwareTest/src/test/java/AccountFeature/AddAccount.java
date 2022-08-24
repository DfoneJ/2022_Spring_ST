package AccountFeature;

import Util.AbstractTest;
import Util.FunctionalAbstractTest;
import Util.StringFormatUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static java.lang.String.valueOf;

public class AddAccount extends FunctionalAbstractTest {
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
        driver.findElementByAccessibilityId("Open").click();
        Thread.sleep(sleeptime);
        AccountHeaderBtn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[2]");
        AccountHeaderBtn.click();
        Thread.sleep(sleeptime);
        NewAccountBtn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView");
        NewAccountBtn.click();
        Thread.sleep(sleeptime);
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Add_Account_BaseChoice() throws Exception {
        Add_Account("Little Hua", "50000.00", "US Dollar", "", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "50,000.00");
    }

    @Test
    public void Add_Account_BCC1() throws Exception {
        Add_Account("Little Hua", "50000.00", "US Dollar", "", false);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "50,000.00");
    }

    @Test
    public void Add_Account_BCC2() throws Exception {
        Add_Account("Little Hua", "50000.00", "US Dollar", "左邊口袋", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "50,000.00");
    }

    @Test
    public void Add_Account_BCC3() throws Exception {
        Add_Account("Little Hua", "-50000.00", "US Dollar", "", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "-50,000.00");
    }

    @Test
    public void Add_Account_BCC4() throws Exception {
        Add_Account("Little Hua", "9999999999999999", "US Dollar", "", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "9,999,999,999,999,999");
    }

    @Test
    public void Add_Account_BCC5() throws Exception {
        Add_Account("Little Hua", "-9999999999999999", "US Dollar", "", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "-9,999,999,999,999,999");
    }

    @Test
    public void Add_Account_BCC6() throws Exception {
        Add_Account("Little Hua", "50000.00", "Afghan Afghani", "", true);
        Open_ManageWallet();
        Verify_Acctount_Is_Add("Little Hua", "50,000");
    }

    @Test
    public void Add_Account_BCC7() throws Exception {
        Add_Account("", "50000.00", "US Dollar", "", true);
        Verify_Add_Account_Invalid_Name();
    }

    public void Add_Account(String accountName, String amount, String currentcy, String note, boolean showThisWalletInTheTotalCount) throws Exception {
        Enter_Account_Name(accountName);
        if (currentcy != null && !currentcy.equals("US Dollar"))
            Select_Currency(currentcy);
        Enter_Account_Amount(amount);
        Enter_Account_Note(note);
        Enter_Account_ShowThisWalletInTheTotalCount(showThisWalletInTheTotalCount);
        Click_Save_Account_Button();
    }

    private void Enter_Account_Name(String accountName) throws Exception {
        NameField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text");
        NameField.sendKeys(accountName);
    }

    private void Enter_Account_Amount(String amount) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/start_money_edit_text").click();
        Thread.sleep(sleeptime);
        calculator.enterNumbers(amount);
    }

    private void Select_Currency(String currency) throws Exception {
        CurrencySelector = driver.findElementById("com.oriondev.moneywallet:id/currency_edit_text");
        CurrencySelector.click();
        Thread.sleep(sleeptime);
        selectCurrency(currency);
    }

    private void Enter_Account_Note(String note) throws Exception {
        Note = driver.findElementById("com.oriondev.moneywallet:id/note_edit_text");
        Note.sendKeys(note);
    }

    private void Enter_Account_ShowThisWalletInTheTotalCount(Boolean isSelected) throws Exception {
        MobileElement checkbox = driver.findElementById("com.oriondev.moneywallet:id/not_exclude_total_check_box");
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        if (isSelected != isChecked) {
            checkbox.click(); // click show in total wallet on transcationo view
            Thread.sleep(sleeptime);
        }
    }

    private void Click_Save_Account_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/action_save_changes").click();
        Thread.sleep(sleeptime);
    }

    private void Open_ManageWallet() throws Exception {
        driver.findElementByAccessibilityId("Open").click();
        Thread.sleep(sleeptime);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[2]").click();
        Thread.sleep(sleeptime);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]").click();
        Thread.sleep(sleeptime);
    }

    private void Verify_Acctount_Is_Add(String accountName, String amount) throws Exception {
//        amount = StringFormatUtil.getFormatMoney(amount);
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", accountName);
        String amountLocator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[contains(@text, \"%s\")]", amount);
        Verify_Element_Is_NOT_Null_ByXPath(locator);
        Verify_Element_Is_NOT_Null_ByXPath(amountLocator);
    }

    private void Verify_Add_Account_Invalid_Name() throws Exception{

        String locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView";
        Verify_Element_Is_NOT_Null_ByXPath(locator);
    }
}