package org.spring_core.Service.impl;

import org.spring_core.Service.TraineeService;
import org.spring_core.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.spring_core.dao.TraineeDao;

import java.util.Map;
@Component
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeDao traineeDao;
    @Override
    public Trainee save(Trainee trainee, Map<Long, Trainee> map) {
      return traineeDao.save(trainee,map);
    }

    @Override
    public Trainee find(long id, Map<Long, Trainee> map) {
        return traineeDao.find(id,map);
    }

    @Override
    public Map<Long, Trainee> findAll(Map<Long, Trainee> map) {
        return null;
    }

    @Override
    public Trainee update(Trainee trainee, Map<Long, Trainee> map) {
        return null;
    }

    @Override
    public boolean delete(long id, Map<Long, Trainee> map) {
        return false;
    }
}
