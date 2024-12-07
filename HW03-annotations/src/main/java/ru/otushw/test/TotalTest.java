package ru.otushw.test;

//класс для подсчета тестов
public class TotalTest {
    private int passed = 0;
    private int failed = 0;
    private int total = 0;

    public void incPassedTests() {
        passed++;
        total++;
    }

    public void incFailedTests() {
        failed++;
        total++;
    }

    public int getPassed() {
        return passed;
    }

    public int getFailed() {
        return failed;
    }

    public int getTotal() {
        return total;
    }
}
