package ModelFeature;

import TransactionFeature.CategoryType;
import TransactionFeature.TranscationDTO;
import Util.DateUtil;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class EditTranscationModel extends BaseModel  {
    // Data Member //
    TranscationDTO dto;

    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();

        dto = new TranscationDTO();
        dto.setAmount("0.00");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);
        Thread.sleep(sleeptime);
        GOTO_Models_View();
        Add_Transcation_Model(dto);
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Edit_Transcation_Model_BaseChoice() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC1() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(false);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC2() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(false);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC3() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setNote("Test");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC4() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setPlace("Taipei", "Taipei");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Add_Place(editDTO.getPlaceName(), editDTO.getPlaceAddress());
        GOTO_Models_View();

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC5() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setEventName("TestEvent");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Add_Event(editDTO.getEventName());
        GOTO_Models_View();

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

//    @Test
//    public void Add_Transcation_Model_BCC6() throws Exception {
//        TranscationDTO dto = new TranscationDTO();
//        dto.setAmount("10.0");
//        dto.setDescription("Test");
//        dto.setCategoryType(CategoryType.INCOMES);
//        dto.setCategoryName("Salary");
//        dto.setComfirm(true);
//        dto.setShowInTotalWallet(true);
//
//        Add_Transcation_Model(dto);
//        Verify_Model_Is_Add(dto);
//    }

    @Test
    public void Edit_Transcation_Model_BCC7() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.EXPENSES);
        editDTO.setCategoryName("Hobby");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC8() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("10.0");
        editDTO.setDescription("");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC9() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("-10.0");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "10.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC10() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("9999999999999999");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "9,999,999,999,999,999.00");
    }

    @Test
    public void Edit_Transcation_Model_BCC11() throws Exception {
        TranscationDTO editDTO = new TranscationDTO();
        editDTO.setAmount("-9999999999999999");
        editDTO.setDescription("Test");
        editDTO.setCategoryType(CategoryType.INCOMES);
        editDTO.setCategoryName("Salary");
        editDTO.setComfirm(true);
        editDTO.setShowInTotalWallet(true);

        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Edit_Model_Button();
        Enter_Model_Information(editDTO);
        Click_Confirm_Edit_Model_Button_On_Model_View();

        Verify_Model_Is_Edit(editDTO, "-9,999,999,999,999,999.00");
    }

    private void Verify_Model_Is_Edit(TranscationDTO dto, String VerifyAmount) throws Exception {
        MobileElement amountField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView[2]");

        MobileElement descriptionField = null;
        if (dto.getDescription() != null && !dto.getDescription().equals(""))
            descriptionField = driver.findElementById("com.oriondev.moneywallet:id/description_text_view");

        MobileElement categoryField = driver.findElementById("com.oriondev.moneywallet:id/category_text_view");
        MobileElement walletField = driver.findElementById("com.oriondev.moneywallet:id/wallet_text_view");
        MobileElement confirmField = driver.findElementById("com.oriondev.moneywallet:id/confirmed_checkbox");
        MobileElement showInTotalWalletField = driver.findElementById("com.oriondev.moneywallet:id/count_in_total_checkbox");

        Assert.assertEquals(amountField.getText(), VerifyAmount);

        if (descriptionField != null)
            Assert.assertEquals(dto.getDescription(), descriptionField.getText());

        Assert.assertEquals(dto.getCategoryName(), categoryField.getText()); //verify category

        if (dto.getAccountName() != null)
            Assert.assertEquals(dto.getAccountName(), walletField.getText());

        Assert.assertEquals(dto.getComfirm(), Boolean.parseBoolean(confirmField.getAttribute("checked")));
        Assert.assertEquals(dto.getShowInTotalWallet(), Boolean.parseBoolean(showInTotalWalletField.getAttribute("checked")));
    }
}
