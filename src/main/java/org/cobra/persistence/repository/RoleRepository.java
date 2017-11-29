package org.cobra.persistence.repository;

import org.cobra.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Hoang Huy
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
