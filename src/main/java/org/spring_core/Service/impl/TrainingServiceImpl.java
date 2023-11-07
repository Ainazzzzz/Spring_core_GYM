package org.spring_core.Service.impl;

import org.spring_core.Service.TrainingService;
import org.spring_core.dao.TrainingDao;
import org.spring_core.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingDao trainingDao;
    @Override
    public void save(Training training, Map<Long, Training> map) {
        trainingDao.save(training,map);

    }

    @Override
    public Training find(long id, Map<Long, Training> map) {
        return trainingDao.find(id,map);
    }
}
