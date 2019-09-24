package dao;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {

    public FlightDaoImpl() {
        super();
    }

    public void addFlight(Flight flight) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(flight);
            //aaaa
            trns.commit();
            //aaaa\
            //sau trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateFlight(Flight flight) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(flight);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void deleteFlight(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Flight flight = this.getFlightById(id);
            session.delete(flight);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            flights = session.createQuery("from Flight").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flights;
    }

    public Flight getFlightById(int id) {
        Flight flight = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Flight where id = :id";
            Query query = session.createQuery(queryString);
            query.setParameter("id", id);
            flight = (Flight) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flight;
    }
}
