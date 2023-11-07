package org.spring_core.Service.impl;

import org.spring_core.Service.UserService;
import org.spring_core.dao.UserDao;
import org.spring_core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user, Map<Long, User> map) {
        userDao.save(user,map);

    }
}
