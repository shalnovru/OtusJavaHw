package ru.otus.domain;

import java.util.Map;

public class CashPoint {

    private final MoneyBox moneyBox = new MoneyBox();

    public void deposit(Denomination denomination, int count) {
        moneyBox.deposit(denomination, count);
    }

    public Map<Denomination, Integer> withdraw(int amount) {
        return moneyBox.withdraw(amount);
    }

    public int getBalance() {
        return moneyBox.getBalance();
    }

    public Map<Denomination, Integer> getStorageState() {
        return moneyBox.getStorageState();
    }
}
