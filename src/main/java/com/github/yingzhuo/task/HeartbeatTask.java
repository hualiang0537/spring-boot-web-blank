package com.github.yingzhuo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class HeartbeatTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatTask.class);

    private boolean enabled = true;

    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        if (!enabled) {
            return;
        } else {
            LOGGER.debug("heartbeat ...");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
