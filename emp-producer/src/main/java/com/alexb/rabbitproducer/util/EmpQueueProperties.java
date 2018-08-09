package com.alexb.rabbitproducer.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alexb.queue")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmpQueueProperties {

    private String name;

    private String exchange;

    private String key;

}
