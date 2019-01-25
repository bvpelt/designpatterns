package nl.bsoft.structural.facade;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacadeTest {
    private static final Logger logger = LoggerFactory.getLogger(FacadeTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void testFacade() {
        logger.info("Start test: {}", name.getMethodName());
        ScheduleServer ss = new ScheduleServer();
        ScheduleServerFacade sf = new ScheduleServerFacade(ss);

        sf.startServer();
        Assert.assertEquals(ServerState.READY, sf.getServerState());
        sf.stopServer();
        Assert.assertEquals(ServerState.INITED, sf.getServerState());

        logger.info("End   test: {}", name.getMethodName());
    }
}
