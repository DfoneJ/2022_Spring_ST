package TransactionFeature;

import Util.DateUtil;
import Util.FunctionalAbstractTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class DeleteTranscationFeature extends BaseTranscation {
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
    public void Delete_Transcation_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Delete_Transcation(dto);
        Verify_Transcation_Delete(dto, "22,000.00");
    }

    private void Delete_Transcation(TranscationDTO dto) throws Exception {
        Select_Transcation_On_Transcation_List_View(dto.getDescription());
        Click_Delete_Transcation_Button();
    }

    private void Verify_Transcation_Delete(TranscationDTO dto, String verify_amount) throws Exception {
        String baseLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
        String categoryLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getCategoryName());
        String mountLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]", verify_amount);
        String descriptLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getDescription());
        String dateLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]]", DateUtil.getFormatDate(dto.getDate()));

        Verify_Element_Is_Null_ByXPath(categoryLocator);
        Verify_Element_Is_Null_ByXPath(mountLocator);
        Verify_Element_Is_Null_ByXPath(descriptLocator);
        Verify_Element_Is_Null_ByXPath(dateLocator);
    }
}
