package nl.bsoft.structural.bridge;

import org.junit.Assert;
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
        String centralLockingSystem = "Central Locking System";
        String gearLockingSystem = "Gear Locking System";
        String bigWheelXzModel = "BigWheel xz model";
        String motorenLmModel = "Motoren lm model";

        Product product = new CentralLocking(centralLockingSystem);
        Product product2 = new GearLocking(gearLockingSystem);
        Assert.assertEquals(product.getProductName(), centralLockingSystem);
        Assert.assertEquals(product2.getProductName(), gearLockingSystem);

        Car bigWheelXzModel01 = new BigWheel(product, bigWheelXzModel);
        bigWheelXzModel01.produceProduct();
        bigWheelXzModel01.assemble();
        bigWheelXzModel01.printDetails();
        Assert.assertEquals(bigWheelXzModel01.getCarType(), bigWheelXzModel);
        Assert.assertEquals(bigWheelXzModel01.getProduct().getProductName(), centralLockingSystem);

        Car bigWheelXzModel02 = new BigWheel(product2, bigWheelXzModel);
        bigWheelXzModel02.produceProduct();
        bigWheelXzModel02.assemble();
        bigWheelXzModel02.printDetails();
        Assert.assertEquals(bigWheelXzModel02.getCarType(), bigWheelXzModel);
        Assert.assertEquals(bigWheelXzModel02.getProduct().getProductName(), gearLockingSystem);

        Car motorenLmModel01 = new Motoren(product, motorenLmModel);
        motorenLmModel01.produceProduct();
        motorenLmModel01.assemble();
        motorenLmModel01.printDetails();
        Assert.assertEquals(motorenLmModel01.getCarType(), motorenLmModel);
        Assert.assertEquals(motorenLmModel01.getProduct().getProductName(), centralLockingSystem);

        Car motorenLmModel02 = new Motoren(product2, motorenLmModel);
        motorenLmModel02.produceProduct();
        motorenLmModel02.assemble();
        motorenLmModel02.printDetails();
        Assert.assertEquals(motorenLmModel02.getCarType(), motorenLmModel);
        Assert.assertEquals(motorenLmModel02.getProduct().getProductName(), gearLockingSystem);
    }
}
