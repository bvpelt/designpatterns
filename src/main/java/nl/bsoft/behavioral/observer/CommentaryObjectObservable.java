package nl.bsoft.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;

public class CommentaryObjectObservable extends Observable implements Commentary {
    private static final Logger logger = LoggerFactory.getLogger(CommentaryObjectObservable.class);
    private final String subjectDetails;
    private String desc;

    public CommentaryObjectObservable(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        setChanged();
        notifyObservers(desc);
    }

    public String subjectDetails() {
        return subjectDetails;
    }
}
