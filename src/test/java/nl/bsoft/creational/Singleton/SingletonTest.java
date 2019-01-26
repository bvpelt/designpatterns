package nl.bsoft.creational.Singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonTest {
    private static final Logger logger = LoggerFactory.getLogger(SingletonTest.class);

    @Test
    public void singleTonTest() throws ClassNotFoundException {
        MySingleton ms01 = null;
        MySingleton ms02 = null;
        MySingleton ms03 = null;
        String value01 = "Singleton Value: 01";
        String value02 = "Singleton Value: 02";

        ms01 = MySingleton.getInstance();
        ms01.setValue(value01);
        Assert.assertEquals(value01, ms01.getValue());
        logger.info("MySingleton value: {}", ms01.getValue());

        ms02 = MySingleton.getInstance();
        ms02.setValue(value02);
        Assert.assertEquals(value02, ms02.getValue());
        Assert.assertEquals(value02, ms01.getValue());
        logger.info("MySingleton value: {}", ms02.getValue());
        logger.info("MySingleton value: {}", ms01.getValue());


        ClassLoader classLoader = MySingleton.class.getClassLoader();
        try {
            String className = "nl.bsoft.creational.Singleton.MySingleton";
            Class aClass = classLoader.loadClass(className);
            logger.info("aClass.getName() = {}", aClass.getName());
            Assert.assertEquals(className, aClass.getName());
        } catch (ClassNotFoundException e) {
            logger.error("Class not loaded, reason: {}", e);
        }
    }
}
