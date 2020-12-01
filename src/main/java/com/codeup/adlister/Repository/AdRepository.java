package com.codeup.adlister.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.models.Ad;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

}