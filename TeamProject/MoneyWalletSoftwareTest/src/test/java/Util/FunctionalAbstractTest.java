package Util;

import TransactionFeature.CategoryType;
import TransactionFeature.DateBlockType;
import TransactionFeature.TranscationDTO;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.util.Date;

public class FunctionalAbstractTest extends AbstractTest {

    public void DoNothing() throws Exception {
        Thread.sleep(sleeptime);
    }

    protected void Click_Hamburger_Button() throws Exception {
        driver.findElementByAccessibilityId("Open").click(); // click Hamburger Button
        Thread.sleep(sleeptime);
    }

    protected void Click_Account_Header_Button() throws Exception {
        MobileElement AccountHeaderBtn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[2]");
        AccountHeaderBtn.click();
        Thread.sleep(sleeptime);
    }

    protected void Click_New_Account_Button() throws Exception {
        MobileElement NewAccountBtn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView");
        NewAccountBtn.click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Manager_Wallets_Button() throws Exception {
        MobileElement Manager_Wallets_Button = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView");
        Manager_Wallets_Button.click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Account_In_Manager_Wallets_View(String accountName) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", accountName);
        MobileElement account = driver.findElementByXPath(locator);
        account.click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Delete_Account_Button() throws Exception {
        driver.findElementByAccessibilityId("Delete").click();
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Return_Button_In_Manager_Wallets_View() throws Exception {
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton").click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Feature_On_Feature_List(String feature) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout//*[@text=\"%s\"]", feature);
        driver.findElementByXPath(locator).click();
        Thread.sleep(sleeptime);
    }

    //// Transaction
    protected void GOTO_Transcation_View() throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("Transactions");
        Thread.sleep(sleeptime);
        Thread.sleep(sleeptime);
    }

    protected void Click_Add_Transcation_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Information(TranscationDTO dto) throws Exception {
        if (dto.getAmount() != null) {
            Enter_Transcation_Amount(dto.getAmount());
        }

        if (dto.getDescription() != null) {
            Enter_Transcation_Description(dto.getDescription());
        }

        if (dto.getCategoryType() != null && dto.getCategoryName() != null) {
            Enter_Transcation_Category(dto.getCategoryType(), dto.getCategoryName());
        }

        if (!dto.getDateBlockType().equals(DateBlockType.CURRENT)) {
            Enter_Transcation_Date(dto.getDateBlockType(), dto.getDate());
        }

        if (dto.getAccountName() != null) { // wallet
            Enter_Transcation_Wallets(dto.getAccountName());
        }

        if (dto.getEventName() != null) {
            Enter_Transcation_Event(dto.getEventName());
        }

        if (dto.getPeople() != null) {
            for (int i = 0; i < dto.getPeople().length; i++)
                Enter_Transcation_People(dto.getPeople()[i]);
        }

        if (dto.getPlaceName() != null && dto.getPlaceAddress() != null) {
            Enter_Transcation_Place(dto.getPlaceName());
        }

        if (dto.getNote() != null) {
            Enter_Transcation_Note(dto.getNote());
        }

        swipe.Up();
        Thread.sleep(sleeptime);

        Enter_Transcation_Confirmed(dto.getComfirm());
        Enter_Transcation_ShowInTotalWallet(dto.getShowInTotalWallet());

        swipe.Down();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Amount(String amount) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/money_text_view").click();
        Thread.sleep(sleeptime);
        calculator.enter_clear();
        calculator.enterNumbers(amount);
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Description(String desc) throws Exception {
        MobileElement descriptionField = driver.findElementById("com.oriondev.moneywallet:id/description_edit_text");
        descriptionField.sendKeys(desc);
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Category(CategoryType categoryType, String categoryName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/category_edit_text").click(); // click category on transcationo view
        Thread.sleep(sleeptime);

        if (categoryType.equals(CategoryType.INCOMES)) {
            driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Incomes\"]").click();
        }
        else{
            driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Expenses\"]").click();
        }
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", categoryName);
        MobileElement category = driver.findElementByXPath(locator);
        category.click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Date(DateBlockType blockType, Date date) throws Exception {
        if (blockType.equals(DateBlockType.CURRENT))
            return;

        driver.findElementById("com.oriondev.moneywallet:id/date_edit_text").click(); // click date on transcationo view
        Thread.sleep(sleeptime);

        if (blockType.equals(DateBlockType.BEFORE)) {
            driver.findElementByXPath("//android.view.View[@content-desc=\"01 June 2022\"]").click();
            Thread.sleep(sleeptime);
        }
        else if (blockType.equals(DateBlockType.AFTER)) {
            driver.findElementByXPath("//android.view.View[@content-desc=\"30 June 2022\"]").click();
            Thread.sleep(sleeptime);
        }
        else if (blockType.equals(DateBlockType.OTHER)) {
            String formatDate = DateUtil.getFormatDateForCanlander(date);
            driver.findElementByXPath(String.format("//android.view.View[@content-desc=\"%s\"]", formatDate)).click();
            Thread.sleep(sleeptime);
        }

        driver.findElementById("com.oriondev.moneywallet:id/bsp_done").click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Wallets(String walletName) throws  Exception {
        driver.findElementById("com.oriondev.moneywallet:id/wallet_edit_text").click(); // click wallets on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", walletName);
        driver.findElementByXPath(locator).click(); // select wallet
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Event(String eventName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/event_edit_text").click(); // click event on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", eventName);
        driver.findElementByXPath(locator).click(); // select event
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_People(String peopleName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/people_edit_text").click(); // click people on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", peopleName);
        driver.findElementByXPath(locator).click(); // select people
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Place(String placeName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/place_edit_text").click(); // click place on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", placeName);
        driver.findElementByXPath(locator).click(); // select place
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Note(String note) throws Exception {
        MobileElement noteField = driver.findElementById("com.oriondev.moneywallet:id/note_edit_text");
        noteField.sendKeys(note);
        Thread.sleep(sleeptime);
    }

    protected void Enter_Transcation_Confirmed(boolean isTick) throws  Exception {
        MobileElement checkbox = driver.findElementById("com.oriondev.moneywallet:id/confirmed_checkbox");
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        if (isTick != isChecked) {
            checkbox.click(); // click confirm on transcationo view
            Thread.sleep(sleeptime);
        }
    }

    protected void Enter_Transcation_ShowInTotalWallet(boolean isTick) throws  Exception {
        MobileElement checkbox = driver.findElementById("com.oriondev.moneywallet:id/count_in_total_checkbox");
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        if (isTick != isChecked) {
            checkbox.click(); // click show in total wallet on transcationo view
            Thread.sleep(sleeptime);
        }
    }

    protected void Click_Confirm_Add_Transcation() throws Exception {
        MobileElement save_button = driver.findElementById("com.oriondev.moneywallet:id/action_save_changes");
        save_button.click();
        Thread.sleep(sleeptime);
    }

    protected void Select_Transcation_On_Transcation_List_View(String description) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", description);
        driver.findElementByXPath(locator).click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Delete_Transcation_Button() throws Exception {
        driver.findElementByAccessibilityId("Delete").click(); // click delete button
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click(); // click ok
        Thread.sleep(sleeptime);
    }

    protected void Verify_Element_Is_Null_ByXPath(String locator) throws Exception {
        try {
            MobileElement account = driver.findElementByXPath(locator);
            Assert.assertTrue(false);
        }
        catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    protected void Verify_Element_Is_NOT_Null_ByXPath(String locator) throws Exception {
        try {
            MobileElement account = driver.findElementByXPath(locator);
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    protected void Click_Search_Transcation_Button() throws Exception {
        driver.findElementByAccessibilityId("Search").click();
        Thread.sleep(sleeptime);
    }

    protected void Input_Search_Transcation(String searchName) throws Exception {
        MobileElement inputField = driver.findElementById("com.oriondev.moneywallet:id/search_edit_text");
        inputField.sendKeys(searchName);
        Thread.sleep(sleeptime);
    }

    /// Transcation Template
    protected void GOTO_Models_View() throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("Models");
        Thread.sleep(sleeptime);
    }

    protected void Click_Add_Model_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Information(TranscationDTO dto) throws Exception {
        if (dto.getAmount() != null) {
            Enter_Model_Amount(dto.getAmount());
        }

        if (dto.getDescription() != null) {
            Enter_Model_Description(dto.getDescription());
        }

        if (dto.getCategoryType() != null && dto.getCategoryName() != null) {
            Enter_Model_Category(dto.getCategoryType(), dto.getCategoryName());
        }

        if (dto.getAccountName() != null) { // wallet
            Enter_Model_Wallets(dto.getAccountName());
        }

        if (dto.getEventName() != null) {
            Enter_Model_Event(dto.getEventName());
        }

        if (dto.getPeople() != null) {
            for (int i = 0; i < dto.getPeople().length; i++)
                Enter_Model_People(dto.getPeople()[i]);
        }

        if (dto.getPlaceName() != null && dto.getPlaceAddress() != null) {
            Enter_Model_Place(dto.getPlaceName());
        }

        if (dto.getNote() != null) {
            Enter_Model_Note(dto.getNote());
        }

        Enter_Model_Confirmed(dto.getComfirm());
        Enter_Model_ShowInTotalWallet(dto.getShowInTotalWallet());
    }

    protected void Enter_Model_Amount(String amount) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/money_text_view").click();
        Thread.sleep(sleeptime);
        calculator.enter_clear();
        calculator.enterNumbers(amount.toString());
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Description(String desc) throws Exception {
        MobileElement descriptionField = driver.findElementById("com.oriondev.moneywallet:id/description_edit_text");
        descriptionField.sendKeys(desc);
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Category(CategoryType categoryType, String categoryName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/category_edit_text").click(); // click category on transcationo view
        Thread.sleep(sleeptime);

        if (categoryType.equals(CategoryType.INCOMES)) {
            driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Incomes\"]").click();
        }
        else{
            driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Expenses\"]").click();
        }
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", categoryName);
        MobileElement category = driver.findElementByXPath(locator);
        category.click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Wallets(String walletName) throws  Exception {
        driver.findElementById("com.oriondev.moneywallet:id/wallet_edit_text").click(); // click wallets on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", walletName);
        driver.findElementByXPath(locator).click(); // select wallet
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Event(String eventName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/event_edit_text").click(); // click event on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", eventName);
        driver.findElementByXPath(locator).click(); // select event
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_People(String peopleName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/people_edit_text").click(); // click people on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", peopleName);
        driver.findElementByXPath(locator).click(); // select people
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click();
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Place(String placeName) throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/place_edit_text").click(); // click place on transcationo view
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup//*[@text=\"%s\"]", placeName);
        driver.findElementByXPath(locator).click(); // select place
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Note(String note) throws Exception {
        MobileElement noteField = driver.findElementById("com.oriondev.moneywallet:id/note_edit_text");
        noteField.sendKeys(note);
        Thread.sleep(sleeptime);
    }

    protected void Enter_Model_Confirmed(boolean isTick) throws  Exception {
        MobileElement checkbox = driver.findElementById("com.oriondev.moneywallet:id/confirmed_checkbox");
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        if (isTick != isChecked) {
            checkbox.click(); // click confirm on transcationo view
            Thread.sleep(sleeptime);
        }
    }

    protected void Enter_Model_ShowInTotalWallet(boolean isTick) throws  Exception {
        MobileElement checkbox = driver.findElementById("com.oriondev.moneywallet:id/count_in_total_checkbox");
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        if (isTick != isChecked) {
            checkbox.click(); // click show in total wallet on transcationo view
            Thread.sleep(sleeptime);
        }
    }

    protected void Click_Confirm_Add_Model_Button_On_Model_View() throws Exception {
        MobileElement button = driver.findElementById("com.oriondev.moneywallet:id/action_save_changes");
        button.click();
        Thread.sleep(sleeptime);
    }

    protected void Select_Model_On_Model_List_View(String description) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout//*[@text=\"%s\"]", description);
        driver.findElementByXPath(locator).click();
        Thread.sleep(sleeptime);
    }

    protected void Click_Delete_Model_Button() throws Exception {
        driver.findElementByAccessibilityId("Delete").click(); // click delete button
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click(); // click ok
        Thread.sleep(sleeptime);
    }

    protected void Click_Edit_Model_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/action_edit_item").click(); // click edit button
        Thread.sleep(sleeptime);
    }

    protected void Click_Confirm_Edit_Model_Button_On_Model_View() throws Exception {
        MobileElement button = driver.findElementById("com.oriondev.moneywallet:id/action_save_changes");
        button.click();
        Thread.sleep(sleeptime);
    }

    // other
    // add event
    protected void Add_Event(String eventName) throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("Events"); // go to event view
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click(); // click add button
        Thread.sleep(sleeptime);

        MobileElement inputField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text");
        inputField.sendKeys(eventName);
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/start_date_edit_text").click();
        Thread.sleep(sleeptime);

        driver.findElementByXPath("//android.view.View[@content-desc=\"01 June 2022\"]").click();
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/bsp_done").click();
        Thread.sleep(sleeptime);

        Click_Save_Button(); // save changes
        Thread.sleep(sleeptime);
    }

    // add place
    protected void Add_Place(String placeName, String placeAddress) throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("Places"); // go to place view
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click(); // click add button
        Thread.sleep(sleeptime);

        MobileElement nameField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text"); // input place name
        nameField.sendKeys(placeName);
        Thread.sleep(sleeptime);

        MobileElement addressField = driver.findElementById("com.oriondev.moneywallet:id/address_edit_text"); // input address
        addressField.sendKeys(placeAddress);
        Thread.sleep(sleeptime);

        Click_Save_Button(); // save changes
        Thread.sleep(sleeptime);
    }

    // add people (one)
    protected void Add_People(String peopleName) throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("People"); // go to people view
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click(); // click add button
        Thread.sleep(sleeptime);

        MobileElement nameField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text"); // input people name
        nameField.sendKeys(peopleName);
        Thread.sleep(sleeptime);

        Click_Save_Button(); // save changes
        Thread.sleep(sleeptime);
    }

    // add people (mul)
    protected void Add_People(String[] peopleNames) throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("People"); // go to people view
        Thread.sleep(sleeptime);

        for (int i = 0; i < peopleNames.length; i++) {
            driver.findElementById("com.oriondev.moneywallet:id/floating_action_button").click(); // click add button
            Thread.sleep(sleeptime);

            MobileElement nameField = driver.findElementById("com.oriondev.moneywallet:id/name_edit_text"); // input people name
            nameField.sendKeys(peopleNames[i]);
            Thread.sleep(sleeptime);

            Click_Save_Button(); // save changes
            Thread.sleep(sleeptime);
        }
    }

    protected void Click_Save_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/action_save_changes").click(); // click save button
        Thread.sleep(sleeptime);
    }


