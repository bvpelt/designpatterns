package nl.bsoft.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigWheel extends Car {
    private static final Logger logger = LoggerFactory.getLogger(BigWheel.class);

    private final Product product;
    private final String carType;

    public BigWheel(Product product, String carType) {
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }

    @Override
    public void assemble() {
        logger.info("Assembling " + product.productName() + " for " + carType);
    }

    @Override
    public void produceProduct() {
        product.produce();
        logger.info("Modifing product " + product.productName() + " according to " + carType);
    }
}
