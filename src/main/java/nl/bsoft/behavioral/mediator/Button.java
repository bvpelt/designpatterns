package nl.bsoft.behavioral.mediator;

import nl.bsoft.behavioral.observer.Colleague;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Button implements Colleague {
    private static final Logger logger = LoggerFactory.getLogger(Button.class);

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void press() {
        logger.info("Button pressed.");
        mediator.start();
    }
}
