package org.sid.micropi.dao;

import org.sid.micropi.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRole(String role);
}
