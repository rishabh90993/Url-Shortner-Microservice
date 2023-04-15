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
    Date createdAt;
}
