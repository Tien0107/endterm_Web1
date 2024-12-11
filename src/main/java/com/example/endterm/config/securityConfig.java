package com.example.endterm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				// Cho phép truy cập không cần đăng nhập
                .requestMatchers("/", "/home", "/blog", "/contact", "/register", "/login").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webfonts/**", "/sass/**").permitAll() // Cho phép truy cập static resources
                // Các đường dẫn yêu cầu xác thực
                .requestMatchers("/add_blog", "/profile").authenticated()
                .anyRequest().authenticated()

			)
			.formLogin((form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.permitAll()
			)
			
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

// 	@Bean
// 	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//     	UserDetails user = User.withUsername("user")
//             .password(passwordEncoder.encode("password"))
//             .roles("USER")
//             .build();

//     	return new InMemoryUserDetailsManager DetailsManager(user);
//		 }

}
    

