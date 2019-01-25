package nl.bsoft.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GearLocking implements Product {
    private static final Logger logger = LoggerFactory.getLogger(GearLocking.class);

    private final String productName;

    public GearLocking(String productName) {
        this.productName = productName;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        logger.info("Producing Gear Locking System");
    }
}
