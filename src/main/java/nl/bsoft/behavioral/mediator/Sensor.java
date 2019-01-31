package nl.bsoft.behavioral.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sensor {
    private static final Logger logger = LoggerFactory.getLogger(Sensor.class);

    public boolean checkTemperature(int temp) {
        logger.info("Temperature reached " + temp + " *C");
        return true;
    }

}
