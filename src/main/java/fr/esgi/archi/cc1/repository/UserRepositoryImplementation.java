package fr.esgi.archi.cc1.repository;

import fr.esgi.archi.cc1.repository.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UserRepositoryImplementation implements UserRepository{

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<UserId, User> users = new ConcurrentHashMap<>();

    @Override
    public UserId nextIdentity() {
        return UserId.of(count.incrementAndGet());
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(UserId id) {
        users.remove(id);
    }

    @Override
    public User ById(int id) throws UserNotFoundException {
        final User user = users.get(id);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }
}