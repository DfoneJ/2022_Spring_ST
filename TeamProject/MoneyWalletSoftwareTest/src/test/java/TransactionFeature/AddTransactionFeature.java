package TransactionFeature;

import Util.DateUtil;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class AddTransactionFeature extends BaseTranscation {
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
    public void Add_Transcation_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC1() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        dto.setShowInTotalWallet(false);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC2() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        dto.setComfirm(false);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC3() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);
        dto.setNote("Test");
        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC4() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);
        dto.setPlace("Taipei", "Taipei");

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC5() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);
        dto.setPeople(new String[] {"Little Hua"});
        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC6() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);
        dto.setEventName("TestEvent");

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

//    @Test // infesible path
//    public void Add_Transcation_BCC7() throws Exception {
//        TranscationDTO dto = new TranscationDTO();
//        dto.setAmount("22000.00");
//        dto.setDescription("lucky money");
//        dto.setCategoryType(CategoryType.INCOMES);
//        dto.setCategoryName("Salary");
//        dto.setDateBlockType(DateBlockType.CURRENT);
//
//        Add_Transcation(dto);
//        Verify_Transcation_Add(dto, "22,000.00");
//    }

    @Test
    public void Add_Transcation_BCC8() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC9() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.AFTER);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC10() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.EXPENSES);
        dto.setCategoryName("Hobby");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC11() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "22,000.00");
    }

    @Test
    public void Add_Transcation_BCC12() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("-22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "-22,000.00");
    }

    @Test
    public void Add_Transcation_BCC13() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("9999999999999999");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "9,999,999,999,999,999");
    }

    @Test
    public void Add_Transcation_BCC14() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("-9999999999999999");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Verify_Transcation_Add(dto, "-9,999,999,999,999,999");
    }

    private void Verify_Transcation_Add(TranscationDTO dto, String verify_amount) throws Exception {
        String baseLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
        String categoryLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getCategoryName());
        String mountLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]", verify_amount);
        String descriptLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getDescription());
        System.out.println(DateUtil.getFormatDate(dto.getDate()));
        String dateLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]", DateUtil.getFormatDate(dto.getDate()));

        Verify_Element_Is_NOT_Null_ByXPath(categoryLocator);
        Verify_Element_Is_NOT_Null_ByXPath(mountLocator);
        Verify_Element_Is_NOT_Null_ByXPath(descriptLocator);
        Verify_Element_Is_NOT_Null_ByXPath(dateLocator);
    }

}
