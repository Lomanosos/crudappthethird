package hiber.logic.dao;

import hiber.logic.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUsers();//read
    void addUser(User user); //create
    void removeUser(User user);//delete
    User getUserById(long id);//read
    void changeUser(User user);//update
}
