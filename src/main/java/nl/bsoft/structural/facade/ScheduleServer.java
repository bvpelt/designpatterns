package nl.bsoft.structural.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleServer {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServer.class);

    private ServerState state = ServerState.NULL;

    public void startBooting() {
        if (state.equals(ServerState.NULL)) {
            logger.info("startBooting");
            state = ServerState.BOOTED;
        } else {
            logger.error("Booting not possible, current state: {}", state);
        }
    }

    public void readSystemConfigFile() {
        if (state.equals(ServerState.BOOTED)) {
            logger.info("readSystemConfigFile");
            state = ServerState.CONFIGURED;
        } else {
            logger.error("Reading system configfile not possible, current state: {}", state);
        }
    }

    public void init() {
        if (state.equals(ServerState.CONFIGURED)) {
            logger.info("init");
            state = ServerState.INITED;
        } else {
            logger.error("Initialisation not possible, current state: {}", state);
        }
    }

    public void initializeContext() {
        if (state.equals(ServerState.INITED)) {
            logger.info("initializeContext");
            state = ServerState.INITEDCONTEXT;
        } else {
            logger.error("Initialisation Context not possible, current state: {}", state);
        }
    }

    public void initializeListeners() {
        if (state.equals(ServerState.INITEDCONTEXT)) {
            logger.info("initializeListeners");
            state = ServerState.INITEDLISTENERS;
        } else {
            logger.error("Initialisation Listeners not possible, current state: {}", state);
        }
    }

    public void createSystemObjects() {
        if (state.equals(ServerState.INITEDLISTENERS)) {
            logger.info("createSystemObjects");
            state = ServerState.READY;
        } else {
            logger.error("Creating system objects not possible, current state: {}", state);
        }
    }

    public void releaseProcesses() {
        if (state.equals(ServerState.READY)) {
            logger.info("releaseProcesses");
            state = ServerState.RELEASEDPROCESSES;
        } else {
            logger.error("Releasing processes not possible, current state: {}", state);
        }
    }

    public void destory() {
        if (state.equals(ServerState.RELEASEDPROCESSES)) {
            logger.info("destory");
            state = ServerState.DESTROY;
        } else {
            logger.error("Destroy not possible, current state: {}", state);
        }
    }

    public void destroySystemObjects() {
        if (state.equals(ServerState.DESTROY)) {
            logger.info("destroySystemObjects");
            state = ServerState.DESTROYSYSTEMOBJECTS;
        } else {
            logger.error("Destroy system objects not possible, current state: {}", state);
        }
    }

    public void destoryListeners() {
        if (state.equals(ServerState.DESTROYSYSTEMOBJECTS)) {
            logger.info("destoryListeners");
            state = ServerState.DESTROYLISTENERS;
        } else {
            logger.error("Destroy listeners not possible, current state: {}", state);
        }
    }

    public void destoryContext() {
        if (state.equals(ServerState.DESTROYLISTENERS)) {
            logger.info("destoryContext");
            state = ServerState.DESTROYCONTEXT;
        } else {
            logger.error("Destroy context not possible, current state: {}", state);
        }
    }

    public void shutdown() {
        if (state.equals(ServerState.DESTROYCONTEXT)) {
            logger.info("shutdown");
            state = ServerState.INITED;
        } else {
            logger.error("Shutdown not possible, current state: {}", state);
        }
    }

    public ServerState getState() {
        return state;
    }

    public void setState(ServerState state) {
        this.state = state;
    }
}
