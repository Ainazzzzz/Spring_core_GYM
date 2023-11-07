package org.spring_core.Service;

import org.spring_core.model.Trainer;

import java.util.Map;

public interface TrainerService {

    void save(Trainer trainer, Map<Long, Trainer> map);
    Trainer find(long id, Map<Long, Trainer> map);
    Trainer update(Trainer trainer, Map<Long, Trainer> map);
}
