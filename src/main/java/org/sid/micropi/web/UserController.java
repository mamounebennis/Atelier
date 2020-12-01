package org.sid.micropi.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.sid.micropi.entities.AppUser;
import org.sid.micropi.service.AccountService;
import org.sid.micropi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    ServletContext context;

    @PostMapping("/register")
    public AppUser signUp(@RequestBody RegistrationForm data) {
       String username=data.getUsername();
        AppUser user=accountService.findUserByUsername(username);
        if(user!=null) throw new RuntimeException("This user already exists, Try with an other username");
       String password=data.getPassword(); String repassword=data.getRepassword();String name = data.getName();String categorie = data.getCategorie();
       if(!password.equals(repassword))
            throw new RuntimeException("You must confirm your password");
        AppUser u=new AppUser(); u.setUsername(username); u.setPassword(password);u.setName(name);u.setCategorie(categorie);
        accountService.saveUser(u);
        return (u);
   }


    @Autowired
    private UserService userService;

    @CrossOrigin()
    @GetMapping("/user/{id}")
    public AppUser find(@PathVariable Long id) {
        return userService.find(id);
    }



    @CrossOrigin()
    @PutMapping("/user/{id}")
    public AppUser update(@PathVariable(name = "id") Long id , @RequestBody AppUser user)   {
        return userService.update(id, user);
    }

    @CrossOrigin()
    @GetMapping("/users")
    public List<AppUser> GetUser(){
        return userService.GetUser();}

    @CrossOrigin()
    @PostMapping("/users")
    public AppUser save(@RequestBody AppUser user){ return userService.save(user);}

    @CrossOrigin()
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        userService.DeleteUser(id);
    }

    @CrossOrigin()
    @GetMapping("/users/{username}")
    public AppUser find(@PathVariable String username) {
        return userService.find(username);
    }





}
