package nl.bsoft.behavioral.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoilRemoval {
    private static final Logger logger = LoggerFactory.getLogger(SoilRemoval.class);

    public void low() {
        logger.info("Setting Soil Removal to low");
    }

    public void medium() {
        logger.info("Setting Soil Removal to medium");
    }

    public void high() {
        logger.info("Setting Soil Removal to high");
    }
}
