package nl.bsoft.behavioral;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ObserverTest {
    private static final Logger logger = LoggerFactory.getLogger(ObserverTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void testObserver() {
        logger.info("Start test: {}", name.getMethodName());
        String match01 = "Soccer Match [2014AUG24]";
        String match02 = "Football Match [2014SEP17]";
        String user01 = "Adam Warner [New York]";
        String user02 = "Tim Ronney [London]";
        String user03 = "Marrie [Paris]";

        Subject subject01 = new CommentaryObject(new ArrayList<Observer>(), match01);
        Subject subject02 = new CommentaryObject(new ArrayList<Observer>(), match02);

        Observer observer = new SMSUsers(subject01, user01);
        observer.subscribe();


        Observer observer2 = new SMSUsers(subject01, user02);
        observer2.subscribe();

        Commentary cObject = ((Commentary) subject01);
        cObject.setDesc("Welcome to live Soccer match");
        cObject.setDesc("Current score 0-0");

        observer2.unSubscribe();

        cObject.setDesc("It’s a goal!!");
        cObject.setDesc("Current score 1-0");

        Observer observer3 = new SMSUsers(subject01, user03);
        observer3.subscribe();

        cObject.setDesc("It’s another goal!!");
        cObject.setDesc("Half-time score 2-0");

        logger.info("End   test: {}", name.getMethodName());
    }
}
