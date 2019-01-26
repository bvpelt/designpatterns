package nl.bsoft.creational.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletoneEnum {
    private static final Logger logger = LoggerFactory.getLogger(SingletoneEnum.class);

    public enum SingleEnum {
        SINGLETON_ENUM
    }
}
