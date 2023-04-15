package com.example.urlShortner.Url.Shortner.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "url_table")
public class Url {
    @Id
    String id;
    @NonNull
    String originalUrl;
    @NonNull
    String shortUrl;
    Integer linkRedirectionCount;
    @CreatedDate
    Date createdAt;
}
