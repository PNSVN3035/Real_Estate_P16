package com.excelr.controller;

import com.excelr.entity.ProfilePhoto;
import com.excelr.service.ProfilePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/profile-photos")
public class ProfilePhotoController {

    @Autowired
    private ProfilePhotoService profilePhotoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfilePhoto(@RequestParam("file") MultipartFile file) {
        try {
            profilePhotoService.saveProfilePhoto(file);
            return ResponseEntity.status(HttpStatus.OK).body("Profile photo uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile photo");
        }
    }

    // Endpoint to retrieve a profile photo by ID
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getProfilePhoto(@PathVariable int id) {
        ProfilePhoto profilePhoto = profilePhotoService.getProfilePhotoById(id);
        if (profilePhoto != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "image/jpeg");  // Set appropriate content type based on the image type
            return new ResponseEntity<>(profilePhoto.getProfilePhoto(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
