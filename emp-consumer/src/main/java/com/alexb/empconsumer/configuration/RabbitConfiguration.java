package com.alexb.empconsumer.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfiguration {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(ConnectionFactory factory,
                                                            @Value("${alexb.queue.name}") String queueName) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setQueueNames(queueName);
        container.setMessageConverter(messageConverter());

        return container;
    }

    @Bean
    public RabbitListenerErrorHandler rabbitListenerErrorHandler() {
        return (Message amqpMessage, org.springframework.messaging.Message<?> message,
                ListenerExecutionFailedException exception) -> {
            Logger logger = LoggerFactory.getLogger(RabbitListenerErrorHandler.class);
            logger.warn(exception.getMessage());
            return null;
        };
    }
}
