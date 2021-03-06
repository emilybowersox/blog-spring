//package com.codeup.blog.services;
//
//import com.codeup.blog.daos.UserRolesRepository;
//import com.codeup.blog.models.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.util.StringUtils;
//
//import java.util.Collection;
//import java.util.List;
//
//public class UserRolesService extends User implements UserDetails {
//
//    private final List<String> userRoles;
//
//    public UserRolesService(User user, List<String> userRoles){
//        super(user);     // Call the copy constructor defined in User
//        this.userRoles = userRoles;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
////        String roles = ""; // Since we're not using the authorization part of the component
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
//
//
//
//
//
