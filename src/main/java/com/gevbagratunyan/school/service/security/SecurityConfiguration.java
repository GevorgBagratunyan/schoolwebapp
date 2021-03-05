package com.gevbagratunyan.school.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth
               .inMemoryAuthentication()
               .withUser("admin").password(passwordEncoder().encode("Gev250125"))
               .roles("ADMIN").authorities("ACCESS_AUTHORITY1", "ACCESS_AUTHORITY2")
               .and()
               .withUser("user").password(passwordEncoder().encode("12345678"))
               .roles("USER").authorities("ACCESS_AUTHORITY1")
               .and()
               .withUser("guest").password(passwordEncoder().encode("12345678"))
               .roles("GUEST");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/home/profile").authenticated()
                .antMatchers("/admins/**").hasRole("ADMIN")
                .antMatchers("/users/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/home/authority1").hasAnyAuthority("ACCESS_AUTHORITY1")
                .antMatchers("/home/authority2").hasAnyAuthority("ACCESS_AUTHORITY2")
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
