package com.gevbagratunyan.school.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;

    public SecurityConfiguration(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
       auth.authenticationProvider(daoAuthenticationProvider());
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
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
