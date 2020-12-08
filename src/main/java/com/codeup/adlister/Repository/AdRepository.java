package com.codeup.adlister.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.models.Ad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByDescription(String desc); // mysql> select * from ads where description = ?;
    List<Ad> findAllByTitleIsLike(String term);
    Ad findByTitle(String title);
}
