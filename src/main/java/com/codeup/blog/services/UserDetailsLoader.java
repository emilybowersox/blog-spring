package com.codeup.blog.services;

import com.codeup.blog.daos.UserRoles;
import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final UsersRepository users;
    private final UserRoles roles;

    @Autowired
    public UserDetailsLoader(UsersRepository users, UserRoles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }


}
