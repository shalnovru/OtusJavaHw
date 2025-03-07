package ru.otus.dao;

import ru.otus.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserDao implements UserDao {

    public static final String DEFAULT_PASSWORD = "11111";
    private final Map<Long, User> users;

    public InMemoryUserDao() {
        users = new HashMap<>();
        users.put(1L, new User(1L, "Крис Гир", "user1", DEFAULT_PASSWORD));
        users.put(2L, new User(2L, "Ая Кэш", "user2", DEFAULT_PASSWORD));
        users.put(3L, new User(3L, "Десмин Боргес", "user3", DEFAULT_PASSWORD));
        users.put(4L, new User(4L, "Кетер Донохью", "user4", DEFAULT_PASSWORD));
        users.put(5L, new User(5L, "Стивен Шнайдер", "user5", DEFAULT_PASSWORD));
        users.put(6L, new User(6L, "Джанет Вэрни", "user6", DEFAULT_PASSWORD));
        users.put(7L, new User(7L, "Брэндон Смит", "user7", DEFAULT_PASSWORD));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return users.values().stream().filter(v -> v.login().equals(login)).findFirst();
    }
}
