package ModelFeature;

import TransactionFeature.TranscationDTO;
import Util.FunctionalAbstractTest;

public class BaseModel extends FunctionalAbstractTest {

    protected void Add_Transcation_Model(TranscationDTO dto) throws Exception {
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
            GOTO_Models_View();

        Click_Add_Model_Button();
        Thread.sleep(sleeptime);
        Enter_Model_Information(dto);
        Click_Confirm_Add_Model_Button_On_Model_View();
    }
}
