package dao;

import model.User;

public interface UserDao {

    User getUserByUsernameAndPassword(String username, String password);
}
