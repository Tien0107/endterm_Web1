// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @Configuration
// public class SecurityConfig {
//     private final UserService userService;

//     public SecurityConfig(UserService userService) {
//         this.userService = userService;
//     }

//     @Bean
// 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// 		http
// 			.authorizeHttpRequests((requests) -> requests
//                 .requestMatchers("/", "/home", "/blog", "/contact", "/register", "/login").permitAll()
//                 .requestMatchers("/css/**", "/js/**", "/images/**", "/webfonts/**", "/sass/**").permitAll() // Cho phép truy cập static resources
//                 .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                 .requestMatchers("/admin/**").hasRole("ADMIN")

                
// 				.anyRequest().permitAll()
// 			)
// 			.formLogin((form) -> form
// 				.loginPage("/login")
//                 .defaultSuccessUrl("/")
// 				.permitAll()
// 			)
// 			.logout((logout) -> logout.permitAll());

// 		return http.build();
// 	}

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

	// @Bean
    // public UserDetailsService userDetailsService() {
    //     PasswordEncoder passwordEncoder = passwordEncoder(); // Lấy PasswordEncoder
    //     String encodedPassword = passwordEncoder.encode("password"); // Mã hóa mật khẩu

    //     UserDetails user = org.springframework.security.core.userdetails.User
    //         .withUsername("user")
    //         .password(encodedPassword) // Sử dụng mật khẩu đã mã hóa
    //         .roles("USER")
    //         .build();

    //     return new InMemoryUserDetailsManager(user);
    // }

   
// }
