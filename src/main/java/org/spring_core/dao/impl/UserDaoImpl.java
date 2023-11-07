package org.spring_core.dao.impl;

import org.spring_core.dao.UserDao;
import org.spring_core.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user, Map<Long, User> map) {
        map.put(user.getId(), user);
    }
}
