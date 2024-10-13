package com.excelr.service;

import com.excelr.dao.ProfilePhotoRepository;
import com.excelr.entity.ProfilePhoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfilePhotoService {

    @Autowired
    private ProfilePhotoRepository pPRepo;

    // Save profile photo to the database
    public ProfilePhoto saveProfilePhoto(MultipartFile file) throws IOException {
        ProfilePhoto profilePhoto = new ProfilePhoto();
        profilePhoto.setProfilePhoto(file.getBytes());  // Store the image data as a byte array
        return pPRepo.save(profilePhoto);
    }

    // Retrieve profile photo by ID
    public ProfilePhoto getProfilePhotoById(int id) {
        return pPRepo.findById(id).orElse(null);
    }
}
