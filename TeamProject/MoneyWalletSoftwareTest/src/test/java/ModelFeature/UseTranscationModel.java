package ModelFeature;

import TransactionFeature.CategoryType;
import TransactionFeature.DateBlockType;
import TransactionFeature.TranscationDTO;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class UseTranscationModel extends BaseModel {
    // Data Member //

    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Thread.sleep(sleeptime);
        GOTO_Models_View();
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Use_Transcation_Model_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);

        Thread.sleep(sleeptime);

        Use_Transcation_Model();
        Verify_Model_Is_Used();
    }

    private void Use_Transcation_Model() throws Exception {
        Click_Use_Model_Button();
    }

    private void Click_Use_Model_Button() throws Exception {
        driver.findElementById("com.oriondev.moneywallet:id/add_button").click();
        Thread.sleep(sleeptime);
    }

    private void Verify_Model_Is_Used() throws Exception {
        Thread.sleep(800);

        String locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
        MobileElement tipsField = driver.findElementByXPath(locator);
        Verify_Element_Is_NOT_Null_ByXPath(locator);
        Assert.assertEquals(tipsField.getText(), "Transaction added");

    }
}
