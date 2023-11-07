package org.spring_core.Service;

import org.spring_core.model.User;

import java.util.Map;

public interface UserService {
    void save(User user, Map<Long,User> map);
}
