package org.spring_core.dao;

import org.spring_core.model.Trainer;

import java.util.Map;

public interface TrainerDao {
      void save(Trainer trainer, Map<Long, Trainer> map);
        Trainer find(long id, Map<Long, Trainer> map);
        Trainer update(Trainer trainer, Map<Long, Trainer> map);

}
