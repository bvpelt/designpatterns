package nl.bsoft.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSUsers implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(SMSUsers.class);

    private final Subject subject;
    private String desc;
    private String userInfo;

    public SMSUsers(Subject subject, String userInfo) {
        if (subject == null) {
            throw new IllegalArgumentException("No Publisher found.");
        }
        this.subject = subject;
        this.userInfo = userInfo;
    }

    @Override
    public void update(String desc) {
        this.desc = desc;
        display();
    }

    private void display() {
        logger.info("[{}]: {}", userInfo, desc);
    }

    @Override
    public void subscribe() {
        logger.info("Subscribing {} to {} ...", userInfo, subject.subjectDetails());
        this.subject.subscribeObserver(this);
        logger.info("Subscribed successfully.");
    }

    @Override
    public void unSubscribe() {
        logger.info("Unsubscribing {} to {} ...", userInfo, subject.subjectDetails());
        this.subject.unSubscribeObserver(this);
        logger.info("Unsubscribed successfully.");
    }
}
