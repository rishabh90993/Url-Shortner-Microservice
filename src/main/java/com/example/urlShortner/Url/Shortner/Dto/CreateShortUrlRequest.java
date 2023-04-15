package com.example.urlShortner.Url.Shortner.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class CreateShortUrlRequest {
   private String url;
}
