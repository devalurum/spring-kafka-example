package org.devalurum.kafka.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.devalurum.kafka.example.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${kafka.general.topic.name}",
            groupId = "${kafka.general.topic.group.id}")
    public void consume(String message) {
        log.info("Message recieved -> {}", message);
    }

    @KafkaListener(topics = "${kafka.user.topic.name}",
            groupId = "${kafka.user.topic.group.id}",
            containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        log.info("User created -> {}", user);
    }
}
