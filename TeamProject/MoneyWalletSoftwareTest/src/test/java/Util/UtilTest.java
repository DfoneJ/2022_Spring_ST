package Util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilTest {

//    @Test
//    public void testGetFormatDate()
//    {
//        Assert.assertEquals("Sun 12 Jun 2022", DateUtil.getFormatDate(new Date()));
//    }

    @Test
    public void testGetFormatDate2()
    {
        Assert.assertEquals("14 June 2022", DateUtil.getFormatDateForCanlander(DateUtil.getSpecifyDate(2022,6,14)));
    }

    @Test
    public void testGetSpecifyDate() {
        Assert.assertEquals("Wed 01 Jun 2022", DateUtil.getFormatDate(DateUtil.getSpecifyDate(2022,6,1)));
    }
    @Test
    public void testGetSpecifyDate2() {
        Assert.assertEquals("Thu 30 Jun 2022", DateUtil.getFormatDate(DateUtil.getSpecifyDate(2022,6,30)));
    }


//    @Test
//    public void testGetMoneyFormat() {
//        Assert.assertEquals("10,000,000", StringFormatUtil.getFormatMoney("10000000"));
//    }
//
//    @Test
//    public void testGetMoneyFormat2() {
//        Assert.assertEquals("10,000,000.00", StringFormatUtil.getFormatMoney("10000000.00"));
//    }
//
//    @Test
//    public void testGetMoneyFormat3() {
//        Assert.assertEquals("999", StringFormatUtil.getFormatMoney("999"));
//    }
}
