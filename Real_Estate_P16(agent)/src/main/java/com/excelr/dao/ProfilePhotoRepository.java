package com.excelr.dao;

import com.excelr.entity.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Integer> {
}
