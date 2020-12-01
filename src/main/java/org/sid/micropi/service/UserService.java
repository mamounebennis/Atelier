package org.sid.micropi.service;

import org.sid.micropi.dao.AppUserRepository;
import org.sid.micropi.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    AppUserRepository appUserRepository;

    public AppUser find(String username) {
        return appUserRepository.findByUsername(username);
    }


    public AppUser find(Long id) {
        return appUserRepository.findById(id).orElse(null);}


    public List<AppUser> GetUser() {
        return appUserRepository.findAll();
    }

    public AppUser update(Long id, AppUser user) {
        user.setId(id);
        return appUserRepository.save(user);
    }

    public void DeleteUser(Long id){
        appUserRepository.deleteById(id);
    }

    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }



}
