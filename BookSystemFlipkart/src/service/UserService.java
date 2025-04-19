package service;

import entity.User;
import enums.UserType;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Register user.
     *
     * @param name     the name
     * @param userType the user type
     */
    void registerUser(String name, UserType userType);

    /**
     * Gets user.
     *
     * @param name the name
     * @return the user
     */
    User getUser(String name);
}
