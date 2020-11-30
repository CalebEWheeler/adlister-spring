package com.codeup.adlister.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
