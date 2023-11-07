package org.spring_core.dao.impl;

import org.spring_core.dao.TrainerDao;
import org.spring_core.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class TrainerDaoImpl implements TrainerDao {
    @Override
    public void save(Trainer trainer, Map<Long, Trainer> map) {
        map.put(trainer.getId(),trainer);
    }

    @Override
    public Trainer find(long id, Map<Long, Trainer> map) {
        return map.get(id);
    }

    @Override
    public Trainer update(Trainer trainer, Map<Long, Trainer> map) {
       Trainer trainer1 = map.get(trainer.getId());
         trainer1.setUser(trainer.getUser());
         trainer1.setSpecialization(trainer.getSpecialization());
            map.replace(trainer.getId(),trainer1);
            return trainer1;

    }
}
