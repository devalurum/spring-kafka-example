package org.devalurum.kafka.example.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devalurum.kafka.example.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, User> userKafkaTemplate;

    @Value(value = "${kafka.general.topic.name}")
    private String topicName;

    @Value(value = "${kafka.user.topic.name}")
    private String userTopicName;

    public void sendMessage(String message) {
        var future
                = this.kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message: '{}' with offset: {}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message :{}", message, ex);
            }
        });
    }

    public void saveCreateUserLog(User user) {
        var future
                = this.userKafkaTemplate.send(userTopicName, user);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, User> result) {
                log.info("User created: '{}' with offset: {}", user, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("User created :{}", user, ex);
            }
        });
    }
}
