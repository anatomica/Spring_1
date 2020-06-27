package Homework1.demo;

import java.util.List;

public interface UserRepository {
    List<User> findAllUsers();
    void addUser(User user);
}
