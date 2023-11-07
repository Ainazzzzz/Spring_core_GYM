package org.spring_core.Service;

import org.spring_core.model.Training;

import java.util.Map;

public interface TrainingService {
    void save (Training training, Map<Long, Training> map);
    Training find(long id, Map<Long, Training> map);
}
