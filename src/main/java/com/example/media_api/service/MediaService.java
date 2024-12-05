package com.example.media_api.service;

import com.example.media_api.model.Media;
import com.example.media_api.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    // Get all media items
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    // Get a specific media item by ID
    public Optional<Media> getMediaById(String id) {
        return mediaRepository.findById(id);
    }

    // Add a new media item
    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    // Update an existing media item
    public Media updateMedia(String id, Media mediaDetails) {
        Media media = mediaRepository.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
        media.setTitle(mediaDetails.getTitle());
        media.setType(mediaDetails.getType());
        media.setGenre(mediaDetails.getGenre());
        media.setReleaseYear(mediaDetails.getReleaseYear());
        return mediaRepository.save(media);
    }

    // Delete a media item by ID
    public void deleteMedia(String id) {
        mediaRepository.deleteById(id);
    }

    // Filter media by type or genre
    public List<Media> getMediaByTypeOrGenre(String type, String genre) {
        if (type != null && genre != null) {
            return mediaRepository.findByTypeAndGenre(type, genre);
        } else if (type != null) {
            return mediaRepository.findByType(type);
        } else if (genre != null) {
            return mediaRepository.findByGenre(genre);
        } else {
            return mediaRepository.findAll();
        }
    }

    // Sort media by a specified field
    public List<Media> getSortedMedia(String sortBy) {
        return mediaRepository.findAll(Sort.by(sortBy));
    }

    // Paginate media items
    public Page<Media> getPaginatedMedia(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mediaRepository.findAll(pageable);
    }
}
