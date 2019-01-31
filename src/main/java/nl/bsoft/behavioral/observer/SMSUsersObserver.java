package nl.bsoft.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;

public class SMSUsersObserver implements java.util.Observer {
    private static final Logger logger = LoggerFactory.getLogger(SMSUsers.class);
    private final String userInfo;
    private final Observable observable;
    private String desc;

    public SMSUsersObserver(Observable observable, String userInfo) {
        this.observable = observable;
        this.userInfo = userInfo;
    }

    public void subscribe() {
        logger.info("Subscribing " + userInfo + " to " + ((
                CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.addObserver(this);
        logger.info("Subscribed successfully.");
    }

    public void unSubscribe() {
        logger.info("Unsubscribing " + userInfo + " to " + ((
                CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.deleteObserver(this);
        logger.info("Unsubscribed successfully.");
    }

    @Override
    public void update(Observable o, Object arg) {
        desc = (String) arg;
        display();
    }

    private void display() {
        logger.info("[" + userInfo + "]: " + desc);
    }
}
