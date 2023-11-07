package org.spring_core.dao;

import org.spring_core.model.User;

import java.util.Map;

public interface UserDao {

    void save(User user, Map<Long,User> map);
}
