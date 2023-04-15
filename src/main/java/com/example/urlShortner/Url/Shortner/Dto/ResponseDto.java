package com.example.urlShortner.Url.Shortner.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseDto<T> {
    // 1 means success and 0 error
    Integer status;
    String message;
    T data;

}
