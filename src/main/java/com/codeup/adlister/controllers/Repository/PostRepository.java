package com.codeup.adlister.controllers.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.controllers.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
