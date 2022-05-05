package org.devalurum.kafka.example.controller;

import lombok.RequiredArgsConstructor;
import org.devalurum.kafka.example.kafka.KafkaProducerService;
import org.devalurum.kafka.example.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService producerService;

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producerService.sendMessage(message);
    }

    @PostMapping(value = "/user")
    public void sendMessageToKafkaTopic(
            @RequestParam("userId") long userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        User user = User.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        this.producerService.saveCreateUserLog(user);
    }
}