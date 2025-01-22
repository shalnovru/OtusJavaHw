package ru.otus;

import ru.otus.domain.CashPoint;
import ru.otus.domain.Denomination;
import ru.otus.exception.TransactionException;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CashPoint cashPoint = new CashPoint();

        cashPoint.deposit(Denomination.HUNDRED, 10);
        cashPoint.deposit(Denomination.FIFTY, 20);
        cashPoint.deposit(Denomination.TEN, 100);
        System.out.println("Текущий баланс: " + cashPoint.getBalance());

        try {
            Map<Denomination, Integer> withdrawn = cashPoint.withdraw(580);
            System.out.println("Выданные купюры: " + withdrawn);
        } catch (TransactionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Текущий баланс после снятия: " + cashPoint.getBalance());
        System.out.println("Состояние хранилища: " + cashPoint.getStorageState());
    }
}