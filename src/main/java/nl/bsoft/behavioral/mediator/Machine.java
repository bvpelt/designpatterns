package nl.bsoft.behavioral.mediator;

import nl.bsoft.behavioral.observer.Colleague;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Machine implements Colleague {
    private static final Logger logger = LoggerFactory.getLogger(Machine.class);

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void start() {
        mediator.open();
    }

    public void wash() {
        mediator.wash();
    }
}
