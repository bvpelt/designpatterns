package nl.bsoft.structural.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleServerFacade {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServerFacade.class);

    private final ScheduleServer scheduleServer;

    public ScheduleServerFacade(ScheduleServer scheduleServer) {
        this.scheduleServer = scheduleServer;
    }

    public void startServer() {
        logger.info("startServer");
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }

    public void stopServer() {
        logger.info("startServer");
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }

    public ServerState getServerState() {
        return scheduleServer.getState();
    }
}
