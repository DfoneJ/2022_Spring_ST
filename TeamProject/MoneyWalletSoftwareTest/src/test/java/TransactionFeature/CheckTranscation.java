package TransactionFeature;

import Util.DateUtil;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class CheckTranscation extends BaseTranscation {

    // Data Member //

    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Check_Transcation_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Select_Transcation_On_Transcation_List_View(dto.getDescription());
        Verify_Transcation(dto, "22,000.00");
    }

    private void Verify_Transcation(TranscationDTO dto, String verify_amount) throws Exception {
        MobileElement amountField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView[2]");

        MobileElement descriptionField = driver.findElementById("com.oriondev.moneywallet:id/description_text_view");
        MobileElement categoryField = driver.findElementById("com.oriondev.moneywallet:id/category_text_view");
        MobileElement dateField = driver.findElementById("com.oriondev.moneywallet:id/date_time_text_view");
        MobileElement walletField = driver.findElementById("com.oriondev.moneywallet:id/wallet_text_view");
        MobileElement confirmField = driver.findElementById("com.oriondev.moneywallet:id/confirmed_checkbox");
        MobileElement showInTotalWalletField = driver.findElementById("com.oriondev.moneywallet:id/count_in_total_checkbox");

        Assert.assertEquals(amountField.getText(), verify_amount);
        if (dto.getDescription() != null)
            Assert.assertEquals(dto.getDescription(), descriptionField.getText());

        Assert.assertEquals(dto.getCategoryName(), categoryField.getText()); //verify category
        Assert.assertTrue(dateField.getText().contains(DateUtil.getFormatDate(dto.getDate()))); //verify date

        if (dto.getAccountName() != null)
            Assert.assertEquals(dto.getAccountName(), walletField.getText());

        Assert.assertEquals(dto.getComfirm(), Boolean.parseBoolean(confirmField.getAttribute("checked")));
        Assert.assertEquals(dto.getShowInTotalWallet(), Boolean.parseBoolean(showInTotalWalletField.getAttribute("checked")));
    }
}
