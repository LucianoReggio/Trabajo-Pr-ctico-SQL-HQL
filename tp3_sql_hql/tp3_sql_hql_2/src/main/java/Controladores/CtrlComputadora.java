package Controladores;

import Modelo.Computadora;
import Persistencia.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CtrlComputadora {

    public boolean insertarComputadora(Computadora computadora) {
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(computadora);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
