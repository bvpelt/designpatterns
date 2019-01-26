package nl.bsoft.creational.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonEager {
    private static final Logger logger = LoggerFactory.getLogger(SingletonEager.class);

    private static SingletonEager sc = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return sc;
    }
}
