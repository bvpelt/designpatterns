package nl.bsoft.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Car {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);

    private final Product product;
    private final String carType;

    public Car(Product product, String carType) {
        this.product = product;
        this.carType = carType;
    }

    public abstract void assemble();

    public abstract void produceProduct();

    public void printDetails() {
        logger.info("Car: " + carType + ", Product:" + product.productName());
    }
}
