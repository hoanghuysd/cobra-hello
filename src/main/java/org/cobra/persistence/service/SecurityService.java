package org.cobra.persistence.service;

/**
 * Created by Hoang Huy on 9/22/2017.
 */
public interface SecurityService {
    public String findLoggedInUsername();
    public void autologin(String username, String password);
}
