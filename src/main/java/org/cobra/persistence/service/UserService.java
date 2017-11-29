package org.cobra.persistence.service;


import org.cobra.persistence.model.User;

/**
 * Created by Hoang Huy.
 */
public interface UserService {
    public void insertUser(User user);
    public User getByUsername(String username);
}
