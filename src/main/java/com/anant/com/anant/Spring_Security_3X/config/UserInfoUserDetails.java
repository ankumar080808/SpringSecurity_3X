package com.anant.com.anant.Spring_Security_3X.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.anant.com.anant.Spring_Security_3X.entity.UserInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {


    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(UserInfo userInfo) {
        name=userInfo.getName();
        password=userInfo.getPassword();
        authorities= Arrays.stream(userInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}



/*
 * When i implemented spring security in my project by default its taking
 * username as name from below fields: private int id; private String name;
 * private String email; private String password; private String roles;
 * 
 * What is reason behind this ? why its not taking email as username ? What i
 * have to do to set email as username?
 */


/*
 * In Spring Security, the default behavior is to use a field named "username"
 * as the principal for authentication. The field used as the username is
 * determined by the UserDetails interface, which includes a method
 * getUsername().
 */

/*
 * public class CustomUserDetails implements UserDetails {
 * 
 * private String email; // Use email as the username private String password;
 * private Collection<? extends GrantedAuthority> authorities;
 * 
 * // Constructors, getters, and other methods...
 * 
 * @Override public String getUsername() { return email; // Return email as the
 * username } }
 */

/*
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { // Load user details from the repository using
 * the email as the username User user = userRepository.findByEmail(email)
 * .orElseThrow(() -> new
 * UsernameNotFoundException("User not found with email: " + email));
 * 
 */