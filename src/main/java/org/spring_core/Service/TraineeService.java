package org.spring_core.Service;

import org.spring_core.model.Trainee;

import java.util.Map;

public interface TraineeService {
    Trainee save(Trainee trainee, Map<Long,Trainee> map);
    Trainee find(long id,Map<Long,Trainee> map);
    Map<Long, Trainee> findAll(Map<Long,Trainee> map);
    Trainee update(Trainee trainee,Map<Long,Trainee> map);
    boolean delete(long id,Map<Long,Trainee> map);
}
