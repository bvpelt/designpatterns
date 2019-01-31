package nl.bsoft.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TownCrier implements SpringSubject {
    private static final Logger logger = LoggerFactory.getLogger(TownCrier.class);

    private List townResident = new ArrayList();
    private String messageText;

    // this message is added so I can give
    // this class a reason to call notifyListener.
    public void setMessage(String message) {
        logger.info("I'm the Town Crier and I've got a message: " + message);
        this.messageText = message;
        this.notifyListeners();
    }

    public void addListener(SpringObserver o) {
        this.townResident.add(o);
    }

    public void removeListener(SpringObserver o) {
        this.townResident.remove(o);
    }


    // call the update method on
    // each observer (town resident)
    public void notifyListeners() {
        for (Iterator iter = townResident.iterator(); iter.hasNext(); ) {
            SpringObserver listener = (SpringObserver) iter.next();
            listener.update(messageText);
        }
    }

}
