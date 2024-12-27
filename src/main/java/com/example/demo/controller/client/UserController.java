package com.example.demo.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(){

    }

    @GetMapping("/")
    @ResponseBody
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        for(User user : userService.findAll()){
            if(user.getId() == userId){
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

   // create new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        // newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        // newUser.setRole("ROLE_USER");                        
        userService.saveUser(newUser);
        return ResponseEntity.status(201).body(newUser);
    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User updateuser){
        User user = userService.findById(userId);
        if (user != null ){
            user.setUsername(updateuser.getUsername());
            user.setPassword(updateuser.getPassword());
            user.setRole(updateuser.getRole());
            userService.saveUser(user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);
    }

    //patch
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> patchUser(@PathVariable("id") Long userId, @RequestBody User patchupdate){
        User user = userService.findById(userId);
        if (user != null ){
            if(patchupdate.getUsername() != null){
                user.setUsername(patchupdate.getUsername());
            }
            if(patchupdate.getPassword() != null){
                user.setPassword(patchupdate.getPassword());
            }
            if(patchupdate.getRole() != null){
                user.setRole(patchupdate.getRole());
            }
            userService.saveUser(user);
            return ResponseEntity.status(200).body(user);
    }
    return ResponseEntity.status(404).body(null);

    }
     //delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public List<User> removeUserById(@PathVariable("id") Long userId){
        userService.delete(userId);
        return userService.findAll();
    }
    
}
    

