// package com.example.endterm.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PatchMapping;

// // import com.example.endterm.repository.UserRepository;
// import com.example.endterm.service.UserService;
// import com.example.endterm.model.User;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import com.example.endterm.service.UserService;


// @Controller
// public class ApiController {
//     @Autowired
//     private UserService userService;

//     public ApiController(){
        
//     }

//     //post login
//     @PostMapping("/users/login")
//     @ResponseBody
//     public String login(@RequestBody User user) {
//         return userService.login(user);
//     }
// }
