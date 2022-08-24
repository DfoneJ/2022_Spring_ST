package OverviewFeature;

import TransactionFeature.BaseTranscation;
import TransactionFeature.CategoryType;
import TransactionFeature.DateBlockType;
import TransactionFeature.TranscationDTO;
import Util.FunctionalAbstractTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OverviewFeature extends BaseTranscation {

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
    public void Overview_BaseChoice() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.EXPENSES);
        dto2.setCategoryName("Hobby");
        dto2.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("monthly", "Net incomes");
        Verify_Overview("monthly", "$ 10,999.45");
    }

    @Test
    public void Overview_BCC1() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.EXPENSES);
        dto2.setCategoryName("Hobby");
        dto2.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("monthly", "Only incomes");
        Verify_Overview("monthly", "$ 22,000.00");
    }

    @Test
    public void Overview_BCC2() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.EXPENSES);
        dto.setCategoryName("Hobby");
        dto.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.EXPENSES);
        dto2.setCategoryName("Hobby");
        dto2.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("monthly", "Only expenses");
        Verify_Overview("monthly", "$ 33,000.55");
    }

    @Test
    public void Overview_BCC3() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.INCOMES);
        dto2.setCategoryName("Salary");
        dto2.setDateBlockType(DateBlockType.CURRENT);
        //dto2.setDate(2022,6, 2);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("daily", "Net incomes");
        Verify_Overview("daily", "$ 22,000.00", "$ 11,000.55");
    }

    @Test
    public void Overview_BCC4() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.INCOMES);
        dto2.setCategoryName("Salary");
        dto2.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("weekly", "Net incomes");
        Verify_Overview("weekly", "$ 22,000.00", "$ 11,000.55");
    }

    @Test
    public void Overview_BCC5() throws Exception {
        TranscationDTO dto = new TranscationDTO();
        dto.setAmount("22000.00");
        dto.setDescription("lucky money");
        dto.setCategoryType(CategoryType.INCOMES);
        dto.setCategoryName("Salary");
        dto.setDateBlockType(DateBlockType.BEFORE);

        Add_Transcation(dto);

        TranscationDTO dto2 = new TranscationDTO();
        dto2.setAmount("11000.55");
        dto2.setDescription("current money");
        dto2.setCategoryType(CategoryType.INCOMES);
        dto2.setCategoryName("Salary");
        dto2.setDateBlockType(DateBlockType.CURRENT);

        Add_Transcation(dto2);
        GOTO_Overview_View();

        Set_Filter("yearly", "Net incomes");
        Verify_Overview("yearly", "$ 33,000.55");
    }

    private void Set_Filter(String group, String content) throws Exception {
        Click_Overview_Setting_Button();
        Select_Overview_Start_Date();
        Select_Overview_Group(group);
        Select_Overview_Transcation_Content(content);
        Click_OK_Button_On_Overview();
    }

    private void Verify_Overview(String group, String verify_amount) throws Exception {
        if (group.equals("monthly") || group.equals("yearly")) {
            String showed_amount = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]").getText();
            System.out.println(showed_amount);
            Assert.assertEquals(showed_amount, verify_amount );
        }
    }

    private void Verify_Overview(String group, String verify_amount, String verify_amount2) throws Exception {
        // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView//*[@text="$ 1.00"]
        if (group.equals("daily") || group.equals("weekly")) {
            String showed_amount = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]").getText();
            System.out.println(showed_amount);
            Assert.assertEquals(showed_amount, verify_amount );
            Thread.sleep(sleeptime);

//            String showed_amount2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]").getText();
//            System.out.println(showed_amount2);
//            Assert.assertEquals(showed_amount2, verify_amount2 );
//            Thread.sleep(sleeptime);

            long time = System.currentTimeMillis();
            long time2 = System.currentTimeMillis();
            MobileElement amount2 = null;
            while (amount2 == null && time2 - time <= 10000) {
                time2 = System.currentTimeMillis();
                try {
                    Thread.sleep(sleeptime);
                    amount2 = driver.findElementByXPath(String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView//*[@text=\"%s\"]", verify_amount2));
                    Assert.assertEquals(amount2.getText(), verify_amount2);
                    return;
                }
                catch (Exception e) {
                    swipe.Up();
                }
            }
            Assert.fail();
        }
    }
}
