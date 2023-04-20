package io.gitlab.markcrowe.furniture.shop.app;

import io.gitlab.markcrowe.furniture.shop.app.model.SimpleUser;
import io.gitlab.markcrowe.furniture.shop.app.services.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder)
    {
        var userDetailsList = new ArrayList<UserDetails>();
        for (SimpleUser simpleUser : simpleUserService.getAllSimpleUsers() ) {
            UserDetails userDetails = User.withUsername(simpleUser.getUsername())
                    .password(passwordEncoder.encode(simpleUser.getPassword()))
                    .roles(simpleUser.getRoles())
                    .build();
            userDetailsList.add(userDetails);
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SimpleUserService simpleUserService;
}
