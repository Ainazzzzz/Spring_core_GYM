package org.spring_core.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
@Data

public class Training {
    private long id;
    private Trainee trainee;
    private Trainer trainer;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private Duration trainingDuration;
}
