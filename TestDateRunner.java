package tst;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 TestDateRunner class is a test class for isValid, a date method.
 It has a few tests to check if isValid is functioning correctly by running some tests in DateTest.
 @author Sarah Law, Zill Soni, Prajna Kurkal
 */
public class TestDateRunner {

    /**
     Runs the method to test isValid.
     Does not expect any input from args here.
     @param args inputs and commands given by user
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DateTest.class);
    }
}