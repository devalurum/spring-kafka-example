package org.devalurum.kafka.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long userId;
    private String firstName;
    private String lastName;
}
