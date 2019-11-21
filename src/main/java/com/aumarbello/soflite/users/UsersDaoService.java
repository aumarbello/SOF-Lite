package com.aumarbello.soflite.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UsersDaoService {
    private static final List<User> users = new ArrayList<>();
    private Long usersCount = 4L;

    static {
        users.add(new User(1L, "John Essien", "john@example.com", new Date(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(2L, "Abdulah Gbenge", "abdul@example.com", new Date(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(3L, "Yemi Chidi", "yemi@example.com", new Date(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(4L, "John Travolta", "boring@actors.com", new Date(), new ArrayList<>(), new ArrayList<>()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Long id) {
        for (User user: users) {
            if (user.getId().equals(id)){
                return user;
            }
        }

        return null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
            user.setCreatedAt(new Date());
        }

        users.add(user);

        return user;
    }

}
