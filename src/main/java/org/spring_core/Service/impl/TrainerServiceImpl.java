package org.spring_core.Service.impl;

import org.spring_core.Service.TrainerService;
import org.spring_core.dao.TrainerDao;
import org.spring_core.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao trainerDao;
    @Override
    public void save(Trainer trainer, Map<Long, Trainer> map) {
        trainerDao.save(trainer,map);
    }

    @Override
    public Trainer find(long id, Map<Long, Trainer> map) {
       return trainerDao.find(id,map);
    }

    @Override
    public Trainer update(Trainer trainer, Map<Long, Trainer> map) {
        return trainerDao.update(trainer,map);
    }
}
