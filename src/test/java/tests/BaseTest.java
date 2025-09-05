package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Log4j;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Log4j.startLog(this.getClass().getSimpleName());
        // Driver initialization vs...
    }

    @AfterMethod
    public void tearDown() {
        Log4j.endLog(this.getClass().getSimpleName());
        // Driver.quit() vs...
    }
}




