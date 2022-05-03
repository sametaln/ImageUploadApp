package com.example.awsimageupload.bucket;

public enum BucketName {

    PROFILE_IMAGE("image-upload-smt");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
