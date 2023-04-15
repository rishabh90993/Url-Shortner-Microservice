package com.example.urlShortner.Url.Shortner.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UrlDto {
    String shortUrl;

    String originalUrl;
    Date createdAt;
}
