package TransactionFeature;

import Util.FunctionalAbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class SeachTranscation extends BaseTranscation  {
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
    public void Search_Transcation_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);
        Search_Transcation(dto);
        Verify_Search_Transcation(dto);
    }

    private void Search_Transcation(TranscationDTO dto) throws Exception {
        Click_Search_Transcation_Button();
        Input_Search_Transcation(dto.getDescription());
    }

    private void Verify_Search_Transcation(TranscationDTO dto) throws Exception {
        String locator = String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@text=\"%s\"]", dto.getDescription());

        Verify_Element_Is_NOT_Null_ByXPath(locator);
    }
}
