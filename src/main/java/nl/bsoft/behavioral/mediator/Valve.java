package nl.bsoft.behavioral.mediator;

import nl.bsoft.behavioral.observer.Colleague;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Valve implements Colleague {
    private static final Logger logger = LoggerFactory.getLogger(Valve.class);

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void open() {
        logger.info("Valve is opened...");
        logger.info("Filling water...");
        mediator.closed();
    }

    public void closed() {
        logger.info("Valve is closed...");
        mediator.on();
    }
}
