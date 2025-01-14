package ru.otus;

import ru.otus.impl.TestLogging;
import ru.otus.interfaces.TestLoggingInterface;
import ru.otus.proxy.LoggingProxy;

public class Main {
    public static void main(String[] args) {
        TestLoggingInterface logging = LoggingProxy.createLoggingProxy(new TestLogging(), TestLoggingInterface.class);

        logging.calculation(7);
        logging.calculation(5, 6);
        logging.calculation(4, 3, "test");
    }
}