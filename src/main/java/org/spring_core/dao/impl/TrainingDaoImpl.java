package org.spring_core.dao.impl;

import org.spring_core.dao.TrainingDao;
import org.spring_core.model.Training;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class TrainingDaoImpl implements TrainingDao {
    @Override
    public void save(Training training, Map<Long, Training> map) {
        map.put(training.getId(),training);
    }

    @Override
    public Training find(long id, Map<Long, Training> map) {
        return map.get(id);
    }
}
