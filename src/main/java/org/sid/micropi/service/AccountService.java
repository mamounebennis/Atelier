package org.sid.micropi.service;

import org.sid.micropi.entities.AppRole;
import org.sid.micropi.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser u);
    public AppRole saveRole(AppRole r);
    public AppUser findUserByUsername(String username);
    public void addRoleToUser(String username,String role);
}

