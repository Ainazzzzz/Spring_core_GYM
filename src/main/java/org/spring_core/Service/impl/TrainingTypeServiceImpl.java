package org.spring_core.Service.impl;

import org.spring_core.Service.TrainingTypeService;
import org.spring_core.dao.TrainingTypeDao;
import org.spring_core.model.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TrainingTypeServiceImpl implements TrainingTypeService {
    @Autowired
    private TrainingTypeDao trainingTypeDao;
    @Override
    public void save(TrainingType trainingType, Map<Long, TrainingType> map) {
        trainingTypeDao.save(trainingType,map);
    }
}
