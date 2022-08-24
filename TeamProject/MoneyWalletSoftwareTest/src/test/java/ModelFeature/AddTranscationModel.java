package ModelFeature;

import TransactionFeature.CategoryType;
import TransactionFeature.TranscationDTO;
import Util.FunctionalAbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class AddTranscationModel extends BaseModel {
    // Data Member //

    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        GOTO_Models_View();
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Add_Transcation_Model_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC1() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(false);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC2() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(false);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC3() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setNote("Test");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC4() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);
        dto.setPlace("Taipei", "Taipei");
        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC5() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setEventName("TestEvent");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
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
    public void Add_Transcation_Model_BCC7() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.EXPENSES);
        dto.setCategoryName("Hobby");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC8() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC9() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("-10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "-10.0");
    }

    @Test
    public void Add_Transcation_Model_BCC10() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("9999999999999999");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "9,999,999,999,999,999");
    }

    @Test
    public void Add_Transcation_Model_BCC11() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("-9999999999999999");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        Add_Transcation_Model(dto);
        Verify_Model_Is_Add(dto, "-9,999,999,999,999,999");
    }

    private void Verify_Model_Is_Add(TranscationDTO dto, String amount) throws Exception {
        String baseLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout";
        String categoryLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getCategoryName());
        String mountLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]", amount);
        String descriptLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getDescription());

        Verify_Element_Is_NOT_Null_ByXPath(categoryLocator);
        Verify_Element_Is_NOT_Null_ByXPath(mountLocator);
        Verify_Element_Is_NOT_Null_ByXPath(descriptLocator);
    }
}
