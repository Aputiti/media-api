package com.example.media_api.repository;

import com.example.media_api.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MediaRepository extends MongoRepository<Media, String> {
    List<Media> findByType(String type);

    List<Media> findByGenre(String genre);

    List<Media> findByTypeAndGenre(String type, String genre);
}
