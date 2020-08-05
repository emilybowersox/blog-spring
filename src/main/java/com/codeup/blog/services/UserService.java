package com.codeup.blog.services;

import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("usersService")
public class UserService {

    UsersRepository usersDao;

    public UserService(UsersRepository usersDao){
        this.usersDao = usersDao;
    }

    public boolean isLoggedIn() {
        boolean isAnonymousUser = SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return ! isAnonymousUser;
    }

    //returns a user object from the database
    public User loggedInUser() {
        if (! isLoggedIn()) {
            return null;
        }
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersDao.getOne(sessionUser.getId());
    }

    //user is owner of the post
    public boolean isPostOwner(User postUser){
        if(isLoggedIn()){
            return (postUser.getUsername().equals(loggedInUser().getUsername()));
        }
        return false;
    }

    //user has edit access
    public boolean canEditProfile(User profileUser){
        return isLoggedIn() && (profileUser.getId() == loggedInUser().getId());
    }

    public void authenticate(User user){
        //use an empty list for the roles
        UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
    }

}
