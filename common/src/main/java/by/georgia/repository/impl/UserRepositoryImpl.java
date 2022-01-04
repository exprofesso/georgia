package by.georgia.repository.impl;

import by.georgia.domain.User;
import by.georgia.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@Log4j2
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;


    public UserRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User findById(Long key) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, key);
        }
    }
}

