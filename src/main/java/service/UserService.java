package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getListUsers();//read
    void addUser(User user); //create
    void removeUser(User user);//delete
    User getUserById(long id);//read
    void changeUserName(String newName);//update
}
