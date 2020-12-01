package com.codeup.adlister.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.models.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
