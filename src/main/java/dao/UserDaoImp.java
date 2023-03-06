package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager e;

    @Override
    public List<User> getListUsers() {
        return e.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        e.persist(user);
    }

    @Override
    public void removeUser(User user) {
        e.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return e.find(User.class, id);
    }

    @Override
    public void changeUserName(String newName) {
        e.merge(newName);
    }

}
