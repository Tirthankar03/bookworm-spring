package com.aun1x.bookworm.services.impl;
import com.cloudinary.Cloudinary;
import com.aun1x.bookworm.services.CloudinaryService;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret
    ) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    @Override
    public String uploadImage(String base64Image, String folder) {
        try {
            Map uploadResult = cloudinary.uploader().upload(base64Image, ObjectUtils.asMap("folder", folder));
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to Cloudinary", e);
        }
    }

    @Override
    public void deleteImage(String imageUrl) {
        try {
            String publicId = extractPublicId(imageUrl);
            if (publicId != null) {
                cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image from Cloudinary", e);
        }
    }


    private String extractPublicId(String url) {
        String[] parts = url.split("/");
        if (parts.length == 0) return null;

        String fileName = parts[parts.length - 1]; // public_id.jpg
        String folder = parts[parts.length - 2];   // "books"
        String publicId = folder + "/" + fileName.split("\\.")[0];
        return publicId;
    }
}
