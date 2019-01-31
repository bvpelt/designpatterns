package nl.bsoft.behavioral.mediator;

import nl.bsoft.behavioral.observer.Colleague;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Heater implements Colleague {
    private static final Logger logger = LoggerFactory.getLogger(Heater.class);
    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void on(int temp) {
        logger.info("Heater is on...");
        if (mediator.checkTemperature(temp)) {
            logger.info("Temperature is set to " + temp);
            mediator.off();
        }
    }

    public void off() {
        logger.info("Heater is off...");
        mediator.wash();
    }
}
