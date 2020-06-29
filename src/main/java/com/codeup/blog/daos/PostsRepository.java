package com.codeup.blog.daos;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {

    @Query ("from Post as a where p.title like %:term% or p.body like %:term%")
    List<Post> searchByTitle(@Param("term") String term);

//    // query methods
//    Post findFirstByTitle(String title); // select * from posts where title = ? limit 1


//    Post save();
//
//    Post delete();
}


