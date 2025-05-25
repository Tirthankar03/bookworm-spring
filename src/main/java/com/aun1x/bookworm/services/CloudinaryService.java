package com.aun1x.bookworm.services;

public interface CloudinaryService {
    String uploadImage(String base64Image, String folder);
    void deleteImage(String imageUrl);
}
