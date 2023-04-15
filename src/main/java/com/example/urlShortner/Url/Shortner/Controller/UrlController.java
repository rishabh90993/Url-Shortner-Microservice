package com.example.urlShortner.Url.Shortner.Controller;

import com.example.urlShortner.Url.Shortner.Dto.CreateShortUrlRequest;
import com.example.urlShortner.Url.Shortner.Dto.UrlDto;
import com.example.urlShortner.Url.Shortner.Entity.Url;
import com.example.urlShortner.Url.Shortner.Exception.DataNotFoundException;
import com.example.urlShortner.Url.Shortner.Service.UrlService;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping(value="/api/url")
    public ResponseEntity<UrlDto> create(HttpServletRequest request ,@RequestBody CreateShortUrlRequest createShortUrlRequest){
        // Creating a unique Key by hashing the original url and creating short url from it.
        String key = Hashing.murmur3_32().hashString(createShortUrlRequest.getUrl(), StandardCharsets.UTF_8).toString();
        String shortUrl = request.getRequestURL().toString().replace("/api/url","")+ "/" +key;

        // Saving new Short url and originalUrl in Database.
        Url savedUrl = new Url(key,createShortUrlRequest.getUrl(),shortUrl,0, Date.from(Instant.now()));
        UrlDto urlDto = urlService.createShortUrl(savedUrl);

        return new ResponseEntity<>(urlDto, HttpStatus.CREATED);
    }

    @GetMapping("/{key}")
    public RedirectView redirect(@PathVariable("key") String key){
        Url url = urlService.getShortUrlDetails(key);

        // Using Redirect view to redirect to original url.
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url.getOriginalUrl());
        return redirectView;
    }


}
