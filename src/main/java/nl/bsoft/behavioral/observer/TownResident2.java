package nl.bsoft.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TownResident2 implements SpringObserver {
    private static final Logger logger = LoggerFactory.getLogger(TownResident2.class);

    public void update(String messageText) {
        logger.info("Greetings my name is: " + this);
        logger.info("I heard: " + messageText);
    }
}