    /// overview view

    protected void GOTO_Overview_View() throws Exception {
        Click_Hamburger_Button();
        Click_Feature_On_Feature_List("Overview");
        Thread.sleep(sleeptime);
    }

    protected void Click_Overview_Setting_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/advanced_settings").click();
        Thread.sleep(sleeptime);
    }

    protected void Select_Overview_Start_Date() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/start_date_spinner").click();
        Thread.sleep(sleeptime);

        for (int i = 0; i < 5; i++) {
            driver.findElementById("com.oriondev.moneywallet:id/bsp_next").click();
            Thread.sleep(sleeptime);
        }

        Date date = new Date();
        String today = DateUtil.getFormatDateForCanlander(date);
        driver.findElementByXPath(String.format("//android.view.View[@content-desc=\"%s\"]", "01 June 2022")).click();
        Thread.sleep(sleeptime);

        driver.findElementById("com.oriondev.moneywallet:id/bsp_done").click();
        Thread.sleep(sleeptime);
    }

    protected void Select_Overview_End_Date() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/end_date_spinner").click();
        Thread.sleep(sleeptime);

    }

    protected void Select_Overview_Group(String group) throws Exception {
        if(group.equals("monthly")) {
            return;
        }
        driver.findElementById("com.oriondev.moneywallet:id/group_type_spinner").click();
        Thread.sleep(sleeptime);

        if (group.equals("daily")) {
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]").click();
            Thread.sleep(sleeptime);
        }
        else if (group.equals("weekly")) {
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]").click();
            Thread.sleep(sleeptime);
        }
        else if (group.equals("yearly")) {
            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]").click();
            Thread.sleep(sleeptime);
        }
    }

    protected void Select_Overview_Transcation_Type() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/overview_type_spinner").click();
        Thread.sleep(sleeptime);
    }

    protected void Select_Overview_Transcation_Content(String content) throws Exception {
        if(content.equals("Net incomes"))
            return;

        driver.findElementById("com.oriondev.moneywallet:id/cash_flow_spinner").click();
        Thread.sleep(sleeptime);

        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView//*[@text=\"%s\"]", content);
        driver.findElementByXPath(locator).click();
        Thread.sleep(sleeptime);
    }

    protected void Click_OK_Button_On_Overview() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/md_buttonDefaultPositive").click();
        Thread.sleep(sleeptime);
    }
}
