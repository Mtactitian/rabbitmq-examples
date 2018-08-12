package com.alexb.empconsumer;

import org.apache.camel.Exchange;
import org.apache.camel.spi.ExchangeFormatter;
import org.springframework.stereotype.Component;

@Component(value = "logFormatter")
public class Formatter implements ExchangeFormatter {
    @Override
    public String format(Exchange exchange) {
        return exchange.getIn().getBody(String.class);
    }
}
