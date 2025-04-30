package service.impl;


import entity.User;
import enums.UserType;
import respository.UserRepository;
import service.UserService;

/**
 * The type User service.
 */
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = UserRepository.getInstance();

    public void registerUser(String name, UserType userType) {
        if (userRepository.getUser(name) != null) {
            throw new IllegalArgumentException("User already exists with name: " + name);
        }
        User user = new User(name, userType);
        userRepository.addUser(user);
    }

    public User getUser(String name) {
        return userRepository.getUser(name);
    }
}
