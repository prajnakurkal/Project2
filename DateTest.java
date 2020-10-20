package tst;

import bank.Date;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 DateTest class is a test class for isValid, a date method.
 It has a few tests to check if isValid is functioning correctly.
 @author Sarah Law, Zill Soni, Prajna Kurkal
 */
public class DateTest {

    //Test if it true for leap year value
    @org.junit.jupiter.api.Test
    @Test
    public void isValid_testLeapYear_shouldBeTrue() {
        Date leapYearDate = new Date(2, 29, 2020);
        assertTrue(leapYearDate.isValid());
    }

    //Test if it true for a thirty day month
    @org.junit.jupiter.api.Test
    @Test
    public void isValid_testthirtyDays_shouldBeTrue() {
        Date thirtyDayMonth = new Date(4, 31, 2020);
        assertFalse(thirtyDayMonth.isValid());
    }

    //Test for an impossible day
    @org.junit.jupiter.api.Test
    @Test
    public void isValid_negativeDay_shouldBeFalse() {
        Date imposibleDay = new Date(4, -1, 2020);
        assertFalse(imposibleDay.isValid());
    }

    //Test for an impossible month
    @org.junit.jupiter.api.Test
    @Test
    public void isValid_impossibleMonth_shouldBeFalse() {
        Date imposibleMonth = new Date(15, 2, 2020);
        assertFalse(imposibleMonth.isValid());
    }
}