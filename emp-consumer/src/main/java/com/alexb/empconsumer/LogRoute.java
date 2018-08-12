package com.alexb.empconsumer;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LogRoute extends RouteBuilder {
    @Override
    public void configure() {
//        from("timer:logTimer?period=3000")
//                .process(ex -> ex.getIn().setBody("lol"))
//                .to("log:com.alexb.empconsumer.LogRoute?level=ERROR");

        from("rabbitmq:WTF?queue=StringQueue")
                .log(LoggingLevel.ERROR, "TAKEN")
//                .to("log:com.alexb.empconsumer.LogRoute?level=ERROR");
                .to("rabbitmq:Out?routingKey=C&bridgeEndpoint=true");
    }

}
