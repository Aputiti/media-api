package com.example.media_api.controller;

import com.example.media_api.model.Media;
import com.example.media_api.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    // Get all media items
    @GetMapping
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    // Get a specific media item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable String id) {
        Optional<Media> media = mediaService.getMediaById(id);
        return media.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Add a new media item
    @PostMapping
    public Media addMedia(@RequestBody Media media) {
        return mediaService.addMedia(media);
    }

    // Update an existing media item
    @PutMapping("/{id}")
    public ResponseEntity<Media> updateMedia(@PathVariable String id, @RequestBody Media mediaDetails) {
        Media updatedMedia = mediaService.updateMedia(id, mediaDetails);
        return ResponseEntity.ok(updatedMedia);
    }

    // Delete a media item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable String id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }

    // Filter media by type or genre
    @GetMapping("/filter")
    public List<Media> getMediaByTypeOrGenre(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String genre) {
        return mediaService.getMediaByTypeOrGenre(type, genre);
    }

    // Sort media by a specified field
    @GetMapping("/sort")
    public List<Media> getSortedMedia(@RequestParam String sortBy) {
        return mediaService.getSortedMedia(sortBy);
    }

    // Paginate media items
    @GetMapping("/page")
    public Page<Media> getPaginatedMedia(
            @RequestParam int page,
            @RequestParam int size) {
        return mediaService.getPaginatedMedia(page, size);
    }
}
