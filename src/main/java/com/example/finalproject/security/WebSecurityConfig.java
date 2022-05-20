//package com.example.finalproject.security;
//
//import com.example.finalproject.models.Employee;
//import com.example.finalproject.repository.EmployeeRepository;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//
//import java.time.LocalDateTime;
//
//@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .mvcMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//    }
//
//    @Bean
//    public PrincipalExtractor principalExtractor(EmployeeRepository userDetailsRepo) {
//        return map -> {
//            String id = (String) map.get("sub");
//
//            Employee user = userDetailsRepo.findById(Long.valueOf(id)).orElseGet(() -> {
//                Employee newUser = new Employee();
//
//                newUser.setId(Long.valueOf(id));
//                newUser.setName((String) map.get("name"));
//
//                return newUser;
//            });
//
//            return userDetailsRepo.save(user);
//        };
//    }
//}