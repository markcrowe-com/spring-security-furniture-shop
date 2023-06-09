package io.gitlab.markcrowe.furniture.shop.app;

import io.gitlab.markcrowe.furniture.shop.app.model.SimpleRoles;
import io.gitlab.markcrowe.furniture.shop.app.model.SimpleUser;
import io.gitlab.markcrowe.furniture.shop.app.services.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/").permitAll()
                .requestMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
                .requestMatchers(HttpMethod.GET, "/products").permitAll()
                .requestMatchers(HttpMethod.GET, "/products/add").hasRole(SimpleRoles.SUPER_ADMIN)
                .requestMatchers(HttpMethod.POST, "/products/add").hasRole(SimpleRoles.SUPER_ADMIN)
                .requestMatchers(HttpMethod.GET, "/products/*/delete").hasAnyRole(SimpleRoles.ADMIN, SimpleRoles.SUPER_ADMIN)
                .and()
				.formLogin()
				.defaultSuccessUrl("/products");//	The page to go when you log in

        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder)
    {
        var userDetailsList = new ArrayList<UserDetails>();
        for (SimpleUser simpleUser : simpleUserService.getSimpleUsers() ) {
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
