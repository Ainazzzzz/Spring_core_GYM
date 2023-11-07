package org.spring_core.dao;

import org.spring_core.model.TrainingType;

import java.util.Map;

public interface TrainingTypeDao {
    void save(TrainingType trainingType, Map<Long,TrainingType> map);
}
