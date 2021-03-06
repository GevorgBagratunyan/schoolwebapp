package com.gevbagratunyan.school.service.security;

import com.gevbagratunyan.school.entity.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Adding authorities
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user.getPermissionsList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });
        //Adding the Role
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.user.getRole().toString()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //???
    @Override
    public boolean isEnabled() {
        user.setLoggedIn(true);
        return user.isLoggedIn();
    }
}
