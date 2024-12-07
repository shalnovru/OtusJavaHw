package ru.otushw.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otushw.annotations.Before;
import ru.otushw.annotations.Test;
import ru.otushw.annotations.After;

//класс для запуска

public class ExecTest {

    private static final Logger log = LoggerFactory.getLogger(ExecTest.class);

    public void runTests(CalcTest testClass) {
        TotalTest testResult = new TotalTest();

        Method beforeMethod = findBeforeMethod(testClass);
        Method afterMethod = findAfterMethod(testClass);
        List<Method> testMethods = findTestMethods(testClass);

        for (Method method : testMethods) {
            runTest(beforeMethod, afterMethod, method, testClass, testResult);
        }

        printTestStatistics(testResult);
    }

    private Method findAfterMethod(CalcTest testClass) {
        for (Method method : testClass.getClass().getMethods()) {
            if (method.isAnnotationPresent(After.class)) {
                return method;
            }
        }
        return null;
    }

    private Method findBeforeMethod(CalcTest testClass) {
        for (Method method : testClass.getClass().getMethods()) {
            if (method.isAnnotationPresent(Before.class)) {
                return method;
            }
        }
        return null;
    }



    private List<Method> findTestMethods(CalcTest testClass) {
        List<Method> testMethods = new ArrayList<>();
        for (Method method : testClass.getClass().getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
        return testMethods;
    }

    private void runTest(Method beforeMethod, Method afterMethod, Method testMethod,
                         CalcTest testClass, TotalTest testResult) {
        try {
            if (beforeMethod != null) {
                beforeMethod.invoke(testClass);
            }

            testMethod.invoke(testClass);
            testResult.incPassedTests();
        } catch (Exception e) {
            testResult.incFailedTests();
            log.info("Test failed {}", testMethod.getName());
            log.error("with exception: {}", e.getMessage());
        } finally {
            if (afterMethod != null) {
                try {
                    afterMethod.invoke(testClass);
                } catch (Exception e) {
                    log.error("After method failed with exception:", e);
                }
            }
        }
    }

    private void printTestStatistics(TotalTest testRes) {

        log.info("Statistics:");
        log.info("Total: {}", testRes.getTotal());
        log.info("Success: {}" , testRes.getPassed());
        log.info("Fail: {}" , testRes.getFailed());
    }

}
