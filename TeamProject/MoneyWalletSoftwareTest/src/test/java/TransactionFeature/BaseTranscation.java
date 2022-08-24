package TransactionFeature;

import Util.DateUtil;
import Util.FunctionalAbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class BaseTranscation extends FunctionalAbstractTest {

    protected void Add_Transcation(TranscationDTO dto) throws Exception {
        boolean isReturnTranscationView = false;

        if (dto.getAccountName() != null) {

        }

        if (dto.getEventName() != null) {
            Add_Event(dto.getEventName());
            isReturnTranscationView = true;
        }

        if (dto.getPlaceName() != null && dto.getPlaceAddress() != null) {
            Add_Place(dto.getPlaceName(), dto.getPlaceAddress());
            isReturnTranscationView = true;
        }

        if (dto.getPeople() != null) {
            Add_People(dto.getPeople());
            isReturnTranscationView = true;
        }

        // go to back transcation view
        if (isReturnTranscationView)
            GOTO_Transcation_View();

        Thread.sleep(sleeptime);
        Click_Add_Transcation_Button();
        Enter_Transcation_Information(dto);
        Click_Confirm_Add_Transcation();
        Thread.sleep(sleeptime);
    }
}
