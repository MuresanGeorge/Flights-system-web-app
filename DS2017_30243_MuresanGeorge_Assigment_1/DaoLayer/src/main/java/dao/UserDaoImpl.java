package dao;

import model.Flight;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public User getUserByUsernameAndPassword(String username, String password){
        User user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            List<User> users = session.createQuery("select u from User u where u.username=:username", User.class)
                    .setParameter("username",username)
                    .list();
            if(users.size() > 0 && users.get(0).getPassword().equals(password)){
                user = users.get(0);
            }
            trns.commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
        } finally {
            session.close();
        }
        return user;
    }
}
