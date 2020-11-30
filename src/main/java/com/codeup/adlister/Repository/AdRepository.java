package com.codeup.adlister.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.adlister.JPA.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

}
