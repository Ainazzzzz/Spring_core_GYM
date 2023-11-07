package org.spring_core;

import lombok.Data;
import org.spring_core.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Data
public class Storage {

    private Map<Long, Trainee> traineeMap = new HashMap<>();
    private Map<Long,Trainer> trainerMap = new HashMap<>();
    private Map<Long,Training> trainingMap = new HashMap<>();
    private Map<Long, User> userMap = new HashMap<>();
    private Map<Long, TrainingType> trainingTypeMap = new HashMap<>();

    @Override
    public String toString() {
        return "Storage{" +
                "userMap=" + userMap +
                '}';
    }
}
