package src.interfaces;

import src.model.User;

public interface UserAccess {
    void registerUser(User user);
    User loginUser(String username, String password);
}
