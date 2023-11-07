package org.spring_core.dao;

import org.spring_core.model.Training;

import java.util.Map;

public interface TrainingDao {

    void save (Training training, Map<Long, Training> map);
    Training find(long id, Map<Long, Training> map);

}
