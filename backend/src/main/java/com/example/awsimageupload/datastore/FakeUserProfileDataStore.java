package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("ee50eeaa-9108-4306-aa2c-26058bc7a2da"), "Samet", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("053981e1-6535-4ea4-8477-71a641d693b9"), "Sema", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("19191900-9983-40bc-8e95-3325e0c4c27a"), "Zort", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
