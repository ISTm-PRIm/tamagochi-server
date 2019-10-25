package com.tamogochi.server.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("quartz2://processing?cron=0+*/1+*+*+*+?")
                .routeId("startScheduler")
                .log("scheduler is start!")
                .bean("schedulerService", "createHistoriesForScheduler()")
                .bean("petService", "changeIndicator(${body})");
    }
}
