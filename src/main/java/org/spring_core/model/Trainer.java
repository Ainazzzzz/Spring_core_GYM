package org.spring_core.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data

public class Trainer {
    private long id;
    private TrainingType specialization;
    private User user;
}
