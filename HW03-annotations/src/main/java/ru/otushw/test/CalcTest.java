package ru.otushw.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otushw.annotations.After;
import ru.otushw.annotations.Before;
import ru.otushw.annotations.Test;

//класс с тестами
public class CalcTest {
    private static final Logger log = LoggerFactory.getLogger(CalcTest.class);

    @Before
    public void setup() {
        log.info("Before method: Test setup.");
    }

    @Test
    public void testAdd() {
        log.info("Test method: Testing addition operation.");
        int a = 2;
        int b = 2;
        int result = a + b;
        int expected = 4;

        if (result != expected) {
            throw new AssertionError("Test failed: Expected " + expected + " but got " + result);
        } else {
            log.info("Test passed: Addition was correct.");
        }
    }

    @Test
    public void testSub() {
        log.info("Test method: Testing subtraction operation.");
        int a = 4;
        int b = 2;
        int result = a - b;
        int expected = 2;




        if (result != expected) {
            throw new AssertionError("Test failed");
        } else {
            log.info("Test passed: Subtraction was correct.");
        }
    }

    @Test
    public void testErrorScenario() {
        log.info("Test method: Testing testErrorScenario.");

        int a = 2;
        int b = 2;
        int result = a + b;
        int expected = 3;

        // Проверка
        if (result != expected) {
            throw new AssertionError("Test failed: Expected " + expected + " but got " + result);
        } else {
            log.info("Test passed: The error scenario was handled correctly.");
        }
    }

    @After
    public void tearDown() {
        log.info("After method: Test cleanup.");
    }
}
