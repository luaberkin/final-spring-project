//package com.example.finalproject.hibernate;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.cfg.Configuration;
//
//import java.io.Serializable;
//import java.util.List;
//
//public abstract class AbstractHibernateDAO < T extends Serializable>{
//
//    private Class< T > clazz;
//
//    private SessionFactory sessionFactory = buildSessionFactory();
//
//    public void setClazz(Class< T > clazzToSet) {
//        clazz = clazzToSet;
//    }
//
//    public T findOne(Long id) {
//        return (T) getCurrentSession().get( clazz, id );
//    }
//
//    public List< T > findAll() {
//        return getCurrentSession()
//                .createQuery( "from " + clazz.getName() ).list();
//    }
//
//    public T save(T entity) {
//        getCurrentSession().persist( entity );
//        return entity;
//    }
//
//    public T update(T entity) {
//        return (T) getCurrentSession().merge( entity );
//    }
//
//    public void delete(T entity) {
//        getCurrentSession().delete( entity );
//    }
//
//    public void deleteById(Long id) {
//        final T entity = findOne( id);
//        delete( entity );
//    }
//
//
//    protected final Session getCurrentSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//    private synchronized SessionFactory buildSessionFactory() {
//        return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(clazz).buildSessionFactory();
//    }
//}
