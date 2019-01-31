package nl.bsoft.behavioral;

import nl.bsoft.behavioral.mediator.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediatorTest {
    private static final Logger logger = LoggerFactory.getLogger(MediatorTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void testMediator() {
        logger.info("Start test: {}", name.getMethodName());
        MachineMediator mediator = null;
        Sensor sensor = new Sensor();
        SoilRemoval soilRemoval = new SoilRemoval();
        Motor motor = new Motor();
        Machine machine = new Machine();
        Heater heater = new Heater();
        Valve valve = new Valve();
        Button button = new Button();
        mediator = new CottonMediator(machine, heater, motor, sensor, soilRemoval,
                valve);
        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();
        mediator = new DenimMediator(machine, heater, motor, sensor, soilRemoval,
                valve);

        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();
        logger.info("End   test: {}", name.getMethodName());
    }
}
