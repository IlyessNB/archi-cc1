package fr.esgi.archi.cc1.service;

import fr.esgi.archi.cc1.repository.User;
import fr.esgi.archi.cc1.repository.UserId;
import fr.esgi.archi.cc1.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user.getId());
    }

    public void changePassword(UserId userId, String newPassword) {
        final User user = userRepository.ById(userId);
        user.changePassword(newPassword);
        userRepository.save(user);
    }
}
