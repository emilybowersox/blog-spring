package com.codeup.blog.services;

import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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



}
