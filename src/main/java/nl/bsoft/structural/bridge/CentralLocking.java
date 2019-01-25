package nl.bsoft.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CentralLocking implements Product {
    private static final Logger logger = LoggerFactory.getLogger(CentralLocking.class);

    private final String productName;

    public CentralLocking(String productName) {
        this.productName = productName;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        logger.info("Producing Central Locking System");
    }
}
