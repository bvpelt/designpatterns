package nl.bsoft.behavioral.mediator;

import nl.bsoft.behavioral.observer.Colleague;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Motor implements Colleague {
    private static final Logger logger = LoggerFactory.getLogger(Motor.class);

    @Override
    public void setMediator(MachineMediator mediator) {

    }

    public void startMotor() {
        logger.info("Started motor");
    }

    public void rotateDrum(int rpm) {
        logger.info("Rotating drum at: {} rpm", rpm);
    }
}
