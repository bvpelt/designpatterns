package nl.bsoft.structural.bridge;

import nl.bsoft.structural.composite.CompositeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BridgeTest {
    private static final Logger logger = LoggerFactory.getLogger(BridgeTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void bridgeTest() {
        Product product = new CentralLocking("Central Locking System");
        Product product2 = new GearLocking("Gear Locking System");
        Car car = new BigWheel(product , "BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        car = new BigWheel(product2 , "BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
        car = new Motoren(product, "Motoren lm model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        car = new Motoren(product2, "Motoren lm model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
    }
}
