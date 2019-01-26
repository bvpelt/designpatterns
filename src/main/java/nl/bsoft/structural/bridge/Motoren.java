package nl.bsoft.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Motoren extends Car {
    private static final Logger logger = LoggerFactory.getLogger(Motoren.class);

    public Motoren(Product product, String carType) {
        super(product, carType);
    }

    @Override
    public void assemble() {
        logger.info("Assembling " + getProduct().getProductName() + " for " + getCarType());
    }

    @Override
    public void produceProduct() {
        getProduct().produce();
        logger.info("Modifing product " + getProduct().getProductName() + " according to " + getCarType());
    }

}
