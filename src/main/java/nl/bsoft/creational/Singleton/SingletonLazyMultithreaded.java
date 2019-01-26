package nl.bsoft.creational.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonLazyMultithreaded {
    private static final Logger logger = LoggerFactory.getLogger(SingletonLazyMultithreaded.class);

    private static SingletonLazyMultithreaded sc = null;

    private SingletonLazyMultithreaded() {
    }

    public static synchronized SingletonLazyMultithreaded getInstance() {
        if (sc == null) {
            sc = new SingletonLazyMultithreaded();
        }
        return sc;
    }
}
