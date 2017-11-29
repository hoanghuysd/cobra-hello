package org.cobra.persistence.repository;

import org.cobra.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Hoang Huy.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
