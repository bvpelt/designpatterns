package nl.bsoft.behavioral;


import nl.bsoft.behavioral.observer.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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

    @Test
    public void testOldObserver() {
        logger.info("Start test: {}", name.getMethodName());

        String match01 = "Soccer Match [2014AUG24]";
        String user01 = "Adam Warner [New York]";
        String user02 = "Tim Ronney [London]";
        String user03 = "Marrie [Paris]";

        CommentaryObjectObservable obj = new CommentaryObjectObservable(match01);
        SMSUsersObserver observer = new SMSUsersObserver(obj, user01);
        SMSUsersObserver observer2 = new SMSUsersObserver(obj, user02);
        observer.subscribe();
        observer2.subscribe();
        obj.setDesc("Welcome to live Soccer match");
        obj.setDesc("Current score 0-0");
        observer.unSubscribe();
        obj.setDesc("It’s a goal!!");
        obj.setDesc("Current score 1-0");
        logger.info("End   test: {}", name.getMethodName());
    }

    @Test
    public void testStringObserver() {
        logger.info("Start test: {}", name.getMethodName());
        // launch the spring frame work.
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "classpath:ObserverContext.xml");
        // grab the Town Crier out of the spring
        // framework and send a message too all observers
        TownCrier crier = (TownCrier) ctx.getBean("townCrier");
        crier.setMessage("It is 1 O'Clock and all is well!");

        logger.info("End   test: {}", name.getMethodName());
    }
}
