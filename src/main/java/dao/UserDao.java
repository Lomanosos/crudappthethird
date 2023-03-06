package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUsers();//read
    void addUser(User user); //create
    void removeUser(User user);//delete
    User getUserById(long id);//read
    void changeUserName(String newName);//update
}
