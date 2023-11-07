package org.spring_core.dao.impl;

import org.spring_core.model.Trainee;
import org.springframework.stereotype.Component;
import org.spring_core.dao.TraineeDao;

import java.util.Map;


@Component
public class TraineeDaoImpl implements TraineeDao {

    @Override
    public Trainee save(Trainee trainee, Map<Long, Trainee> map) {
        map.put(trainee.getId(), trainee);
        return trainee;
    }

    @Override
    public Trainee find(long id, Map<Long, Trainee> map) {
        return map.get(id);
    }

    @Override
    public Map<Long, Trainee> findAll(Map<Long, Trainee> map) {
        return map;
    }

    @Override
    public Trainee update(Trainee trainee, Map<Long, Trainee> map) {
      Trainee trainee1 = map.get(trainee.getId());
      trainee1.setDate(trainee.getDate());
      trainee1.setAddress(trainee.getAddress());
      trainee1.setUser(trainee.getUser());
      map.replace(trainee.getId(),trainee1);
      return trainee1;
    }

    @Override
    public boolean delete(long id, Map<Long, Trainee> map) {
        if(map.containsKey(id)){
            map.remove(id);
            return true;
        }
        return false;
    }
}
