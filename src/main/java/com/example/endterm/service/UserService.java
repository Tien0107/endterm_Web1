package com.example.endterm.service;
import com.example.endterm.model.User;
import com.example.endterm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//security
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;


import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Khong tim thay nguoi dung voi email: " + email));

        // UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getEmail());
        // builder.password(user.getPassword());
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found !"));
    }

    public User save(User user){
        //add security code
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User update(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    //register
    // public void register(Model model){
    //     model.addAttribute("user", new User());
        
    // }

}
