package com.example.urlShortner.Url.Shortner.Service;

import com.example.urlShortner.Url.Shortner.Dto.UrlDto;
import com.example.urlShortner.Url.Shortner.Entity.Url;
import com.example.urlShortner.Url.Shortner.Exception.DataNotFoundException;
import com.example.urlShortner.Url.Shortner.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;

    public UrlDto createShortUrl(Url url){
        urlRepository.save(url);
        return new UrlDto(url.getShortUrl(),url.getCreatedAt());
    }


    public Url getShortUrlDetails(String key){
        Url url = urlRepository.findById(key).orElseThrow(()-> new DataNotFoundException("No Url Found."));
//        url.setLinkRedirectionCount(url.getLinkRedirectionCount()+1);
//        urlRepository.save(url);
        return url;
    }
}
