package service.impl;

import dao.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    public User getUserByUsernameAndPassword(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password);
    }
}
