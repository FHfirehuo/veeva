import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VeeVaCalendarTest {

    @Test
    void dayOfYearInvalidDayTest() {
        int actualDay = VeeVaCalendar.dayOfYear(2015, 2, 29);
        Assertions.assertEquals(-1, actualDay);
    }

    @Test
    void dayOfYearInvalidDay1Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 2, 30);
        Assertions.assertEquals(-1, actualDay);
    }

    @Test
    void dayOfYearInvalidDay2Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 4, 31);
        Assertions.assertEquals(-1, actualDay);
    }

    @Test
    void dayOfYearInvalidMonthTest() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 13, 1);
        Assertions.assertEquals(-1, actualDay);
    }

    //公历年份是整百数的，必须是400的倍数才是闰年
    @Test
    void dayOfYearInvalidLeapYearTest() {
        int actualDay = VeeVaCalendar.dayOfYear(1900, 2, 29);
        Assertions.assertEquals(-1, actualDay);
    }

    @Test
    void dayOfYearEffectiveTest() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 2, 29);
        Assertions.assertEquals(60, actualDay);
    }

    //给定年= 2016 ，月= 1 ，日= 3 的输入，函数应该返回 3 作为日期
    @Test
    void dayOfYear3Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 1, 3);
        Assertions.assertEquals(3, actualDay);
    }

    //年= 2016 ,月= 2 ,日= 1 .函数应该返回 32
    @Test
    void dayOfYear32Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2016, 2, 1);
        Assertions.assertEquals(32, actualDay);
    }

    @Test
    void dayOfYear365Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2021, 12, 31);
        Assertions.assertEquals(365, actualDay);
    }

    @Test
    void dayOfYear366Test() {
        int actualDay = VeeVaCalendar.dayOfYear(2020, 12, 31);
        Assertions.assertEquals(366, actualDay);
    }
}