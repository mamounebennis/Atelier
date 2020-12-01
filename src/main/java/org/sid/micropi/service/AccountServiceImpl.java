package org.sid.micropi.service;

import org.sid.micropi.dao.AppRoleRepository;
import org.sid.micropi.dao.AppUserRepository;
import org.sid.micropi.entities.AppRole;
import org.sid.micropi.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private AppRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(AppUser u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }
    @Override
    public AppRole saveRole(AppRole r) {
        return roleRepository.save(r);
    }
    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=userRepository.findByUsername(username);
        AppRole role=roleRepository.findByRole(roleName);
        user.getRoles().add(role);
    }
}
