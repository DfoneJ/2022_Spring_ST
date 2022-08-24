package ModelFeature;

import TransactionFeature.CategoryType;
import TransactionFeature.TranscationDTO;
import Util.FunctionalAbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class DeleteTranscationModel extends BaseModel {
    // Data Member //
    TranscationDTO dto;

    //Public Method //
    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        dto = new TranscationDTO();
        dto.setAmount("10.0");
        dto.setDescription("Test");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setComfirm(true);
        dto.setShowInTotalWallet(true);

        GOTO_Models_View();
        Add_Transcation_Model(dto);
    }

    @AfterMethod
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void Delete_Transcation_Model_BaseChoice() throws Exception {
        Delete_Transcation_Model(dto);
        Verify_Model_Is_Delete(dto);
    }

    private void Delete_Transcation_Model(TranscationDTO dto) throws Exception {
        Select_Model_On_Model_List_View(dto.getDescription());
        Click_Delete_Model_Button();
    }

    private void Verify_Model_Is_Delete(TranscationDTO dto) throws Exception {
        String baseLocator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout";
        String categoryLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getCategoryName());
        String mountLocator = String.format(baseLocator + "//*[contains(@text, \"%s\")]", dto.getAmount().toString());
        String descriptLocator = String.format(baseLocator + "//*[@text=\"%s\"]", dto.getDescription());

        Verify_Element_Is_Null_ByXPath(categoryLocator);
        Verify_Element_Is_Null_ByXPath(mountLocator);
        Verify_Element_Is_Null_ByXPath(descriptLocator);
    }
}
