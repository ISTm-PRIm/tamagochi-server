package com.tamogochi.server.route;

import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class SchedulerRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("quartz2://processing?cron=0+*/1+*+*+*+?")
                .routeId("startScheduler")
                .log("scheduler is start!")
                .bean("schedulerService", "createHistoriesForScheduler()")

        ;

    }
}
