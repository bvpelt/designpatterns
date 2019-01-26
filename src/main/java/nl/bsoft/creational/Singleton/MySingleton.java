package nl.bsoft.creational.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectStreamException;

public class MySingleton {
    private static final Logger logger = LoggerFactory.getLogger(MySingleton.class);
    private static final long serialVersionUID = -1093810940935176595L;
    private static MySingleton sc = new MySingleton();
    private String value;

    private MySingleton() {
        if (sc != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    public static MySingleton getInstance() {
        return sc;
    }

    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = MySingleton.class.getClassLoader();
        return (classLoader.loadClass(classname));
    }

    private Object readResolve() throws ObjectStreamException {
        return sc;
    }

    private Object writeReplace() throws ObjectStreamException {
        return sc;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("MySingleton, cannot be clonned");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
