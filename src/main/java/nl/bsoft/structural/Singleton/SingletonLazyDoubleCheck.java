package nl.bsoft.structural.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonLazyDoubleCheck {
    private static final Logger logger = LoggerFactory.getLogger(SingletonLazyDoubleCheck.class);

    private volatile static SingletonLazyDoubleCheck sc = null;

    private SingletonLazyDoubleCheck() {
    }

    public static SingletonLazyDoubleCheck getInstance() {
        if (sc == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (sc == null) {
                    sc = new SingletonLazyDoubleCheck();
                }
            }
        }
        return sc;
    }
}
