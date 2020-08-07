package com.codeup.blog.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRolesRepository extends JpaRepository<String, Long> {
//    @Query("select r.role from Role r, User u where u.username=?1 and r.id = u.role.id")
//    public List<String> ofUserWith(String username);

//    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
//    List<String> ofUserWith(String username);

    @Query("from UserRoles as ur where ur.role like %:term%")
    List<String> ofUserWith(@Param("term") String term);
}