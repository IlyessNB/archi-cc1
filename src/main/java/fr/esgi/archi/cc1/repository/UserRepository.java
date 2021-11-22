package fr.esgi.archi.cc1.repository;

import fr.esgi.archi.cc1.repository.exception.UserNotFoundException;

import java.util.List;

public interface UserRepository {

    UserId nextIdentity();

    void save(User user);

    void delete (UserId id);

    User ById(UserId id) throws UserNotFoundException;

    List<User> findAllUsers();
}
