package org.devalurum.kafka.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaAppApplication.class, args);
    }

}
