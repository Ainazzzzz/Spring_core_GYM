package org.spring_core.Service;

import org.spring_core.model.TrainingType;

import java.util.Map;

public interface TrainingTypeService {
    void save(TrainingType trainingType, Map<Long,TrainingType> map);
}
