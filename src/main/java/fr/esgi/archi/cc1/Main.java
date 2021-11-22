package fr.esgi.archi.cc1;

import fr.esgi.archi.cc1.repository.User;
import fr.esgi.archi.cc1.repository.UserId;
import fr.esgi.archi.cc1.repository.UserRepository;
import fr.esgi.archi.cc1.repository.UserRepositoryImplementation;
import fr.esgi.archi.cc1.service.UserService;

public class Main {

    public static void main(String[] args) {

        User user1 = User.of( UserId.of(1), "NAITBELKACEM", "ILYESS", "ilyessnait@gmail.com", "123456789");
        User user2 = User.of( UserId.of(2), "BOISSINOT", "GREGORY", "gregoryboisinot@gmail.com", "CHANGEME");

        UserRepository userRepository = new UserRepositoryImplementation();

        UserService userService = new UserService(userRepository);

        //Save users
        userRepository.save(user1);
        userRepository.save(user2);

        //delete users
        userRepository.delete(user2.getId());

        userService.createUser(user1);
        //modify password
        userService.changePassword(user1.getId(),"azerty");

    }
}
