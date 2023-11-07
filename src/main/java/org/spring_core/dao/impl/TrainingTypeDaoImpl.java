package org.spring_core.dao.impl;

import org.spring_core.model.TrainingType;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class TrainingTypeDaoImpl implements org.spring_core.dao.TrainingTypeDao{
    @Override
    public void save(TrainingType trainingType, Map<Long, TrainingType> map) {
        map.put(trainingType.getId(),trainingType);
    }
}
