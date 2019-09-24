package dao;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class CityDaoImpl implements CityDao {

    public City getCityByName(String cityName) {
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from City where name = :cityName";
            Query query = session.createQuery(queryString);
            query.setParameter("cityName", cityName);
            city = (City) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return city;

    }
}
