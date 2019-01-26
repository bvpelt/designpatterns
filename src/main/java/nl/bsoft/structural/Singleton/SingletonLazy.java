package nl.bsoft.structural.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonLazy {
    private static final Logger logger = LoggerFactory.getLogger(SingletonLazy.class);

    private static SingletonLazy sc = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (sc == null) {
            sc = new SingletonLazy();
        }
        return sc;
    }
}
