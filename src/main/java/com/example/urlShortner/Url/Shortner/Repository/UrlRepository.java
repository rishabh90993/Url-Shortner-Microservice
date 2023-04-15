package com.example.urlShortner.Url.Shortner.Repository;

import com.example.urlShortner.Url.Shortner.Entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,String> {

}
