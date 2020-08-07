package com.codeup.blog.services;

//import com.codeup.blog.daos.UserRolesRepository;
//import com.codeup.blog.daos.UserRolesRepository;
import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.User;
//import com.codeup.blog.models.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
//    private final UserRolesRepository roles;

//    @Autowired
//    public MyUserDetailsService(UsersRepository users/*, UserRolesRepository roles*/) {
//        this.users = users;
////        this.roles = roles;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }


//        List<String> userRoles = roles.ofUserWith(username);
//        return new UserRolesService(user, userRoles);
//
      return new MyUserPrincipal(user);
    }


}
