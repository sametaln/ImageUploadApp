package com.example.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        // Check if image is not empty.
        if (file.isEmpty()) {
            throw new IllegalStateException("File cannot be empty");
        }
        // If file is an image and user exists in database then grab some metadata from file if any
        if(!Arrays.asList("image/png", "image/jpeg", "image/gif").contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image");
        }
        userProfileDataAccessService.getUserProfiles().stream();
        // and save it to S3 and update database with image url.
    }
}
