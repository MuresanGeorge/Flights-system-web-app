package service;

import model.User;

public interface UserService {

    User getUserByUsernameAndPassword(String username, String password);
}
