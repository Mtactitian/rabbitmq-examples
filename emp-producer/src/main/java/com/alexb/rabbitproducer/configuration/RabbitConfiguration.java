package com.alexb.rabbitproducer.configuration;

import com.alexb.rabbitproducer.util.EmpQueueProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final EmpQueueProperties empQueueProperties;

    @Bean(name = "empTemplate")
    public RabbitTemplate empRabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setExchange(empQueueProperties.getExchange());
        rabbitTemplate.setRoutingKey(empQueueProperties.getKey());
        return rabbitTemplate;
    }

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(factory);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}