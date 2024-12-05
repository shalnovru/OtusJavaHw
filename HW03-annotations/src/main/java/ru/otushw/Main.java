package ru.otushw;


import ru.otushw.test.CalcTest;
import ru.otushw.test.ExecTest;

public class Main {

    public static void main(String[] args) {
        CalcTest testClass = new CalcTest();
        ExecTest testRunner = new ExecTest();

        testRunner.runTests(testClass);
    }
}